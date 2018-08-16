/*
 * Copyright (c) 2018. syshlang
 * @File: UserService.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-17 上午3:53
 * @since:
 */

package com.syshlang.api.common.service;

import com.syshlang.api.common.ApiResultBean;
import com.syshlang.api.common.ApiResultListData;
import com.syshlang.common.base.BaseException;
import com.syshlang.common.base.BaseResult;
import com.syshlang.common.model.user.User;

import java.util.Map;

public interface UserService {

    BaseResult add(User user, Integer h)throws BaseException;

    ApiResultListData<?> selectAll(Map map, String db) throws BaseException;

    ApiResultBean<User> selectByPrimaryKey(User t) throws BaseException;

    ApiResultBean<User> selectByName(String name) throws BaseException;
}
