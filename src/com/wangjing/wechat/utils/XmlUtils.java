package com.wangjing.wechat.utils;

import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.wangjing.wechat.pojo.message.resp.Article;
import com.wangjing.wechat.pojo.message.resp.MusicMessage;
import com.wangjing.wechat.pojo.message.resp.NewsMessage;
import com.wangjing.wechat.pojo.message.resp.TextMessage;
import com.wangjing.wechat.pojo.redpaper.req.CommonRedPaperReq;

/**
 * 
 * @ClassName: MessageUtil
 * @Description: TODO 各种消息的处理类
 * @author YoungSmith
 * @date 2017年6月10日 下午11:30:40
 *
 */

public class XmlUtils {

	/**
	 * 解析微信发来的请求 XML
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> pareXml(HttpServletRequest request) throws Exception {

		// 将解析的结果存储在HashMap中
		Map<String, String> reqMap = new HashMap<String, String>();

		// 从request中取得输入流
		InputStream inputStream = request.getInputStream();
		// 读取输入流
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);
		// 得到xml根元素
		Element root = document.getRootElement();
		// 得到根元素的所有子节点
		List<Element> elementList = root.elements();
		// 遍历所有的子节点取得信息类容
		for (Element elem : elementList) {
			reqMap.put(elem.getName(), elem.getText());
		}
		// 释放资源
		inputStream.close();
		inputStream = null;

		return reqMap;
	}

	/**
	 * 解析微信发来的请求 XML
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> pareXml(InputStream inputStream) throws Exception {

		// 将解析的结果存储在HashMap中
		Map<String, String> reqMap = new HashMap<String, String>();

		// 读取输入流
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);
		// 得到xml根元素
		Element root = document.getRootElement();
		// 得到根元素的所有子节点
		List<Element> elementList = root.elements();
		// 遍历所有的子节点取得信息类容
		for (Element elem : elementList) {
			reqMap.put(elem.getName(), elem.getText());
		}
		// 释放资源
		inputStream.close();
		inputStream = null;

		return reqMap;
	}

	/**
	 * 响应消息转换成xml返回 文本消息对象转换成xml
	 */
	public static String textMessageToXml(TextMessage textMessage) {
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}

	/**
	 * 音乐消息的对象的转换成xml
	 * 
	 */
	public static String musicMessageToXml(MusicMessage musicMessage) {
		xstream.alias("xml", musicMessage.getClass());
		return xstream.toXML(musicMessage);
	}

	/**
	 * 图文消息的对象转换成xml
	 * 
	 */
	public static String newsMessageToXml(NewsMessage newsMessage) {
		xstream.alias("xml", newsMessage.getClass());
		xstream.alias("item", new Article().getClass());
		return xstream.toXML(newsMessage);
	}

	/**
	 * 普通红包请求对象转换成xml
	 */
	public static String commonRedPaperReqToXml(CommonRedPaperReq commonRedPaperReq) {
		xstream.alias("xml", commonRedPaperReq.getClass());
		return xstream.toXML(commonRedPaperReq);
	}

	/**
	 * 拓展xstream，使得支持CDATA块
	 * 
	 */
	private static XStream xstream = new XStream(new XppDriver() {
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				// 对所有的xml节点的转换都增加CDATA标记
				boolean cdata = true;

				@SuppressWarnings("unchecked")
				public void startNode(String name, Class clazz) {
					super.startNode(name, clazz);
				}

				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});

}
