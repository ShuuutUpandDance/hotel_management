package com.zjl.servlet;

import com.zjl.entity.DinnerTable;
import com.zjl.factory.BeanFactory;
import com.zjl.service.IDinnerTableService;
import com.zjl.utils.GotoUtils;
import com.zjl.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 餐桌servlet
 * 1. 添加
 * 2. 删除
 * 3. 预定
 * 4. 取消
 * 5. 查找
 */
public class DinnerTableServlet extends HttpServlet {
    private IDinnerTableService dinnerTableService = BeanFactory.getInstance("dinnerTableService", IDinnerTableService.class);
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
        } else if ("list".equals(method)) { //列表展示
            list(request, response);
        } else if ("delete".equals(method)) { //删除
            delete(request, response);
        } else if ("search".equals(method)) { //搜索
            search(request, response);
        } else if ("order".equals(method)) { //预定
            order(request, response);
        } else if ("cancel".equals(method)) { //取消预定
            cancel(request, response);
        }
    }

    private void cancel(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            dinnerTableService.cancelOrder(id);
            //3. 跳转到列表展示
            uri = "/table?method=list";
        } catch (Exception e) {
            uri = "/error/error.jsp";
            e.printStackTrace();
        }
        //统一转发uri
        GotoUtils.goTo(request, response, uri);
    }

    private void order(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            dinnerTableService.order(id);
            //3. 跳转到列表展示
            uri = "/table?method=list";
        } catch (Exception e) {
            uri = "/error/error.jsp";
            e.printStackTrace();
        }
        //统一转发uri
        GotoUtils.goTo(request, response, uri);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            dinnerTableService.delete(id);
            //3. 跳转到列表展示
            uri = "/table?method=list";
        } catch (Exception e) {
            uri = "/error/error.jsp";
            e.printStackTrace();
        }
        //统一转发uri
        GotoUtils.goTo(request, response, uri);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        try {
            String keyword = request.getParameter("keyword");

            List<DinnerTable>dinnerTableList = dinnerTableService.getAll(keyword);
            request.setAttribute("dinnerTableList", dinnerTableList);
            //3. 跳转到列表展示
            uri = request.getRequestDispatcher("/sys/boardList.jsp");
        } catch (Exception e) {
            uri = "/error/error.jsp";
            e.printStackTrace();
        }
        //统一转发uri
        GotoUtils.goTo(request, response, uri);
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        try {
            //1. 获取请求数据封装
            DinnerTable dinnerTable = WebUtils.copyToBean(request, DinnerTable.class);
            //2. 调用service处理业务逻辑
            dinnerTableService.save(dinnerTable);
            //3. 跳转到列表展示
            uri = "/table?method=list";
        } catch (Exception e) {
            uri = "/error/error.jsp";
            e.printStackTrace();
        }
        //统一转发uri
        GotoUtils.goTo(request, response, uri);
    }

    private void list(HttpServletRequest request, HttpServletResponse response) {
        try {
            //调用service查询
            List<DinnerTable> list = dinnerTableService.getAll();
            System.out.println(list);
            //保存
            request.setAttribute("dinnerTableList", list);
            //跳转到餐桌列表页面
            uri = request.getRequestDispatcher("/sys/boardList.jsp");
        } catch (Exception e) {
            uri = "/error/error.jsp";
            e.printStackTrace();
        }
        GotoUtils.goTo(request, response, uri);
    }


}
