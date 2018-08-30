/*
 * Copyright (c) 2018. syshlang
 * @File: UserDao.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-27 上午12:59
 * @since:
 */

package com.syshlang.system.dao.user;


import com.syshlang.mybatis.dao.MybatisDao;
import com.syshlang.system.model.user.entity.User;

/**
 * The interface User dao.
 */
public interface UserDao extends MybatisDao<User,Long> {


    /**
     * Test.
     *
     * @param user the user
     */
    void  test(User user);

    /**
     * Select user by user name user.
     *
     * @param username the username
     * @return the user
     */
    User selectUserByUserName(String username);
}
