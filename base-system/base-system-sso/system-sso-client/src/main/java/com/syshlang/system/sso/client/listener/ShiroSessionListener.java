/*
 * Copyright (c) 2018. syshlang
 * @File: ShiroSessionListener.java
 * @Description:
 * @Author: sunys
 * @Date: 18-9-20 下午9:59
 * @since:
 */

package com.syshlang.system.sso.client.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

/**
 * @author sunys
 */
public class ShiroSessionListener implements SessionListener {

    @Override
    public void onStart(Session session) {
    }

    @Override
    public void onStop(Session session) {

    }

    @Override
    public void onExpiration(Session session) {

    }
}
