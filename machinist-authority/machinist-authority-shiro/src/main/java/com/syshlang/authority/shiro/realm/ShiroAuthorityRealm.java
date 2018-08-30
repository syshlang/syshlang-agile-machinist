/*
 * Copyright (c) 2018. syshlang
 * @File: SystemAuthorityRealm.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-27 下午9:52
 * @since:
 */

package com.syshlang.authority.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * @author sunys
 */
public class ShiroAuthorityRealm extends AuthorizingRealm {

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
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        CredentialsMatcher credentialsMatcher = getCredentialsMatcher();
        if (credentialsMatcher != null){
            HashedCredentialsMatcher hashedCredentialsMatcher = (HashedCredentialsMatcher) credentialsMatcher;
            String hashAlgorithmName = hashedCredentialsMatcher.getHashAlgorithmName();
            int hashIterations = hashedCredentialsMatcher.getHashIterations();
        }

        AuthenticationInfo authenticationInfo  = new SimpleAuthenticationInfo(username, password, getName());
        if (credentialsMatcher != null){
            boolean doCredentialsMatch = credentialsMatcher.doCredentialsMatch(authenticationToken, authenticationInfo);

        }
        return new SimpleAuthenticationInfo(username, password, getName());
    }

    public static void main(String[] args) {
        String hashAlgorithmName = "MD5";
        Object credentials = "123456";
        Object salt = ByteSource.Util.bytes("user");;
        int hashIterations = 1024;

        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        System.out.println(result);
    }
}
