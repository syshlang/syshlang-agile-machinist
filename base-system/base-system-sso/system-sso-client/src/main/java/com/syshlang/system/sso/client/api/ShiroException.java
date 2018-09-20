/*
 * Copyright (c) 2018. syshlang
 * @File: ShiroException.java
 * @Description:
 * @Author: sunys
 * @Date: 18-9-20 下午9:59
 * @since:
 */

package com.syshlang.system.sso.client.api;

import com.syshlang.common.base.BaseException;

/**
 * @author sunys
 */
public class ShiroException extends BaseException {
    public ShiroException(String module, Integer code, Object[] args, String defaultMessage) {
        super(module, code, args, defaultMessage);
    }

    public ShiroException(String module, Integer code, Object[] args) {
        super(module, code, args);
    }

    public ShiroException(String module, String defaultMessage) {
        super(module, defaultMessage);
    }

    public ShiroException(Integer code, Object[] args) {
        super(code, args);
    }

    public ShiroException(String defaultMessage) {
        super(defaultMessage);
    }

    public ShiroException(String defaultMessage, Throwable throwable) {
        super(defaultMessage, throwable);
    }

    public ShiroException(Throwable throwable) {
        super(throwable);
    }

    @Override
    public Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
