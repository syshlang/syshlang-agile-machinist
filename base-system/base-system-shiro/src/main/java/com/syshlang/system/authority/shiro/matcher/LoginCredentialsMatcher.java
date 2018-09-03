/*
 * Copyright (c) 2018. syshlang
 * @File: LoginCredentialsMatcher.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-31 上午12:42
 * @since:
 */

package com.syshlang.system.authority.shiro.matcher;

import com.syshlang.system.authority.shiro.realm.ShiroAuthorityRealm;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sunys
 */
public class LoginCredentialsMatcher extends HashedCredentialsMatcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginCredentialsMatcher.class);
    private static final int  MAXRETRYLIMIT_DEFAULT = 5;
    private Cache<String, AtomicInteger> passwordRetryCache;
    private String maxRetryLimit;

    public LoginCredentialsMatcher(CacheManager cacheManager) {
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }


    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String username = (String)token.getPrincipal();
        AtomicInteger retryCount = passwordRetryCache.get(username);
        if(null == retryCount) {
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(username, retryCount);
        }
        if(retryCount.incrementAndGet() > Integer.parseInt(maxRetryLimit)) {
            LOGGER.warn("用户:{}密码输入错误超过{}次",username,Integer.parseInt(maxRetryLimit));
            throw new ExcessiveAttemptsException();
        }
        boolean matches = super.doCredentialsMatch(token, info);
        if(matches) {
            passwordRetryCache.remove(username);
        }
        return matches;
    }

    public void setMaxRetryLimit(String maxRetryLimit) {
        if (StringUtils.isBlank(maxRetryLimit)){
            maxRetryLimit = String.valueOf(MAXRETRYLIMIT_DEFAULT);
        }
        this.maxRetryLimit = maxRetryLimit;
    }

    public String getMaxRetryLimit() {
        return maxRetryLimit;
    }
}
