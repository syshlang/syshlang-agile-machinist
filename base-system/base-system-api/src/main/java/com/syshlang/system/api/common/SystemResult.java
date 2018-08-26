/*
 * Copyright (c) 2018. syshlang
 * @File: SystemResult.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-27 上午12:27
 * @since:
 */

package com.syshlang.system.api.common;

import com.syshlang.api.common.ApiResult;
import com.syshlang.api.common.ApiResultCode;
import com.syshlang.common.base.BaseResultCode;
import com.syshlang.common.util.MessageSourceHelper;
import org.apache.commons.lang.StringUtils;

/**
 * @author sunys
 */
public class SystemResult extends ApiResult {
    private static final long serialVersionUID = -7087514909591138990L;

    private String  resource;

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public  SystemResult(){}

    public SystemResult(String resource) {
        this.resource = resource;
    }

    public SystemResult(Integer code, String message, Object data, String resource) {
        super(code, message, data);
        this.resource = resource;
    }

    public SystemResult(Integer code, String message, String resource) {
        super(code, message);
        this.resource = resource;
    }

    public SystemResult(SystemResultCode systemResultCode, Object data, String resource) {
        this.code = systemResultCode.getCode();
        this.desc = systemResultCode.getDesc();
        this.data = data;
        this.resource = resource;
    }

    public SystemResult(SystemResultCode systemResultCode, String resource) {
        this.code = systemResultCode.getCode();
        this.desc = systemResultCode.getDesc();
        this.resource = resource;
    }

    public SystemResult(Integer code, String message, Object data) {
        super(code, message, data);
    }

    public SystemResult(Integer code, String message) {
        super(code, message);
    }

    public SystemResult(SystemResultCode systemResultCode, Object data) {
        super(systemResultCode.getCode(), systemResultCode.getDesc(), data);
    }

    public SystemResult(SystemResultCode systemResultCode) {
        this.code = systemResultCode.getCode();
        this.resource = systemResultCode.getResource();
        if (StringUtils.isBlank(systemResultCode.getResource())){
            this.desc = systemResultCode.getDesc();
        }else{
            String message = MessageSourceHelper.getMessage(systemResultCode.getResource());
            if (StringUtils.isNotBlank(message)){
                this.desc = message;
            }else{
                this.desc = systemResultCode.getDesc();
            }
        }
    }


    @Override
    public String toString() {
        return "SystemResult{" +
                "resource='" + resource + '\'' +
                ", code=" + code +
                ", desc='" + desc + '\'' +
                ", data=" + data +
                '}';
    }
}
