/*
 * Copyright (c) 2018. syshlang
 * @File: BaseException.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-15 下午10:32
 * @since:
 */

package com.syshlang.common.base;

import com.syshlang.common.model.exception.ExceptionVO;
import com.syshlang.common.util.MyMessageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.Arrays;


/**
 * @author sunys
 */
public class BaseException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private static Logger log = LoggerFactory.getLogger(BaseException.class);

    /**
     * 所属模块
     */
    private String module;

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误码对应的参数
     */
    private Object[] args;

    /**
     * 错误消息
     */
    private String defaultMessage;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public BaseException(String module, String code, Object[] args, String defaultMessage) {
        this.module = module;
        this.code = code;
        this.args = args;
        this.defaultMessage = defaultMessage;
    }

    public BaseException(String module, String code, Object[] args)
    {
        this(module, code, args, null);
    }

    public BaseException(String module, String defaultMessage)
    {
        this(module, null, null, defaultMessage);
    }

    public BaseException(String code, Object[] args)
    {
        this(null, code, args, null);
    }

    public BaseException(String defaultMessage)
    {
        this(null, null, null, defaultMessage);
    }

    public BaseException(String defaultMessage,Throwable throwable){
        super(defaultMessage);
        throwable.printStackTrace();
    }

    public BaseException(Throwable throwable){
        super(throwable);
        throwable.printStackTrace();
    }

    @Override
    public String getMessage() {
        String message = null;
        if (!StringUtils.isEmpty(code)) {
            message = MyMessageUtils.message(code, args);
        }
        if (message == null) {
            message = defaultMessage;
        }
        return message;
    }

    @Override
    public String toString() {
        return "BaseException{" +
                "module='" + module + '\'' +
                ", code='" + code + '\'' +
                ", args=" + Arrays.toString(args) +
                ", defaultMessage='" + defaultMessage + '\'' +
                '}';
    }
}
