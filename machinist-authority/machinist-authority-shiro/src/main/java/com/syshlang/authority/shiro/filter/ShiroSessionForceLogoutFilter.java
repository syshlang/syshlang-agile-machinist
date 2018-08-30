/*
 * Copyright (c) 2018. syshlang
 * @File: ShiroSessionForceLogoutFilter.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-27 下午10:11
 * @since:
 */

package com.syshlang.authority.shiro.filter;

import org.apache.shiro.session.Session;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 强制退出会话过滤器
 * @author sunys
 */
public class ShiroSessionForceLogoutFilter extends AccessControlFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroSessionForceLogoutFilter.class);
    private String forceLogout="SHIRO_FORCE_LOGOUT";

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        return false;
    }

    public void setForceLogout(String forceLogout) {
        this.forceLogout = forceLogout;
    }

    public String getForceLogout() {
        return forceLogout;
    }
}
