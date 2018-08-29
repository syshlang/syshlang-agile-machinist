/*
 * Copyright (c) 2018. syshlang
 * @File: UserOnlineServiceImpl.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-29 下午11:30
 * @since:
 */

package com.syshlang.system.service.online;

import com.syshlang.common.base.BaseServiceImpl;
import com.syshlang.system.api.online.UserOnlineService;
import com.syshlang.system.dao.online.UserOnlineDao;
import com.syshlang.system.model.online.entity.UserOnline;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sunys
 */
public class UserOnlineServiceImpl extends BaseServiceImpl<UserOnlineDao, UserOnline,Long> implements UserOnlineService {
    private static final Logger log = LoggerFactory.getLogger(UserOnlineServiceImpl.class);
}
