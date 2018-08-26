/*
 * Copyright (c) 2018. syshlang
 * @File: EncryptPropertyPlaceholderConfigurer.java
 * @Description:
 * @Author: sunys
 * @Date: 18-8-26 下午5:39
 * @since:
 */

package com.syshlang.common.plugin;


import com.syshlang.common.util.AESUtil;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 支持加密配置文件
 *
 * @author sunys
 * @date 2017/2/4
 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	/**
	 * 解密指定propertyName的加密属性值
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 */
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		if (propertyName.toLowerCase().endsWith("password")){
			return AESUtil.aesDecode(propertyValue);
		}
		return super.convertProperty(propertyName, propertyValue);
	}

	/*
	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props){
		//对配置文件中的数据库密码密文进行解密
		String password=(String) props.get("jdbc.password");
		if (password != null){
			props.setProperty("jdbc.password" , AESUtil.aesDecode(password));
		}
		super.processProperties(beanFactoryToProcess, props);
	}
	*/
}
