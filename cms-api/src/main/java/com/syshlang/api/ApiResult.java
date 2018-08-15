/*
 * Copyright (c) 2018. syshlang
 * @File: ApiResult.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-16 上午12:42
 * @since:
 */

package com.syshlang.api;

import com.syshlang.common.base.BaseResult;

/**
 *
 * @author sunys
 */
public class ApiResult  extends BaseResult {

    public ApiResult(String code, String message, Object data) {
        super(code, message, data);
    }

    public ApiResult(ApiResultConstant apiResultConstant, Object data) {
        super(apiResultConstant.getCode(), apiResultConstant.getMessage(), data);
    }
}
