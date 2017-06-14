package com.wangjing.wechat.operation;

import org.apache.commons.lang.StringUtils;

import com.wangjing.wechat.utils.ReflectUtils;

public class OperationFactory {

	public static AbstractOperation getOperation(String type) {
		String className = "com.wangjing.wechat.operation." + StringUtils.capitalize(type) + "Operation";
		Class[] parameterTypes = { String.class };
		Object[] parameters = { type };
		AbstractOperation opt = (AbstractOperation) ReflectUtils.getInstance(className, parameterTypes, parameters);
		return opt;
	}
}
