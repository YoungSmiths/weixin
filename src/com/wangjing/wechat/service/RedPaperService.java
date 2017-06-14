package com.wangjing.wechat.service;

import java.io.InputStream;
import java.util.Map;

import com.wangjing.wechat.constants.RequestUrlConstants;
import com.wangjing.wechat.pojo.redpaper.req.CommonRedPaperReq;
import com.wangjing.wechat.utils.WeixinUtil;
import com.wangjing.wechat.utils.XmlUtils;

public class RedPaperService {
	public static boolean sendRedPaper(CommonRedPaperReq commonRedPaperReq) {
		// StringBuilder inputStr = new StringBuilder();
		//
		// inputStr.append("<xml>");
		// inputStr.append("<sign><![CDATA[E1EE61A91C8E90F299DE6AE075D60A2D]]></sign>");
		// inputStr.append("<mch_billno><![CDATA[0010010404201411170000046545]]></mch_billno>");
		// inputStr.append("<mch_id><![CDATA[888]]></mch_id>");
		// inputStr.append("<wxappid><![CDATA[wxcbda96de0b165486]]></wxappid>");
		// inputStr.append("<send_name><![CDATA[send_name]]></send_name>");
		// inputStr.append("<re_openid><![CDATA[onqOjjmM1tad-3ROpncN-yUfa6uI]]></re_openid>");
		// inputStr.append("<total_amount><![CDATA[200]]></total_amount>");
		// inputStr.append("<total_num><![CDATA[1]]></total_num>");
		// inputStr.append("<wishing><![CDATA[恭喜发财]]></wishing>");
		// inputStr.append("<client_ip><![CDATA[127.0.0.1]]></client_ip>");
		// inputStr.append("<act_name><![CDATA[新年红包]]></act_name>");
		// inputStr.append("<remark><![CDATA[新年红包]]></remark>");
		// inputStr.append("<scene_id><![CDATA[PRODUCT_2]]></scene_id>");
		// inputStr.append("<consume_mch_id><![CDATA[10000097]]></consume_mch_id>");
		// inputStr.append("<nonce_str><![CDATA[50780e0cca98c8c8e814883e5caa672e]]></nonce_str>");
		// inputStr.append(
		// "<risk_info>posttime%3d123123412%26clientversion%3d234134%26mobile%3d122344545%26deviceid%3dIOS</risk_info>");
		// inputStr.append("</xml>");
		String commonRedPaperReqToXml = XmlUtils.commonRedPaperReqToXml(commonRedPaperReq);
		InputStream inputStream = WeixinUtil.httpRequestWithInputStream(RequestUrlConstants.REDPAPER_URL_PAIR.first(),
				RequestUrlConstants.REDPAPER_URL_PAIR.second().name(), commonRedPaperReqToXml);
		Map<String, String> pareXml = null;
		try {
			pareXml = XmlUtils.pareXml(inputStream);
			System.out.println(pareXml.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (pareXml == null)
			return false;
		else
			return dealResponse(pareXml);
	}

	private static boolean dealResponse(Map<String, String> pareXml) {
		String return_code = pareXml.get("return_code");
		String return_msg = pareXml.get("return_msg");
		if (return_code.equals("SUCCESS")) {
			String sign = pareXml.get("sign");
			String result_code = pareXml.get("result_code");
			String err_code = pareXml.get("err_code");
			String err_code_des = pareXml.get("err_code_des");
		}
		String mch_billno = pareXml.get("mch_billno");
		String mch_id = pareXml.get("mch_id");
		String wxappid = pareXml.get("wxappid");
		String re_openid = pareXml.get("re_openid");
		String total_amount = pareXml.get("total_amount");
		String send_listid = pareXml.get("send_listid");

		return true;
	}

	public static void main(String[] args) {
		CommonRedPaperReq CommonRedPaperReq = new CommonRedPaperReq();
		sendRedPaper(CommonRedPaperReq);
	}
}
