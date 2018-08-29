/*
 * Copyright (c) 2018. syshlang
 * @File: UserMapper.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-27 上午12:59
 * @since:
 */

package com.syshlang.system.mapper.user;


import com.syshlang.mybatis.mapper.MybatisMapper;
import com.syshlang.system.model.user.entity.User;

/**
 * @author sunys
 */

public interface UserMapper extends MybatisMapper<User,Long> {
}
