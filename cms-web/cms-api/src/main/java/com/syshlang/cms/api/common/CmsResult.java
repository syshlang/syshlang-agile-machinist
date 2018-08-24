/*
 * Copyright (c) 2018. syshlang
 * @File: CmsResult.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-24 上午11:43
 * @since:
 */

package com.syshlang.cms.api.common;

import com.syshlang.api.common.ApiResult;
import com.syshlang.common.util.MessageSourceHelper;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author sunys
 * @date 2018/8/24
 */
public class CmsResult extends ApiResult {

    private static final long serialVersionUID = 3437023624782204381L;

    private String  resource;

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public CmsResult() {
    }

    public CmsResult(Integer code, String message, Object data) {
        super(code, message, data);
    }

    public CmsResult(Integer code, String message) {
        super(code, message);
    }

    public CmsResult(CmsResultCode cmsResultCode, Object data) {
        super(cmsResultCode.getCode(), cmsResultCode.getDesc(), data);
    }

    public CmsResult(CmsResultCode cmsResultCode) {
        this.code = cmsResultCode.getCode();
        this.resource = cmsResultCode.getResource();
        if (StringUtils.isBlank(cmsResultCode.getResource())){
            this.desc = cmsResultCode.getDesc();
        }else{
            String message = MessageSourceHelper.getMessage(cmsResultCode.getResource());
            if (StringUtils.isNotBlank(message)){
                this.desc = message;
            }else{
                this.desc = cmsResultCode.getDesc();
            }
        }
    }
}
