/*
 * Copyright (c) 2018. syshlang
 * @File: UserOnlineService.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-29 下午11:25
 * @since:
 */

package com.syshlang.system.api.online;

import com.syshlang.common.base.BaseService;
import com.syshlang.system.model.online.entity.UserOnline;

/**
 * The interface User online service.
 *
 * @author sunys
 */
public interface UserOnlineService extends BaseService<UserOnline,Long> {
    /**
     * Select user online by session id user online.
     *
     * @param sessionId the session id
     * @return the user online
     */
    UserOnline selectUserOnlineBySessionId(String sessionId);
}
