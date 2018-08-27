/*
 * Copyright (c) 2018. syshlang
 * @File: ShiroFilterChainDefinitionMapBuilder.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-27 下午10:19
 * @since:
 */

package com.syshlang.authority.shiro.factory;

import java.util.LinkedHashMap;

/**
 * 实例工厂方法的方式配置权限过滤抽象类,由需要调用的系统实现方法
 * @author sunys
 */
public abstract  class ShiroFilterChainDefinitionMapBuilder{

    public abstract LinkedHashMap<String, String> buildFilterChainDefinitionMap();
}
