/*
 * Copyright (c) 2018. syshlang
 * @File: ShiroAuthorityRealm.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-30 下午9:23
 * @since:
 */

package com.syshlang.system.authority.shiro.realm;

import com.syshlang.system.api.user.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;



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
        return new SimpleAuthorizationInfo();
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
            String password = new String(usernamePasswordToken.getPassword());
            LOGGER.info("ShiroAuthorityRealm#AuthenticationInfo:{}",username);
           // User user = userService.selectUserByUserName(username);
        }





     /*   CredentialsMatcher credentialsMatcher = getCredentialsMatcher();
        if (credentialsMatcher != null){
            HashedCredentialsMatcher hashedCredentialsMatcher = (HashedCredentialsMatcher) credentialsMatcher;
            String hashAlgorithmName = hashedCredentialsMatcher.getHashAlgorithmName();
            int hashIterations = hashedCredentialsMatcher.getHashIterations();
            if (StringUtils.isNotBlank(hashAlgorithmName)
                    && hashAlgorithmName.equalsIgnoreCase(HASHALGORITHMNAME_MD5)){
                ShiroMd5Util.saltMd5(hashAlgorithmName,)
            }

        }

        AuthenticationInfo authenticationInfo  = new SimpleAuthenticationInfo(username, password, getName());
        if (credentialsMatcher != null){
            boolean doCredentialsMatch = credentialsMatcher.doCredentialsMatch(authenticationToken, authenticationInfo);

        }
        return new SimpleAuthenticationInfo(username, password, getName());*/
        return null;
    }
}
