/*
 * Copyright (c) 2018. syshlang
 * @File: UserDaoImpl.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-19 上午2:39
 * @since:
 */

package com.syshlang.dao.user;


import com.syshlang.common.base.BaseDaoImpl;
import com.syshlang.common.model.user.User;
import com.syshlang.mapper.user.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author sunys
 */
@Repository
public class UserDaoImpl  extends BaseDaoImpl<UserMapper,User, Integer>  implements UserDao{

    private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

    @Autowired
    private UserMapper userMapper;

}
