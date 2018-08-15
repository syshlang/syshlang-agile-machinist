/*
 * Copyright (c) 2018. syshlang
 * @File: MessageUtils.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-15 下午11:35
 * @since:
 */

package com.syshlang.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import sun.misc.MessageUtils;

/**
 * @author sunys
 */
public class MyMessageUtils extends MessageUtils{

    private static final long serialVersionUID = 1L;
    private static Logger log = LoggerFactory.getLogger(MyMessageUtils.class);

    public static String message(String code, Object[] args) {
        MessageSource messageSource = SpringUtils.getBean(MessageSource.class);
        return messageSource.getMessage(code, args, null);
    }
}
