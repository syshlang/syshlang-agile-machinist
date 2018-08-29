/*
 * Copyright (c) 2018. syshlang
 * @File: SystemConstant.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-27 上午12:22
 * @since:
 */

package com.syshlang.system.api.common;

import com.syshlang.api.common.ApiConstant;

/**
 * @author sunys
 */
public class SystemConstant extends ApiConstant {
    public static final  Class CLASS = SystemConstant.class;

    public static final String RESOURCES_EMPTY_USERNAME = "system.user.login.emptyUsername";
    public static final String EMPTY_USERNAME = "用户名不能为空!";

    public static final String RESOURCES_EMPTY_PASSWORD = "system.user.login.emptyPassword";
    public static final String EMPTY_PASSWORD = "密码不能为空!";

    public static final String RESOURCES_INVALID_USERNAME = "system.user.login.invalidUsername";
    public static final String INVALID_USERNAME = "帐号不存在!";

    public static final String RESOURCES_INVALID_PASSWORD = "system.user.login.invalidPassword";
    public static final String INVALID_PASSWORD = "密码错误！" ;

    public static final String RESOURCES_LOCKED_ACCOUNT = "system.user.login.lockedAccount";
    public static final String LOCKED_ACCOUNT = "帐号已锁定!";
}
