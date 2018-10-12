/*
 * Copyright (c) 2018. syshlang
 * @File: BaseException.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-15 下午10:32
 * @since:
 */

package com.syshlang.common.base;

import com.syshlang.common.util.MessageSourceHelper;
import com.syshlang.common.util.MyMessageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;


/**
 * @author sunys
 */
public class BaseException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private static Logger log = LoggerFactory.getLogger(BaseException.class);

    /**SpringUtils.java
     * 所属模块
     */
    private String module;

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误编码
     */
    private String codeStr;

    /**
     * 错误码对应的参数
     */
    private Object[] args;

    /**
     * 错误消息
     */
    private String defaultMessage;

    public BaseException() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getCodeStr() {
        return codeStr;
    }

    public void setCodeStr(String codeStr) {
        this.codeStr = codeStr;
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

    public BaseException(String module, Integer code,String codeStr, Object[] args, String defaultMessage) {
        this.module = module;
        this.code = code;
        this.codeStr = codeStr;
        this.args = args;
        this.defaultMessage = defaultMessage;
    }

    public BaseException(String module, Integer code,String codeStr, Object[] args)
    {
        this(module, code,codeStr, args, null);
    }

    public BaseException(String module, String defaultMessage)
    {
        this(module, null, null,null, defaultMessage);
    }

    public BaseException(Integer code, Object[] args)
    {
        this(null, code,null, args, null);
    }

    public BaseException(String defaultMessage)
    {
        this(null, null, null,null, defaultMessage);
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
        if (codeStr != null) {
            message = MessageSourceHelper.getMessage(String.valueOf(codeStr), args);
        }
        if (message == null) {
            message = defaultMessage;
        }
        return message;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    @Override
    public String toString() {
        return this.getClass()+"{" +
                "module='" + module + '\'' +
                ", code='" + code + '\'' +
                ", args=" + Arrays.toString(args) +
                ", defaultMessage='" + defaultMessage + '\'' +
                '}';
    }
}
