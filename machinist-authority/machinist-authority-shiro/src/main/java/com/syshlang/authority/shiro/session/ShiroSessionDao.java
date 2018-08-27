/*
 * Copyright (c) 2018. syshlang
 * @File: ShiroSessionDao.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-27 下午9:55
 * @since:
 */

package com.syshlang.authority.shiro.session;

import com.syshlang.authority.shiro.filter.ShiroSessionForceLogoutFilter;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * @author sunys
 */
public class ShiroSessionDao extends CachingSessionDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroSessionDao.class);

    private String forceLogout="SHIRO_FORCE_LOGOUT";

    @Override
    protected void doUpdate(Session session) {

    }

    @Override
    protected void doDelete(Session session) {

    }

    @Override
    protected Serializable doCreate(Session session) {
        return null;
    }

    @Override
    protected Session doReadSession(Serializable serializable) {
        return null;
    }


    /**
     *
     * @param ids
     * @return
     */
    public int forceout(String ids) {

        return 0;
    }

    public void setForceLogout(String forceLogout) {
        this.forceLogout = forceLogout;
    }

    public String getForceLogout() {
        return forceLogout;
    }
}
