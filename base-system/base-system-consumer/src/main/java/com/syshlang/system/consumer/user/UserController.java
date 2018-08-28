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
import com.syshlang.system.api.user.UserService;
import com.syshlang.system.model.user.entity.User;
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

		BaseResult result = userService.userLogin(username,password,rememberMe);
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
