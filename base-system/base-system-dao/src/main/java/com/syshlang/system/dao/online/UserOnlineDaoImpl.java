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

public class UserOnlineDaoImpl extends MybatisDaoImpl<UserOnlineMapper,UserOnline,Long> implements UserOnlineDao {
}
