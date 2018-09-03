/*
 * Copyright (c) 2018. syshlang
 * @File: EnumUtil.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-30 下午10:28
 * @since:
 */

package com.syshlang.common.util.enumutil;

import org.apache.commons.lang3.EnumUtils;

import java.lang.reflect.Field;

/**
 * 枚举类工具
 * @author sunys
 */
public class EnumUtil extends EnumUtils {
    /**
     *
     * @param enumInstance 枚举常量
     * @param value 枚举常量的value
     * @param <T> 枚举的类型参数
     */
    public static <T extends Enum<T>> void changeNameTo(T enumInstance, String value) {
        try {
            Field fieldName = enumInstance.getClass().getSuperclass().getDeclaredField("name");
            fieldName.setAccessible(true);
            fieldName.set(enumInstance, value);
            fieldName.setAccessible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 枚举类型的比较，包括null
     * @param enum1
     * @param enum2
     * @return 如果相等返回true, 否则返回false
     */
    public static boolean enumEquals(Enum enum1, Enum enum2) {
        if (enum1 == null && enum2 == null) {
            return true;
        } else if (enum1 != null) {
            return enum1.equals(enum2);
        } else {
            return enum2.equals(enum1);
        }
    }
}
