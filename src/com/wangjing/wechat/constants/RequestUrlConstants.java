package com.wangjing.wechat.constants;

import com.wangjing.wechat.utils.Pair;

/**
 * 
 * @ClassName: RequestUrlConstants
 * @Description: TODO
 * @author YoungSmith
 * @date 2017年6月10日 下午11:25:56
 *
 */
public interface RequestUrlConstants {

	enum METHOD {
		POST, GET
	}
	String REDPAPER_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";
	Pair<String, METHOD> REDPAPER_URL_PAIR = new Pair<String, METHOD>(REDPAPER_URL, METHOD.POST);
	
}
