/*
 * Copyright (c) 2018. syshlang
 * @File: ShiroController.java
 * @Description:
 * @Author: sunys
 * @Date: 18-9-20 下午9:59
 * @since:
 */

package com.syshlang.system.sso.common.api;

import com.syshlang.common.base.BaseController;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.InvalidSessionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sunys
 */
public class ShiroController extends BaseController {
    protected final static Logger LOGGER = LoggerFactory.getLogger(ShiroController.class);

    @Override
    protected String doExceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception exception) {
        LOGGER.error("详情：", exception);
        request.setAttribute("ex", exception);
        if (null != request.getHeader("X-Requested-With")
                && "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))) {
            request.setAttribute("requestHeader", "ajax");
        }
        // shiro没有权限异常
        if (exception instanceof UnauthorizedException) {
            return "/403.jsp";
        }
        // shiro会话已过期异常
        if (exception instanceof InvalidSessionException) {
            return "/error.jsp";
        }
        return "/error.jsp";
    }
}
