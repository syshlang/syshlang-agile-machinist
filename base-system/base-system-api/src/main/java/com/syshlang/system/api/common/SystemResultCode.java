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
    EMPTY_USERNAME(10101, SystemConstant.RESOURCES_EMPTY_USERNAME,SystemConstant.EMPTY_USERNAME),
    /**
     * 密码不能为空
     */
    EMPTY_PASSWORD(10102,SystemConstant.RESOURCES_EMPTY_PASSWORD,SystemConstant.EMPTY_PASSWORD);


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
