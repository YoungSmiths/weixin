package com.wangjing.wechat.utils;

import com.wangjing.wechat.constants.Constants;

public class Utils {
	public static String getCDATA(String data) {
		return Constants.CDATA_START + data + Constants.CDATA_END;
	}
}
