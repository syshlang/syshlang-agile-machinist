/*
 * Copyright (c) 2018. syshlang
 * @File: SystemResultCode.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-27 上午12:31
 * @since:
 */

package com.syshlang.system.api.common;

public enum SystemResultCode {
    /**
     * 用户名不能为空
     */
    EMPTY_USERNAME(10101, SystemConstant.UserConstant.RESOURCES_EMPTY_USERNAME,SystemConstant.UserConstant.EMPTY_USERNAME),
    /**
     * 密码不能为空
     */
    EMPTY_PASSWORD(10102,SystemConstant.UserConstant.RESOURCES_EMPTY_PASSWORD,SystemConstant.UserConstant.EMPTY_PASSWORD),
    /**
     * 帐号不存在
     */
    INVALID_USERNAME(10103,SystemConstant.UserConstant.RESOURCES_INVALID_USERNAME,SystemConstant.UserConstant.INVALID_USERNAME),
    /**
     *密码错误
     */
    INVALID_PASSWORD(10104,SystemConstant.UserConstant.RESOURCES_INVALID_PASSWORD,SystemConstant.UserConstant.INVALID_PASSWORD),
    /**
     * 帐号已锁定
     */
    LOCKED_ACCOUNT(10105,SystemConstant.UserConstant.RESOURCES_LOCKED_ACCOUNT,SystemConstant.UserConstant.LOCKED_ACCOUNT),
    /**
     * 输入密码次数过多
     */
    RETRY_LIMIT(10106,SystemConstant.UserConstant.RESOURCES_RETRY_LIMIT,SystemConstant.UserConstant.RETRY_LIMIT);


    private Integer code;
    private String  resource;
    private String  desc;

    SystemResultCode(Integer code,String  resource,String desc){
        this.code = code;
        this.resource = resource;
        this.desc = desc;
    }

    public static String getDesc(Integer code){
        for(SystemResultCode systemResultCode:SystemResultCode.values()){
            if(systemResultCode.getCode() == code){
                return systemResultCode.getDesc();
            }
        }
        return null;
    }

    public  static String getResources(Integer code){
        for(SystemResultCode systemResultCode : SystemResultCode.values()){
            if(systemResultCode.getCode() == code){
                return systemResultCode.getResource();
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
