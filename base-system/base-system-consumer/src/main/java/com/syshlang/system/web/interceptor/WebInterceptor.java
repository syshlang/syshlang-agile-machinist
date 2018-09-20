/*
 * Copyright (c) 2018. syshlang
 * @File: WebInterceptor.java
 * @Description:
 * @Author: sunys
 * @Date: 18-9-20 上午9:58
 * @since:
 */

package com.syshlang.system.web.interceptor;

import com.syshlang.common.util.properties.PropertiesFileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sunys
 * @date 2018/9/20
 */
public class WebInterceptor  extends HandlerInterceptorAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOGGER.info("WebInterceptor#preHandle");
        // 过滤ajax
        if (null != request.getHeader("X-Requested-With") && "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))) {
            return true;
        }
        String appName = PropertiesFileUtil.getInstance().get("app.name");
        String profileEnv = PropertiesFileUtil.getInstance().get("profile.env");
        String uiPath = PropertiesFileUtil.getInstance().get("ui.path");
        request.setAttribute("appName", appName);
        request.setAttribute("profileEnv", profileEnv);
        request.setAttribute("uiPath", uiPath);
        return true;
    }
}
