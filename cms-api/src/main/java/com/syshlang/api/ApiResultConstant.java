/*
 * Copyright (c) 2018. syshlang
 * @File: ApiResultConstant.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-16 上午12:44
 * @since:
 */

package com.syshlang.api;

/**
 * api系统接口结果常量枚举类
 * @author sunys
 */

public enum ApiResultConstant {
    /**
     * 成功
     */
    SUCCESS("1001", "success");

    private String code;
    private String message;

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

    ApiResultConstant(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
