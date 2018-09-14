/*
 * Copyright (c) 2018. syshlang
 * @File: ShiroAuthorityRealm.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-30 下午9:23
 * @since:
 */

package com.syshlang.system.authority.shiro.realm;

import com.syshlang.system.api.common.SystemConstant;
import com.syshlang.system.api.user.UserService;
import com.syshlang.system.authority.shiro.matcher.LoginCredentialsMatcher;
import com.syshlang.system.authority.shiro.util.ShiroMd5Util;
import com.syshlang.system.model.user.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;


/**
 * @author sunys
 */
public class ShiroAuthorityRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroAuthorityRealm.class);
    private static final String HASHALGORITHMNAME_MD5 = "MD5";
    private static final String HASHALGORITHMNAME_SHA1 = "SHA1";

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        Set<String> roles = new HashSet<>();
        roles.add("user");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }

    /**
     * 登录时认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (authenticationToken != null){
            UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
            String username = usernamePasswordToken.getUsername();
            LOGGER.info("ShiroAuthorityRealm#AuthenticationInfo:{}",username);
            Object principal = username;
            Object credentials = null;
            String salt="";
            if (username.equalsIgnoreCase("admin")){
                credentials ="038bdaf98f2037b31f1e75b5b4c9b26e";
                salt = username;
            }else{
                User user = userService.selectUserByUserName(username);
                if (user == null){
                    throw new UnknownAccountException();
                }
                if (user.getLocked().equals(SystemConstant.UserConstant.USER_ENUM.STATUS_LOCKED.getCode())){
                    throw new LockedAccountException();
                }
                credentials = user.getPassword();
                salt = user.getSalt();
            }
            /*CredentialsMatcher credentialsMatcher = getCredentialsMatcher();
            if (credentialsMatcher != null){
                LoginCredentialsMatcher loginCredentialsMatcher = (LoginCredentialsMatcher) credentialsMatcher;
                String hashAlgorithmName = loginCredentialsMatcher.getHashAlgorithmName();
                int hashIterations = loginCredentialsMatcher.getHashIterations();
                if (StringUtils.isNotBlank(hashAlgorithmName)
                        && hashAlgorithmName.equalsIgnoreCase(HASHALGORITHMNAME_MD5)){
                    credentials = ShiroMd5Util.saltMd5(passwordCheck,salt,hashIterations);
                    credentials = passwordCheck;
                }
            }*/
            ByteSource credentialsSalt = ByteSource.Util.bytes(salt);
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, getName());
            return  info;
        }else {
            throw new IncorrectCredentialsException();
        }
    }
}
