/*
 * Copyright (c) 2018. syshlang
 * @File: MybatisMapper.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-24 上午12:13
 * @since:
 */

package com.syshlang.mybatis.mapper;

import com.syshlang.common.base.BaseMapper;
import com.syshlang.common.base.BaseModel;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

import java.io.Serializable;

public interface MybatisMapper<T extends BaseModel,PK extends Serializable> extends BaseMapper<T,PK>, Mapper<T>, InsertListMapper<T> {
}
