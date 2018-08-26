/*
 * Copyright (c) 2018. syshlang
 * @File: UserServiceImplTest.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-27 上午1:19
 * @since:
 */

package com.syshlang.system.service.user;


import com.syshlang.common.base.BaseResult;
import com.syshlang.system.api.user.UserService;
import com.syshlang.system.model.user.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath*:META-INF/spring/*.xml"
})
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void userLogin() {
        BaseResult baseResult = userService.userLogin("", "", "");
        System.out.println(baseResult.getCode()+":"+baseResult.getDesc()+":"+baseResult.getData());
    }

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("sunys");
        user.setPassword("123456");
        user.setEmail("sunys@163.com");
        user.setSex((byte) 1);
        user.setPhone("13335894564");
        user.setCtime(System.currentTimeMillis());
        userService.insert(user);
    }

    @Test
    public void selectCount() {
        User user = new User();
        user.setUsername("sunys");
        int count = userService.selectCount(user);
        System.out.println(count);
    }
}