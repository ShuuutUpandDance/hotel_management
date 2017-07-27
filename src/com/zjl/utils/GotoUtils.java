package com.zjl.utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跳转工具类
 */
public class GotoUtils {
    public static void goTo(HttpServletRequest request, HttpServletResponse response, Object uri) {
        try {
            if (uri instanceof RequestDispatcher) {
                ((RequestDispatcher) uri).forward(request, response);
            } else if (uri instanceof String) {
                response.sendRedirect(request.getContextPath() + uri);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
