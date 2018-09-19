/*
 * Copyright (c) 2018. syshlang
 * @File: UserServiceImpl.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-27 上午1:14
 * @since:
 */

package com.syshlang.system.service.user;


import com.syshlang.common.base.BaseResult;
import com.syshlang.common.base.BaseServiceImpl;
import com.syshlang.system.api.user.UserService;
import com.syshlang.system.dao.user.UserDao;
import com.syshlang.system.model.user.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author sunys
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserDao, User, Long> implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public BaseResult userLogin(String username, String password, String rememberMe) {
        BaseResult result = null;

        return result;
    }

    @Override
    public User selectUserByUserName(String username) {
        if (StringUtils.isBlank(username)){
            return null;
        }
        return userDao.selectUserByUserName(username);
    }
}
