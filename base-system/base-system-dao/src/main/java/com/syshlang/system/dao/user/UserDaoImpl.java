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
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sunys
 */
@Repository
public class UserDaoImpl extends MybatisDaoImpl<UserMapper,User,Long> implements UserDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public void test(User user) {
        System.out.println("Test:userMapper");
    }

    @Override
    public User selectUserByUserName(String username) {
        LOGGER.info("UserDaoImpl#selectUserByUserName:{}"+username);
        try {
            if (StringUtils.isBlank(username)){
                return null;
            }
            User user = new User();
            user.setUsername(username);
            List<User> userList = userMapper.select(user);
            if (userList != null && userList.size()>0){
                return  userList.get(0);
            }
        }catch (Exception e){
            LOGGER.error("UserDaoImpl#selectUserByUserName:{}",e.getMessage());
        }
        return null;
    }
}
