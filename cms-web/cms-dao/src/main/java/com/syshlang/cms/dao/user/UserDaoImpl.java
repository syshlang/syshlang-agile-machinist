/*
 * Copyright (c) 2018. syshlang
 * @File: UserDaoImpl.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-24 上午12:02
 * @since:
 */

package com.syshlang.cms.dao.user;


import com.syshlang.cms.mapper.user.UserMapper;
import com.syshlang.common.model.user.User;
import com.syshlang.mybatis.dao.impl.MybatisDaoImpl;
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
        userMapper.delete(user);
    }

    @Override
    public void testMybatisDao() {

    }

    @Override
    public void testMybatisDao2() {
    }


    @Override
    public int insert(User baseModel) {
        return super.insert(baseModel);
    }
}
