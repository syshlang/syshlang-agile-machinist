/*
 * Copyright (c) 2018. syshlang
 * @File: BaseResult.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-16 上午12:30
 * @since:
 */

package com.syshlang.common.base;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 统一返回结果类
 * @author sunys
 */

@XmlRootElement
public class BaseResult <T> implements Serializable {
    private static final long serialVersionUID = 293025560562946952L;

    private Integer code;

    private String desc;

    public Object data;

    public BaseResult(){}


    public BaseResult(Integer code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public BaseResult(Integer code, String desc, Object data) {
        this.code = code;
        this.desc = desc;
        this.data = data;
    }

    public BaseResult(BaseResultCode c){
        this.code = c.getCode();
        this.desc = c.getDesc();
    }

    public BaseResult(Exception e) {
        this.desc = e.getMessage();
        this.code = BaseResultCode.EXCEPTION.getCode();
    }

    public BaseResult(String errorMsg) {
        this.desc = errorMsg;
        this.code = BaseResultCode.EXCEPTION.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
