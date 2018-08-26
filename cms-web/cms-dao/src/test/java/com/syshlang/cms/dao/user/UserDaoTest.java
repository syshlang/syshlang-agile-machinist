/*
 * Copyright (c) 2018. syshlang
 * @File: UserDaoTest.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-26 下午4:34
 * @since:
 */

package com.syshlang.cms.dao.user;

import com.syshlang.common.model.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:META-INF/spring/applicationContext*.xml"
})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class UserDaoTest {

    @Autowired
    private  UserDao userDao;

    @Test
    public void testDelete() {
        User user = new User();
        userDao.test(user);
    }

    @Test
    public void testMybatisDao() {
        User user = new User();
        userDao.testMybatisDao();
    }
}