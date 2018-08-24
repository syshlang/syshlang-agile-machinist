/*
 * Copyright (c) 2018. syshlang
 * @File: CmsResultCode.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-24 上午11:48
 * @since:
 */

package com.syshlang.cms.api.common;

/**
 * Created by sunys on 2018/8/24.
 */
public enum CmsResultCode {
    /**
     * 用户名不能为空
     */
    EMPTY_USERNAME(10101, CmsConstant.RESOURCES_EMPTY_USERNAME,CmsConstant.EMPTY_USERNAME),
    /**
     * 密码不能为空
     */
    EMPTY_PASSWORD(10102,CmsConstant.RESOURCES_EMPTY_PASSWORD,CmsConstant.EMPTY_PASSWORD);


    private Integer code;
    private String  resource;
    private String  desc;

    CmsResultCode(Integer code,String  resource,String desc){
        this.code = code;
        this.resource = resource;
        this.desc = desc;
    }

    public static String getDesc(Integer code){
        for(CmsResultCode cmsResultCode:CmsResultCode.values()){
            if(cmsResultCode.getCode() == code){
                return cmsResultCode.getDesc();
            }
        }
        return null;
    }

    public  static String getResources(Integer code){
        for(CmsResultCode cmsResultCode : CmsResultCode.values()){
            if(cmsResultCode.getCode() == code){
                return cmsResultCode.getResource();
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
