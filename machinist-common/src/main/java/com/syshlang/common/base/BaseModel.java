/*
 * Copyright (c) 2018. syshlang
 * @File: BaseModel.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-17 上午1:08
 * @since:
 */

package com.syshlang.common.base;

import com.syshlang.common.model.user.User;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.io.Serializable;

@MappedSuperclass
@XmlSeeAlso({
        User.class
})
public abstract class BaseModel implements Serializable {
    private static final long serialVersionUID = 1051067260221482411L;

    public BaseModel(){}

    @Transient
    @JsonIgnore
    private String db;

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }
}
