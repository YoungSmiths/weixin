package com.wangjing.wechat.service;

import java.io.Writer;
import java.util.Date;
import java.util.Map;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.wangjing.wechat.constants.MessageConstants;
import com.wangjing.wechat.operation.AbstractOperation;
import com.wangjing.wechat.operation.Operation;
import com.wangjing.wechat.operation.OperationFactory;
import com.wangjing.wechat.pojo.message.resp.MusicMessage;
import com.wangjing.wechat.pojo.message.resp.NewsMessage;
import com.wangjing.wechat.pojo.message.resp.TextMessage;
import com.wangjing.wechat.utils.DBCPConnection;
import com.wangjing.wechat.utils.XmlUtils;
import com.wangjing.wechat.utils.OpenDBConnection;
import com.wangjing.wechat.utils.OperatorUtil;

/**
 * 
 * @ClassName: WangjingService
 * @Description: TODO 解耦，使控制层与业务逻辑层分离开来，主要处理请求，响应
 * @author YoungSmith
 * @date 2017年6月10日 下午11:29:43
 *
 */
public class WangjingService {
	private static OperatorUtil operatorUtil;

	public static String processRequest(HttpServletRequest request) {
		String respMessage = null;
		// 默认返回的文本消息类容
		String respContent = "请求处理异常，请稍后尝试！";
		String fromUserName = "";
		String toUserName = "";
		String msgType = "";
		try {
			// xml请求解析
			Map<String, String> requestMap = XmlUtils.pareXml(request);

			// 发送方账号（open_id）
			fromUserName = requestMap.get("FromUserName");
			// 公众账号
			toUserName = requestMap.get("ToUserName");
			// 消息类型
			msgType = requestMap.get("MsgType");

			AbstractOperation operation = OperationFactory.getOperation(msgType);
			if (operation == null)
				respContent = "";
			operation.setRequestMap(requestMap);
			Object execute = operation.execute();

			respContent = execute.toString();
		} catch (Exception e) {
			return respMessage = ("<xml><ToUserName><![CDATA[" + fromUserName + "]]></ToUserName>" + "<FromUserName><![CDATA["
					+ toUserName + "]]></FromUserName><CreateTime>" + System.currentTimeMillis()
					+ "</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[" + respContent
					+ "]]></Content></xml>");
		}
		return respMessage = ("<xml><ToUserName><![CDATA[" + fromUserName + "]]></ToUserName>"
				+ "<FromUserName><![CDATA[" + toUserName + "]]></FromUserName><CreateTime>" + System.currentTimeMillis()
				+ "</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[" + respContent
				+ "]]></Content></xml>");

	}
}
