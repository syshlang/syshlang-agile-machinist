/*
 * Copyright (c) 2018. syshlang
 * @File: BaseResult.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-16 上午12:30
 * @since:
 */

package com.syshlang.common.base;

/**
 * 统一返回结果类
 * @author sunys
 */
public class BaseResult {


    /**
     * 状态码：1001 成功，其他为失败
     */
    public String code;

    /**
     * 成功为success，其他为失败原因
     */
    public String message;

    /**
     * 数据结果集
     */
    public Object data;

    public BaseResult(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
