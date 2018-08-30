/*
 * Copyright (c) 2018. syshlang
 * @File: UserController.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-27 上午1:27
 * @since:
 */

package com.syshlang.system.consumer.user;


import com.syshlang.common.base.BaseController;
import com.syshlang.common.base.BaseResult;
import com.syshlang.common.base.BaseResultCode;
import com.syshlang.system.api.common.SystemResult;
import com.syshlang.system.api.common.SystemResultCode;
import com.syshlang.system.api.online.UserOnlineService;
import com.syshlang.system.api.user.UserService;
import com.syshlang.system.authority.shiro.api.ShiroConstant;
import com.syshlang.system.model.online.entity.UserOnline;
import com.syshlang.system.model.user.entity.User;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author sunys
 */
@Controller
@RequestMapping("system/user")
public class UserController extends BaseController {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private UserOnlineService userOnlineService;

    @RequestMapping("index.html")
    public String index(HttpServletRequest request){
        return "login/index";
    }

	
	@RequestMapping(value="login.json",method = RequestMethod.POST)
	@ResponseBody
	public BaseResult login(HttpServletRequest request,
							@RequestParam(value="username",defaultValue="",required=true) String username,
							@RequestParam(value="password",defaultValue="",required=true) String password,
                            @RequestParam(value ="rememberMe",defaultValue="",required=false) String rememberMe){

		BaseResult result = new BaseResult(BaseResultCode.SUCCESS);
        if (StringUtils.isBlank(username)){
            return new SystemResult(SystemResultCode.EMPTY_USERNAME);
        }
        if (StringUtils.isBlank(password)){
            return  new SystemResult(SystemResultCode.EMPTY_PASSWORD);
        }
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession(false);
        if (session != null){
        	String sessionId = session.getId().toString();
			UserOnline userOnline = userOnlineService.selectUserOnlineBySessionId(ShiroConstant.SYSHLANG_SYSTEM_USER_SERVER_SESSION_ID+sessionId);
			if (userOnline != null){
				if (StringUtils.isNotBlank(userOnline.getCode())) {
					return result;
				}
			}
		}
		try {
			// 使用shiro认证
			UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
			if (BooleanUtils.toBoolean(rememberMe)) {
				usernamePasswordToken.setRememberMe(true);
			} else {
				usernamePasswordToken.setRememberMe(false);
			}
			subject.login(usernamePasswordToken);
		} catch (UnknownAccountException e) {
			return new SystemResult(SystemResultCode.INVALID_USERNAME);
		} catch (IncorrectCredentialsException e) {
			return new SystemResult(SystemResultCode.INVALID_PASSWORD);
		} catch (LockedAccountException e) {
			return new SystemResult(SystemResultCode.LOCKED_ACCOUNT);
		}
		return result;
	}
	
	@RequestMapping(value="exit.json",method = RequestMethod.POST)
	@ResponseBody
	public BaseResult exit(HttpServletRequest request){
		BaseResult result = null;
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(null!=user){
			LOGGER.info("退出成功");
			session.removeAttribute("user");;
			result =new BaseResult(BaseResultCode.SUCCESS);
		}else{
			result =new BaseResult(BaseResultCode.ERROR);
		}
		return result;
	}

}
