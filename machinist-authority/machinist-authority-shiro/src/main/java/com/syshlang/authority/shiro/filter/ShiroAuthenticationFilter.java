/*
 * Copyright (c) 2018. syshlang
 * @File: ShiroAuthenticationFilter.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-27 下午10:10
 * @since:
 */

package com.syshlang.authority.shiro.filter;


import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 重写authc验证过滤器
 * @author sunys
 */
public class ShiroAuthenticationFilter extends AuthenticationFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroAuthenticationFilter.class);

    private String localSessionKeyPrefix="SHIRO_CLIENT_SESSION_KEY_PREFIX";

    /**
     * 表示当访问拒绝时是否已经处理了；
     * 如果返回true表示需要继续处理；
     * 如果返回false表示该拦截器实例已经处理了，将直接返回即可。
     * @param servletRequest
     * @param servletResponse
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        return true;
    }

    public void setLocalSessionKeyPrefix(String localSessionKeyPrefix) {
        this.localSessionKeyPrefix = localSessionKeyPrefix;
    }

    public String getLocalSessionKeyPrefix() {
        return localSessionKeyPrefix;
    }
}
