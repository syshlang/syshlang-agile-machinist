/*
 * Copyright (c) 2018. syshlang
 * @File: UserDaoImpl.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-27 上午12:59
 * @since:
 */

package com.syshlang.system.dao.user;


import com.syshlang.mybatis.dao.impl.MybatisDaoImpl;
import com.syshlang.system.mapper.user.UserMapper;
import com.syshlang.system.model.user.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author sunys
 */
@Repository
public class UserDaoImpl extends MybatisDaoImpl<UserMapper,User,Integer> implements UserDao {

    private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public void test(User user) {
        System.out.println("Test:userMapper");
    }
}
