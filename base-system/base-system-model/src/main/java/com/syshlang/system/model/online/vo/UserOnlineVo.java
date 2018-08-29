/*
 * Copyright (c) 2018. syshlang
 * @File: UserOnlineVo.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-29 下午10:45
 * @since:
 */

package com.syshlang.system.model.online.vo;

import java.util.Date;

/**
 * @author sunys
 */
public class UserOnlineVo {
    /**
     * 用户会话id
     */
    private String sessionId;
    /**
     *用户编号
     */
    private Long userId;
    /**
     * 加密
     */
    private String code;
    /**
     * 登录IP地址
     */
    private String ipaddr;
    /**
     * 登录地点
     */
    private String loginLocation;
    /**
     * 浏览器类型
     */
    private String browser;
    /**
     * 操作系统
     */
    private String os;
    /**
     * 状态(0:离线,1:在线)
     */
    private String status;
    /**
     * 创建时间
     */
    private Date startTime;
    /**
     * 最后访问时间
     */
    private Date lastTime;
    /**
     * 超时时间，单位为分钟
     */
    private Long expireTime;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }

    public String getLoginLocation() {
        return loginLocation;
    }

    public void setLoginLocation(String loginLocation) {
        this.loginLocation = loginLocation;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }
}

