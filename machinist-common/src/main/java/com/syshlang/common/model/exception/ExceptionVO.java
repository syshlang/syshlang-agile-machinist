/*
 * Copyright (c) 2018. syshlang
 * @File: ExceptionVO.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-15 下午11:46
 * @since:
 */

package com.syshlang.common.model.exception;

/**
 * @author sunys
 */
public class ExceptionVO {
    /**
     * 异常编号
     */
    private String id;

    /**
     * 异常摘要信息
     */
    private String info;

    /**
     * 异常排查建议
     */
    private String suggest;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    @Override
    public String toString() {
        return "ExceptionVO{" +
                "id='" + id + '\'' +
                ", info='" + info + '\'' +
                ", suggest='" + suggest + '\'' +
                '}';
    }
}
