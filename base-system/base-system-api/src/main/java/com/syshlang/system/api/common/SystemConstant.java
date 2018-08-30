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

    public static class UserConstant{
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

        public static final String RESOURCES_RETRY_LIMIT = "system.user.login.retryLimit";
        public static final String RETRY_LIMIT = "输入密码错误次数超过限制，请稍后重试！";

        public enum USER_ENUM{

            SEX_UNKNOW("0","未知"),
            SEX_MAN("1","男"),
            SEX_WOMAN("2","女"),

            STATUS_NORMAL("0","正常"),
            STATUS_LOCKED("1","锁定");
            private String code;
            private String desc;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }
            USER_ENUM(String code, String desc) {
                this.code = code;
                this.desc = desc;
            }
        }
    }
}
