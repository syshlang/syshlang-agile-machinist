/*
 * Copyright (c) 2018. syshlang
 * @File: UserOnlineDaoImpl.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-29 下午10:58
 * @since:
 */

package com.syshlang.system.dao.online;

import com.syshlang.mybatis.dao.impl.MybatisDaoImpl;
import com.syshlang.system.mapper.online.UserOnlineMapper;
import com.syshlang.system.model.online.entity.UserOnline;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sunys
 */
@Repository
public class UserOnlineDaoImpl extends MybatisDaoImpl<UserOnlineMapper,UserOnline,Long> implements UserOnlineDao {
    private final static Logger LOGGER = LoggerFactory.getLogger(UserOnlineDaoImpl.class);

    @Autowired
    private UserOnlineMapper userOnlineMapper;

    @Override
    public UserOnline selectUserOnlineBySessionId(String sessionId) {
        LOGGER.info("UserOnlineDaoImpl#selectUserOnlineBySessionId");
        try {
            if (StringUtils.isBlank(sessionId)){
                return null;
            }
            UserOnline userOnline = new UserOnline();
            userOnline.setSessionId(sessionId);
            List<UserOnline> userOnlineList = userOnlineMapper.select(userOnline);
            if (userOnlineList != null && userOnlineList.size()>0){
                return userOnlineList.get(0);
            }
        }catch (Exception e){
            LOGGER.error("UserOnlineDaoImpl#selectUserOnlineBySessionId:{}",e.getMessage());
        }
        return null;
    }
}
