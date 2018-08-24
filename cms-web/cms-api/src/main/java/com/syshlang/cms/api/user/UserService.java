/*
 * Copyright (c) 2018. syshlang
 * @File: UserService.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-24 上午2:43
 * @since:
 */

package com.syshlang.cms.api.user;

import com.syshlang.common.base.BaseResult;
import com.syshlang.common.base.BaseService;
import com.syshlang.common.model.user.User;

/**
 * @author sunys
 */
public interface UserService extends BaseService<User, Integer> {

    BaseResult userLogin(String username, String password, String rememberMe);
}
