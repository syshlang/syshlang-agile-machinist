/*
 * Copyright (c) 2018. syshlang
 * @File: ShiroSessionDao.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-30 下午9:23
 * @since:
 */

package com.syshlang.system.authority.shiro.session;

import com.syshlang.system.authority.shiro.api.ShiroConstant;
import org.apache.commons.lang3.StringUtils;
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

    private static String forceLogout="SHIRO_FORCE_LOGOUT";
    // 默认会话的过期时间
    private static final int SESSION_TIMEOUT = 300000;

    private String theWayCacheSession;


    /**
     * 如DefaultSessionManager在创建完session后会调用该方法；
     * 如保存到关系数据库/文件系统/NoSQL数据库；即可以实现会话的持久化；
     * 返回会话ID；主要此处返回的ID.equals(session.getId())；
     * @param session  //http://sgq0085.iteye.com/blog/2170405
     * @return
     */
    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        if (theWayCacheSession.equalsIgnoreCase(ShiroConstant.WAY_CACHESESSION.EHCACHE.getWay())){
            return sessionId;
        }
        if (theWayCacheSession.equalsIgnoreCase(ShiroConstant.WAY_CACHESESSION.DB.getWay())){

        }
        if (theWayCacheSession.equalsIgnoreCase(ShiroConstant.WAY_CACHESESSION.REDIS.getWay())){

        }
        return sessionId;
    }

    @Override
    protected void doUpdate(Session session) {

    }

    @Override
    protected void doDelete(Session session) {

    }

    /**
     * 重写CachingSessionDAO中readSession方法，
     * 如果Session中没有登陆信息就调用doReadSession方法从存储中重读
     * @param serializable
     * @return
     */
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

    public void setTheWayCacheSession(String theWayCacheSession) {
        if (StringUtils.isBlank(theWayCacheSession)){
            theWayCacheSession = ShiroConstant.WAY_CACHESESSION.DB.getWay();
        }
        this.theWayCacheSession = theWayCacheSession;
    }

    public String getTheWayCacheSession() {
        return theWayCacheSession;
    }
}
