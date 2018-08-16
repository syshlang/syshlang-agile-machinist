/*
 * Copyright (c) 2018. syshlang
 * @File: ApiResultBean.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-17 上午3:53
 * @since:
 */

package com.syshlang.api.common;

import com.syshlang.common.base.BaseModel;
import com.syshlang.common.base.BaseResultCode;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name="data")
public class ApiResultBean<T extends BaseModel> extends ApiResult {
    private static final long serialVersionUID = 6820590149791068737L;

    private T row;

    public ApiResultBean() {
    }

    public ApiResultBean(BaseResultCode baseResultCode) {
        super(baseResultCode);
    }

    @XmlElement(name = "row")
    public T getRow() {
        return row;
    }

    public void setRow(T row) {
        this.row = row;
    }

}
