/*
 * Copyright (c) 2018. syshlang
 * @File: ShiroMd5Util.java
 * @Description:
 * @Author: sunys
 * @Date: 18-9-20 下午9:59
 * @since:
 */

package com.syshlang.system.sso.client.util;


import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author sunys
 */
public class ShiroMd5Util {

    /***
     * MD5加盐迭代算法
     * @param credentials
     * @param salt
     * @param hashIterations
     * @return
     */
    public static String  saltMd5(String credentials, String salt,int hashIterations){
        String hashAlgorithmName = "MD5";
        if (StringUtils.isBlank(credentials)){
            return null;
        }
        if (StringUtils.isBlank(salt)){
            return  null;
        }
        ByteSource byteSource = ByteSource.Util.bytes(salt);
        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName, credentials, byteSource, hashIterations);
        if (simpleHash != null){
            return simpleHash.toString();
        }
        return null;
    }


    public static void main(String[] args) {
        String credentials = "123456";
        String salt = "sunys";
        int hashIterations = 1024;
        System.out.println(saltMd5(credentials,salt,hashIterations));
    }
}
