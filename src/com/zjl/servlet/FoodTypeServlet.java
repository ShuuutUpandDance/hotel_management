package com.zjl.servlet;

import com.zjl.entity.FoodType;
import com.zjl.factory.BeanFactory;
import com.zjl.service.IFoodTypeService;
import com.zjl.utils.GotoUtils;
import com.zjl.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 菜系管理servlet
 * a. 添加菜系
 * b. 菜系列表展示
 * c. 进入更新页面
 * d. 更新
 * e. 删除
 */
public class FoodTypeServlet extends HttpServlet {

    //调用的service
    private IFoodTypeService foodTypeService = BeanFactory.getInstance("foodtypeService", IFoodTypeService.class);
    private Object uri;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取操作的类型
        String method = request.getParameter("method");
        //判断
        if ("addFoodType".equals(method)) { //添加操作
            addFoodType(request, response);
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

            List<FoodType>list = foodTypeService.getAll(keyword);

            request.setAttribute("listFoodType", list);
            //3. 跳转到列表展示
            uri = request.getRequestDispatcher("/sys/type/foodtype_list.jsp");
        } catch (Exception e) {
            uri = "/error/error.jsp";
            e.printStackTrace();
        }
        GotoUtils.goTo(request, response, uri);
    }

    //a. 添加菜系
    private void addFoodType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //1. 获取请求数据封装
            FoodType ft = WebUtils.copyToBean(request, FoodType.class);
            //2. 调用service处理业务逻辑
            foodTypeService.save(ft);
            //3. 跳转到列表展示
            uri = request.getRequestDispatcher("/foodType?method=list");
        } catch (Exception e) {
            uri = "/error/error.jsp";
            e.printStackTrace();
        }
        //统一转发uri
        GotoUtils.goTo(request, response, uri);
    }

    //b. 菜系列表展示
    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //调用service查询
            List<FoodType> list = foodTypeService.getAll();
            //保存
            request.setAttribute("listFoodType", list);
            //跳转到菜系列表页面
            uri = request.getRequestDispatcher("/sys/type/foodtype_list.jsp");
        } catch (Exception e) {
            uri = "/error/error.jsp";
            e.printStackTrace();
        }
        GotoUtils.goTo(request, response, uri);
    }

    //c. 进入更新视图
    private void viewUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            //1. 获取请求id
            int id = Integer.parseInt(request.getParameter("id"));
            //2. 根据id查询的对象
            FoodType ft = foodTypeService.findById(id);
            //3. 保存对象到请求数据
            request.setAttribute("foodType", ft);

            uri = request.getRequestDispatcher("/sys/type/foodtype_update.jsp");
        } catch (Exception e) {
            uri = "/error/error.jsp";
            e.printStackTrace();
        }
        //4. 跳转
        GotoUtils.goTo(request, response, uri);
    }

    //d. 更新
    private void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //请求数据封装
            FoodType ft = WebUtils.copyToBean(request, FoodType.class);
            //调用service
            foodTypeService.update(ft);

            uri = "/foodType?method=list";
        } catch (Exception e) {
            uri = "/error/error.jsp";
            e.printStackTrace();
        }
        //没给request中保存数据，所以重定向即可
        GotoUtils.goTo(request, response, uri);
    }

    //e. 删除
    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //获取请求id
            int id = Integer.parseInt(request.getParameter("id"));
            //调用service
            foodTypeService.delete(id);

            uri = "/foodType?method=list";
        } catch (Exception e) {
            uri = "/error/error.jsp";
            e.printStackTrace();
        }
        //没向request中保存数据，所以重定向即可
        GotoUtils.goTo(request, response, uri);
    }
}
