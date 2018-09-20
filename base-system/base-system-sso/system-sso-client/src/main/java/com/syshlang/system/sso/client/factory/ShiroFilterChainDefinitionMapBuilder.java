/*
 * Copyright (c) 2018. syshlang
 * @File: ShiroFilterChainDefinitionMapBuilder.java
 * @Description:
 * @Author: sunys
 * @Date: 18-9-20 下午9:59
 * @since:
 */

package com.syshlang.system.sso.client.factory;

import java.util.LinkedHashMap;

/**
 * 实例工厂方法的方式配置权限过滤
 * @author sunys
 */
public class ShiroFilterChainDefinitionMapBuilder{

    public LinkedHashMap<String, String> buildFilterChainDefinitionMap(){
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        map.put("/system/user/index.html", "anon");
        map.put("/system/home/**","user");
        map.put("*/login.json", "anon");
        map.put("/logout", "logout");
        map.put("/app/**","anon");
        map.put("/static/**","anon");
        map.put("/**", "forceLogout,authc");
        return map;
    }
}
