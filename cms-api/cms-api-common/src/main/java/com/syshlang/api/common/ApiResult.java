/*
 * Copyright (c) 2018. syshlang
 * @File: ApiResult.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-17 上午3:53
 * @since:
 */

package com.syshlang.api.common;

import com.syshlang.common.base.BaseModel;
import com.syshlang.common.base.BaseResult;
import com.syshlang.common.base.BaseResultCode;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sunys
 */
@XmlRootElement
public class ApiResult<T extends BaseModel>  extends BaseResult {

    public ApiResult() {
    }

    public ApiResult(Integer code, String message, Object data) {
        super(code, message, data);
    }

    public ApiResult(Integer code, String message) {
        super(code, message);
    }

    public ApiResult(ApiResultConstant apiResultConstant, Object data) {
        super(apiResultConstant.getCode(), apiResultConstant.getMessage(), data);
    }

    public ApiResult(BaseResultCode baseResultCode){
        super(baseResultCode);
    }


}
