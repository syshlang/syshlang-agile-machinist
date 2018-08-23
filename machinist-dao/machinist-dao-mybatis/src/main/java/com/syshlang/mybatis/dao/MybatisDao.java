/*
 * Copyright (c) 2018. syshlang
 * @File: MybatisDao.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-24 上午1:27
 * @since:
 */

package com.syshlang.mybatis.dao;

import com.syshlang.common.base.BaseDao;
import com.syshlang.common.base.BaseModel;

import java.io.Serializable;

public interface MybatisDao<U extends BaseModel, I extends Serializable> extends BaseDao<U,I> {

    void testMybatisDao();

    void testMybatisDao2();
}
