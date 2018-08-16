/*
 * Copyright (c) 2018. syshlang
 * @File: User.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-17 上午1:19
 * @since:
 */

package com.syshlang.common.model.user;

import com.syshlang.common.base.BaseModel;

public class User extends BaseModel {
    private static final long serialVersionUID = 6354251930566738268L;

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(){}

    public User(Integer id,String username){
        this.id = id;
        this.name = username;
    }
}
