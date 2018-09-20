/*
 * Copyright (c) 2018. syshlang
 * @File: ShiroConstant.java
 * @Description:
 * @Author: sunys
 * @Date: 18-9-20 下午9:59
 * @since:
 */

package com.syshlang.system.sso.client.api;

import com.syshlang.system.api.common.SystemConstant;

/**
 * @author sunys
 */
public class ShiroConstant extends SystemConstant {
    public static final  Class CLASS = ShiroConstant.class;

    // 全局会话key
    public static final String SYSHLANG_SYSTEM_USER_SERVER_SESSION_ID = "syshlang_system_user_server_session_id";
    // 会话key
    public final static String SYSHLANG_SYSTEM_SHIRO_SESSION_ID = "syshlang_system_shiro_session_id";

    public enum WAY_CACHESESSION{
        DB("DB"),EHCACHE("EHCACHE"),REDIS("REDIS");
        private final String way;
        public String getWay() {
            return way;
        }
        WAY_CACHESESSION(String way) {
            this.way = way;
        }
    }
}
