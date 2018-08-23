/*
 * Copyright (c) 2018. syshlang
 * @File: ApiResultConstant.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-19 上午12:48
 * @since:
 */

package com.syshlang.api.common;

/**
 * api系统接口结果常量枚举类
 * @author sunys
 */

public enum ApiResultConstant {
    /**
     * 成功
     */
    SUCCESS(1001, "success");

    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ApiResultConstant(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
