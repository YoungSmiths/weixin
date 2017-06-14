package com.wangjing.wechat.constants;

/**
 * 
 * @ClassName: MessageConstants
 * @Description: TODO 消息类型
 * @author YoungSmith
 * @date 2017年6月11日 上午12:03:52
 *
 */
public interface MessageConstants {
	/**
	 * 返回信息类型：文本
	 */
	String RESP_MESSSAGE_TYPE_TEXT = "text";
	/**
	 * 返回信息类型：音乐
	 */
	String RESP_MESSSAGE_TYPE_MUSIC = "music";
	/**
	 * 返回信息类型：图文
	 */
	String RESP_MESSSAGE_TYPE_NEWS = "news";
	/**
	 * 请求信息类型：文本
	 */
	String REQ_MESSSAGE_TYPE_TEXT = "text";
	/**
	 * 请求信息类型：图片
	 */
	String REQ_MESSSAGE_TYPE_IMAGE = "image";
	/**
	 * 请求信息类型：链接
	 */
	String REQ_MESSSAGE_TYPE_LINK = "link";
	/**
	 * 请求信息类型：地理位置
	 */
	String REQ_MESSSAGE_TYPE_LOCATION = "location";
	/**
	 * 请求信息类型：音频
	 */
	String REQ_MESSSAGE_TYPE_VOICE = "voice";
	/**
	 * 请求信息类型：推送
	 */
	String REQ_MESSSAGE_TYPE_EVENT = "event";
	/**
	 * 事件类型：subscribe（订阅）
	 */
	String EVENT_TYPE_SUBSCRIBE = "subscribe";
	/**
	 * 事件类型：unsubscribe（取消订阅）
	 */
	String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
	/**
	 * 事件类型：click（自定义菜单点击事件）
	 */
	String EVENT_TYPE_CLICK = "CLICK";

	/**
	 * 事件类型：view（自定义菜单点击事件,返回url）
	 */
	String EVENT_TYPE_VIEW = "VIEW";

}
