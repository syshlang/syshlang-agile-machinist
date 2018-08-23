/*
 * Copyright (c) 2018. syshlang
 * @File: UserDao.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-24 上午1:24
 * @since:
 */

package com.syshlang.cms.dao.user;

import com.syshlang.common.model.user.User;
import com.syshlang.mybatis.dao.MybatisDao;

public interface UserDao extends MybatisDao<User,Integer>{


    void  test(User user);

}
