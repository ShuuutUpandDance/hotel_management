package com.zjl.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 处理请求数据封装
 */
public class WebUtils {
    public static <T> T copyToBean(HttpServletRequest request, Class<T> clazz) {
        try {
            //创建返回值实例
            T t = clazz.newInstance();
            //使用组件，一步搞定
            BeanUtils.populate(t, request.getParameterMap());
            return t;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
