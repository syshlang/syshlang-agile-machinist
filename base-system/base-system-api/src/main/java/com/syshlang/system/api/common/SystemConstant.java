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


    public enum SYSTEM_ENV{
        SYSTEM_ENV_DEV("dev","开发环境"),
        SYSTEM_ENV_TEST("test","演示环境"),
        SYSTEM_ENV_PRO("pro","生产环境");

        private final String env;
        private final String desc;

        public String getEnv() {
            return env;
        }

        public String getDesc() {
            return desc;
        }

        SYSTEM_ENV(String env, String desc) {
            this.env = env;
            this.desc = desc;
        }
    }

    /**
     * 系统所属模块枚举类
     */
    public enum SYSTEM_MODULE{
        SYSTEM_MODULE_USER(1010,"user.Login","用户登录");

        private final Integer code; //模块代号
        private final String codeStr; //模块代码
        private final String desc; //描述

        public Integer getCode() {
            return code;
        }

        public String getCodeStr() {
            return codeStr;
        }

        public String getDesc() {
            return desc;
        }

        SYSTEM_MODULE(Integer code, String codeStr, String desc) {
            this.code = code;
            this.codeStr = codeStr;
            this.desc = desc;
        }
    }

    /**
     * 系统异常类型枚举
     */
    public enum SYSTEM_EXCEPTION{
        EXCEPTION_USER(1010,"user.Login","用户相关异常"),
        EXCEPTION_PARAM(1020,"exception.param","参数相关异常");
        private final Integer code; //异常代号前缀
        private final String codeStr; //异常编码
        private final String desc; //描述

        public Integer getCode() {
            return code;
        }

        public String getCodeStr() {
            return codeStr;
        }

        public String getDesc() {
            return desc;
        }

        SYSTEM_EXCEPTION(Integer code, String codeStr, String desc) {
            this.code = code;
            this.codeStr = codeStr;
            this.desc = desc;
        }
    }

    /**
     * 用户相关
     */
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
            private final String code;
            private final String desc;
            public String getCode() {
                return code;
            }
            public String getDesc() {
                return desc;
            }
            USER_ENUM(String code, String desc) {
                this.code = code;
                this.desc = desc;
            }
        }
    }
}
