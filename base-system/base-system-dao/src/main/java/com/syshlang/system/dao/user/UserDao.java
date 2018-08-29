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

public interface UserDao extends MybatisDao<User,Long> {


    void  test(User user);

}
