/*
 * Copyright (c) 2018. syshlang
 * @File: ShiroMD5Util.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-30 下午8:50
 * @since:
 */

package com.syshlang.authority.shiro.util;

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
}
