/*
 * Copyright (c) 2018. syshlang
 * @File: HomeController.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-28 上午1:04
 * @since:
 */

package com.syshlang.system.consumer.home;

import com.syshlang.system.sso.client.api.ShiroController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("system/home")
public class HomeController extends ShiroController {
    private final static Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("index.html")
    public String index(HttpServletRequest request){
        return "home/index";
    }
}
