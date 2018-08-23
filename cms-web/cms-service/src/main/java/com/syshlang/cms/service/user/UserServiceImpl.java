/*
 * Copyright (c) 2018. syshlang
 * @File: UserServiceImpl.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-24 上午2:45
 * @since:
 */

package com.syshlang.cms.service.user;


import com.syshlang.cms.api.user.UserService;
import com.syshlang.cms.dao.user.UserDao;
import com.syshlang.common.base.BaseServiceImpl;
import com.syshlang.common.model.user.User;
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
