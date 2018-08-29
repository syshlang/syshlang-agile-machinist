/*
 * Copyright (c) 2018. syshlang
 * @File: UserServiceImpl.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-27 上午1:14
 * @since:
 */

package com.syshlang.system.service.user;




import com.syshlang.common.base.BaseResult;
import com.syshlang.common.base.BaseResultCode;
import com.syshlang.common.base.BaseServiceImpl;
import com.syshlang.system.api.common.SystemResult;
import com.syshlang.system.api.common.SystemResultCode;
import com.syshlang.system.api.user.UserService;
import com.syshlang.system.dao.user.UserDao;
import com.syshlang.system.model.user.entity.User;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author sunys
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserDao, User, Integer> implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public BaseResult userLogin(String username, String password, String rememberMe) {
        BaseResult result = null;
        if (StringUtils.isBlank(username)){
            return new SystemResult(SystemResultCode.EMPTY_USERNAME);
        }
        if (StringUtils.isBlank(password)){
            return  new SystemResult(SystemResultCode.EMPTY_PASSWORD);
        }
        Subject subject = SecurityUtils.getSubject();
        if(username.equals("admin") && password.equals("123456")){
            log.info("【"+username+"】登录成功！");
            // 使用shiro认证
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
            subject.login(usernamePasswordToken);
            Session session = subject.getSession();
            String sessionId = session.getId().toString();
            User user = new User();
            user.setUserId(10000L);
            user.setUsername(username);
            session.setAttribute("user", user);
            result =new BaseResult(BaseResultCode.SUCCESS);
        }else{
            result =new BaseResult(BaseResultCode.LOGINFAILURE);
        }
        return result;
    }
}
