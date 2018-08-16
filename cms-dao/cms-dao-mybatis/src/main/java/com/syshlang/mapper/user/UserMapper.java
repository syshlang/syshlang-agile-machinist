/*
 * Copyright (c) 2018. syshlang
 * @File: UserMapper.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-17 上午1:22
 * @since:
 */

package com.syshlang.mapper.user;

import com.syshlang.common.model.user.User;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;
import java.util.Map;

/**
 * @author sunys
 */
public interface UserMapper extends Mapper<User> {

    public List<User> select_test(Map map);

    public int insert_test(User t);
}
