/*
 * Copyright (c) 2018. syshlang
 * @File: UserService.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-27 上午12:43
 * @since:
 */

package com.syshlang.system.api.user;

import com.syshlang.common.base.BaseResult;
import com.syshlang.common.base.BaseService;
import com.syshlang.system.model.user.entity.User;


/**
 * The interface User service.
 *
 * @author sunys
 */
public interface UserService extends BaseService<User, Long> {

    /**
     * User login base result.
     *
     * @param username   the username
     * @param password   the password
     * @param rememberMe the remember me
     * @return the base result
     */
    BaseResult userLogin(String username, String password, String rememberMe);

    /**
     * Select user by user name user.
     *
     * @param username the username
     * @return the user
     */
    User selectUserByUserName(String username);
}
