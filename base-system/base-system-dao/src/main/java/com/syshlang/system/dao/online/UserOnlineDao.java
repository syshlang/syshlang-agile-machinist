/*
 * Copyright (c) 2018. syshlang
 * @File: UserOnlineDao.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-29 下午10:55
 * @since:
 */

package com.syshlang.system.dao.online;

import com.syshlang.mybatis.dao.MybatisDao;
import com.syshlang.system.model.online.entity.UserOnline;

/**
 * The interface User online dao.
 *
 * @author sunys
 */
public interface UserOnlineDao extends MybatisDao<UserOnline,Long> {
    /**
     * Select user online by session id user online.
     *
     * @param sessionId the session id
     * @return the user online
     */
    UserOnline selectUserOnlineBySessionId(String sessionId);
}
