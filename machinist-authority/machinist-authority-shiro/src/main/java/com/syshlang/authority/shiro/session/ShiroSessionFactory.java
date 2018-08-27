/*
 * Copyright (c) 2018. syshlang
 * @File: ShiroSessionFactory.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-27 下午10:00
 * @since:
 */

package com.syshlang.authority.shiro.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;

/**
 * @author sunys
 */
public class ShiroSessionFactory implements SessionFactory {

    @Override
    public Session createSession(SessionContext sessionContext) {
        return null;
    }
}
