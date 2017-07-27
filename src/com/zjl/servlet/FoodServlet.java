package com.zjl.servlet;

import com.zjl.entity.Food;
import com.zjl.entity.FoodType;
import com.zjl.factory.BeanFactory;
import com.zjl.service.IFoodService;
import com.zjl.service.IFoodTypeService;
import com.zjl.utils.GotoUtils;
import com.zjl.utils.PageBean;
import com.zjl.utils.WebUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class FoodServlet extends HttpServlet {
    private IFoodService foodService = BeanFactory.getInstance("foodService", IFoodService.class);
    private IFoodTypeService foodTypeService = BeanFactory.getInstance("foodtypeService", IFoodTypeService.class);
    private Object uri;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取操作的类型
        String method = request.getParameter("method");
        //判断
        if ("save".equals(method)) { //添加操作
            save(request, response);
        } else if ("viewSave".equals(method)){ //进入添加视图
            viewSave(request, response);
        } else if ("list".equals(method)) { //列表展示
            list(request, response);
        } else if ("viewUpdate".equals(method)) { //进入更新页面
            viewUpdate(request, response);
        } else if ("update".equals(method)) { //更新
            update(request, response);
        } else if ("delete".equals(method)) { //删除
            delete(request, response);
        } else if ("search".equals(method)) { //搜索
            search(request, response);
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        try {
            String keyword = request.getParameter("keyword");

//获得当前页参数（第一次访问时为null）
            String currentPage = request.getParameter("currentPage");
            if (currentPage == null || "".equals(currentPage.trim())) {
                //第一次访问，置为1
                currentPage = "1";
            }
            int curPage = Integer.parseInt(currentPage);

            //创建pagebean对象，设置当前页参数，调用service
            PageBean<Food>pageBean = new PageBean<>();
            pageBean.setCurrentPage(curPage);
            foodService.getAll(pageBean, keyword);

            System.out.println(pageBean.getPageData());

            request.setAttribute("pageBean", pageBean);
            uri = request.getRequestDispatcher("/sys/foodList.jsp");
        } catch (Exception e) {
            uri = "/error/error.jsp";
            throw new RuntimeException(e);
        }
        GotoUtils.goTo(request, response, uri);
    }

    private void viewSave(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<FoodType>foodTypeList = foodTypeService.getAll();
            request.setAttribute("foodTypeList", foodTypeList);

            uri = request.getRequestDispatcher("/sys/saveFood.jsp");
        } catch (Exception e) {
            uri = "/error/error.jsp";
            throw new RuntimeException(e);
        }
        GotoUtils.goTo(request, response, uri);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        try {
            System.out.println("提交进入update");

            DiskFileItemFactory fac = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(fac);
            //设置单个文件最大
            upload.setFileSizeMax(30 * 1024 * 1024);
            //设置总文件最大
            upload.setSizeMax(60 * 1024 * 1024);

            Food food = new Food();
            Class clazz = food.getClass();
            if (upload.isMultipartContent(request)) {
                try {
                    List<FileItem>list = upload.parseRequest(request);

                    for (FileItem fileItem : list) {
                        if (fileItem.isFormField()) { // 普通表单
                            String fieldName = fileItem.getFieldName();
                            String value = fileItem.getString();
                            if ("Id".equals(fieldName)||"FoodType_id".equals(fieldName)) {
                                Method setter = clazz.getDeclaredMethod("set"+fieldName, int.class);
                                setter.invoke(food, Integer.parseInt(value));
                            } else if ("FoodName".equals(fieldName) || "Remark".equals(fieldName) || "Img".equals(fieldName)) {
                                // fileItem的getString是按iso8859-1编码的，这里需要转码
                                Method setter = clazz.getDeclaredMethod("set"+fieldName, String.class);
                                byte[] source = value.getBytes("iso8859-1");
                                value = new String(source,"utf-8");
                                setter.invoke(food, value);
                            } else if ("Price".equals(fieldName) || "Mprice".equals(fieldName)) {
                                Method setter = clazz.getDeclaredMethod("set"+fieldName, double.class);
                                setter.invoke(food, Double.parseDouble(value));
                            }
                        } else {
////                            处理文件上传
//                            //获取文件名
//                            String name = fileItem.getName();
//                            System.out.println(name);
//                            if (name != null || (!"".equals(name.trim()))) {
//                                //把图片名赋给food对象
//                                food.setImg(name);
////                            String basePath = getServletContext().getRealPath("/sys/upload_img");
//                                String basePath = "E:\\hotel_img";
//                                //创建文件对象
//                                File file = new File(basePath, name);
//                                fileItem.write(file); //写文件
//                                fileItem.delete(); //删除临时文件
//                            }
                        }
                    }
                } catch (FileUploadException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                //不处理
            }

            System.out.println(food);
            //调用service
            foodService.update(food);

            uri = "/food?method=list";
        } catch (Exception e) {
            uri = "/error/error.jsp";
            e.printStackTrace();
        }
        //没给request中保存数据，所以重定向即可
        GotoUtils.goTo(request, response, uri);
    }


    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) {
        try {
            //从请求中获取id
            int id = Integer.parseInt(request.getParameter("id"));

            Food food = foodService.findById(id);

            request.setAttribute("food", food);

            List<FoodType>foodTypeList = foodTypeService.getAll();
            request.setAttribute("foodTypeList", foodTypeList);

//            String basePath = getServletContext().getRealPath("/sys/upload_img");
            String basePath = "E:\\hotel_img";
            //把图片的根目录也传过去
            request.setAttribute("basePath", basePath);

            uri = request.getRequestDispatcher("/sys/updateFood.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            uri = "/error/error.jsp";
        }
        //跳转
        GotoUtils.goTo(request, response, uri);
    }

    private void list(HttpServletRequest request, HttpServletResponse response) {
        try {
            //获得当前页参数（第一次访问时为null）
            String currentPage = request.getParameter("currentPage");
            if (currentPage == null || "".equals(currentPage.trim())) {
                //第一次访问，置为1
                currentPage = "1";
            }
            int curPage = Integer.parseInt(currentPage);

            //创建pagebean对象，设置当前页参数，调用service
            PageBean<Food>pageBean = new PageBean<>();
            pageBean.setCurrentPage(curPage);
            foodService.getAll(pageBean);

            System.out.println(pageBean.getPageData());

            request.setAttribute("pageBean", pageBean);

            uri = request.getRequestDispatcher("/sys/foodList.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            uri = "/error/error.jsp";
        }
        //跳转
        GotoUtils.goTo(request, response, uri);
    }



    private void save (HttpServletRequest request, HttpServletResponse response) {
        try {
            //封装请求数据,如果表格是multipart的话就不能用beanutils
            Food food = WebUtils.copyToBean(request, Food.class);
            System.out.println(food);

            foodService.save(food);

            uri = request.getRequestDispatcher("/food?method=list");
        } catch (Exception e) {
            e.printStackTrace();
            uri = "/error/error.jsp";
        }
        //跳转
        GotoUtils.goTo(request, response, uri);
    }
}
