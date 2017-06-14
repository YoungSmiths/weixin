package com.wangjing.wechat.utils;

import java.lang.reflect.Constructor;

import org.apache.commons.lang.StringUtils;

import com.wangjing.wechat.operation.AbstractOperation;
import com.wangjing.wechat.pojo.message.req.BaseMessage;

/**
 * 
 * @ClassName: reflectUtils
 * @Description: TODO 反射工具类
 * @author YoungSmith
 * @date 2017年6月11日 上午1:48:09
 *
 */
public class ReflectUtils {

	/**
	 * 
	 * @Title: getInstance
	 * @Description: TODO 获取带参数实例对象
	 * @param className
	 *            反射的类名
	 * @param paramsClass
	 *            反射构造函数的实例参数
	 * @param params
	 *            反射构造函数的类型列表
	 * @return 根据获取的构造函数和参数，创建实例 Object
	 */
	public static Object getInstance(String className, Class[] paramsClass, Object[] params) {

		try {
			// 根据类名获取Class对象
			Class c = Class.forName(className);
			// 参数类型数组
			// Class[] parameterTypes = { String.class };
			// 根据参数类型获取相应的构造函数
			Constructor constructor = c.getConstructor(paramsClass);
			// 参数数组
			// Object[] parameters = { type };
			// 根据获取的构造函数和参数，创建实例
			Object opt = constructor.newInstance(params);
			return opt;
		} catch (Exception e) {
			return null;
		}
	}

	public static Object getInstance(String className) {

		try {
			Object opt = Class.forName(className).newInstance();
			return opt;
		} catch (Exception e) {
			return null;
		}
	}
}
