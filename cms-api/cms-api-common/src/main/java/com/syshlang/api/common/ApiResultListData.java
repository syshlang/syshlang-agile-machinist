/*
 * Copyright (c) 2018. syshlang
 * @File: ApiResultListData.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-17 上午3:53
 * @since:
 */

package com.syshlang.api.common;

import com.syshlang.common.base.BaseModel;
import com.syshlang.common.base.BaseResultCode;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sunys
 */
@XmlRootElement
@XmlType(name="data")
public class ApiResultListData<T extends BaseModel> extends ApiResult{

    private static final long serialVersionUID = -8230902024575288892L;

    public ApiResultListData() {
    }

    private List<T> rows = new ArrayList<T>();

    public ApiResultListData(BaseResultCode baseResultCode) {
        super(baseResultCode);
    }

    @XmlElementWrapper(name = "rows")
    @XmlElement(name="row")
    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
