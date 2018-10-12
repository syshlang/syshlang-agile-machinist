/*
 * Copyright (c) 2018. syshlang
 * @File: WebInterceptor.java
 * @Description:
 * @Author: sunys
 * @Date: 18-9-20 上午9:58
 * @since:
 */

package com.syshlang.system.web.interceptor;

import com.syshlang.common.util.enumutil.EnumUtil;
import com.syshlang.common.util.properties.PropertiesFileUtil;
import com.syshlang.system.api.common.SystemConstant;
import org.apache.commons.lang3.StringUtils;
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
        String systemName = PropertiesFileUtil.getInstance().get("system.name");
        if (StringUtils.isBlank(systemName)){
            throw  EnumUtil.productException(SystemConstant.SYSTEM_EXCEPTION.EXCEPTION_PARAM,new String[]{"system.name"},null);
        }
        request.setAttribute("system_name", systemName);

        String profileEnv = PropertiesFileUtil.getInstance().get("profile.env");
        if (StringUtils.isBlank(systemName)){
            throw  EnumUtil.productException(SystemConstant.SYSTEM_EXCEPTION.EXCEPTION_PARAM,new String[]{"profile.env"},null);
        }
        LOGGER.info("当前系统环境："+EnumUtil.getEnumDesc(SystemConstant.SYSTEM_ENV.class,profileEnv));
        request.setAttribute("system_env", EnumUtil.getEnumDesc(SystemConstant.SYSTEM_ENV.class,profileEnv));

        String uiPath = PropertiesFileUtil.getInstance().get("ui.path");
        if (StringUtils.isBlank(systemName)){
            throw  EnumUtil.productException(SystemConstant.SYSTEM_EXCEPTION.EXCEPTION_PARAM,new String[]{"ui.path"},null);
        }

        String contextPath = request.getContextPath();
        request.setAttribute("basePath", contextPath);
        uiPath = contextPath+"/"+uiPath;
        request.setAttribute("uiPath", uiPath);
        return true;
    }
}
