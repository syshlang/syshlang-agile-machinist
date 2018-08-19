/*
 * Copyright (c) 2018. syshlang
 * @File: UserServiceImpl.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-18 下午10:25
 * @since:
 */

package com.syshlang.service.user;


import com.syshlang.api.service.user.UserService;
import com.syshlang.common.base.BaseServiceImpl;
import com.syshlang.common.model.user.User;
import com.syshlang.dao.user.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author sunys
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserDao,User, Integer>  implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;
}
