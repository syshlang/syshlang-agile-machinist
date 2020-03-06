/*
 * Copyright (c) 2020.
 * @File: LoginFilter.java
 * @Description:
 * @Author: sunys
 * @Date: 2020/2/27 下午2:36
 * @since:
 */

package com.syshlang.system.sso.client.filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sunys
 */
public class LoginFilter extends AccessControlFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        System.out.println(request.getRequestURL());
        if(SecurityUtils.getSubject().isAuthenticated()
                || isLoginRequest(servletRequest, servletResponse)){
            return true;
        }
        if (request.getHeader("x-requested-with") != null
                && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("session-status", "timeout");
            return true;
        }
        return false;
    }


    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        saveRequestAndRedirectToLogin(servletRequest, servletResponse);
        return false;
    }
}
