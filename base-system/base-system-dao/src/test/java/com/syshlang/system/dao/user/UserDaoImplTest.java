/*
 * Copyright (c) 2018. syshlang
 * @File: UserDaoImplTest.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-27 上午1:07
 * @since:
 */

package com.syshlang.system.dao.user;

import com.syshlang.system.model.user.entity.User;
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
public class UserDaoImplTest {

    @Autowired
    private  UserDao userDao;


    @Test
    public void test() {
        User user = new User();
        userDao.test(user);
    }

    @Test
    public void testMybatisDao() {
        User user = new User();
        userDao.testMybatisDao(user);
    }

    @Test
    public void deleteByPrimaryKey() {
        User user = new User();
        user.setUserId(15);
        int i = userDao.deleteByPrimaryKey(user);
        System.out.println(i);
    }

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("sunys");
        user.setPassword("123456");
        user.setEmail("sunys@163.com");
        user.setSex("1");
        user.setPhone("13335894564");
        user.setCreateTime(System.currentTimeMillis());
        userDao.insert(user);
    }

    @Test
    public void selectCount() {
        User user = new User();
        user.setUsername("sunys");
        user.setSex("1");
        int count = userDao.selectCount(user);
        System.out.println(count);
    }

}