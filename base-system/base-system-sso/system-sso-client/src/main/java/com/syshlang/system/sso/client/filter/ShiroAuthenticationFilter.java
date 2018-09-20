/*
 * Copyright (c) 2018. syshlang
 * @File: ShiroAuthenticationFilter.java
 * @Description:
 * @Author: sunys
 * @Date: 18-9-20 下午9:59
 * @since:
 */

package com.syshlang.system.sso.client.filter;


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
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        /*Subject subject = getSubject(request, response);
        if (subject != null)
        {
            subject.logout();
        }
        saveRequestAndRedirectToLogin(request, response);*/
        return true;
    }

    /**
     * 表示是否允许访问；mappedValue就是[urls]配置中拦截器参数部分，如果允许访问返回true，否则false；
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return super.isAccessAllowed(request, response, mappedValue);
    }

    public void setLocalSessionKeyPrefix(String localSessionKeyPrefix) {
        this.localSessionKeyPrefix = localSessionKeyPrefix;
    }

    public String getLocalSessionKeyPrefix() {
        return localSessionKeyPrefix;
    }
}
