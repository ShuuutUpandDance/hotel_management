package com.zjl.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        System.out.println("进入编码过滤器");
        //转型
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
