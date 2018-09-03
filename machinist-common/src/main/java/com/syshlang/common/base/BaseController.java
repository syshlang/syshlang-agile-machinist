/*
 * Copyright (c) 2018. syshlang
 * @File: BaseController.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-20 下午10:41
 * @since:
 */

package com.syshlang.common.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sunys
 */
public abstract class BaseController {
    protected final static Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    @ExceptionHandler
    public String exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception exception){
        LOGGER.error("统一异常处理：", exception);
        return doExceptionHandler(request,response,exception);
    }

    protected abstract String doExceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception exception);

    /**
     * 返回jsp视图
     * @param path
     * @return
     */
    public static String jsp(String path) {
        return path.concat(".jsp");
    }

    /**
     * 返回html视图
     * @param path
     * @return
     */
    public static String thymeleaf(String path) {
        return path.concat(".html");
    }

    /**
     * 返回freemarker视图
     * @param path
     * @return
     */
    public static String ftl(String path) {
        return path.concat(".ftl");
    }
}
