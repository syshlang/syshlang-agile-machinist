/*
 * Copyright (c) 2018. syshlang
 * @File: MybatisDaoImpl.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-24 上午12:53
 * @since:
 */

package com.syshlang.mybatis.dao.impl;

import com.syshlang.common.base.BaseDaoImpl;
import com.syshlang.common.base.BaseModel;
import com.syshlang.mybatis.dao.MybatisDao;
import com.syshlang.mybatis.mapper.MybatisMapper;

import java.io.Serializable;

public abstract class MybatisDaoImpl<M extends MybatisMapper, U extends BaseModel, I extends Serializable> extends BaseDaoImpl<M,U,I> implements MybatisDao<U,I> {

    @Override
    public void testMybatisDao() {

    }

    @Override
    public int insert(U baseModel) {
        return super.insert(baseModel);
    }
}
