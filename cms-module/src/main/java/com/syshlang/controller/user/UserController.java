/*
 * Copyright (c) 2018. syshlang
 * @File: UserController.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-21 上午12:24
 * @since:
 */

package com.syshlang.controller.user;

import com.syshlang.common.base.BaseController;
import com.syshlang.common.base.BaseResult;
import com.syshlang.common.base.BaseResultCode;
import com.syshlang.common.model.user.User;
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
@RequestMapping("user/login")
public class UserController extends BaseController {
	
	@RequestMapping("index.html")
	public String index(HttpServletRequest request){
		return "login/index";
	}
	
	@RequestMapping(value="login.json",method = RequestMethod.POST)
	@ResponseBody
	public BaseResult login(HttpServletRequest request,
							@RequestParam(value="username",defaultValue="",required=true) String username,
							@RequestParam(value="password",defaultValue="",required=true) String password){
		BaseResult result = null;
		
		HttpSession session = request.getSession();
		
		if(username.length() == 0 || password.length()==0){
			return new BaseResult(BaseResultCode.NONEAUTH.getCode(),"请输入用户名和验证码");
		}
		
		if(username.equals("admin") && password.equals("123456")){
			LOGGER.info("登录成功");
			User user = new User();
			user.setUserId(10000);
			user.setUsername(username);
			session.setAttribute("user", user);
			result =new BaseResult(BaseResultCode.SUCCESS);
		}else{
			result =new BaseResult(BaseResultCode.LOGINFAILURE);
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
