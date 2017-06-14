package com.wangjing.wechat.pojo.message.resp;

/**
 * 
 * @ClassName: TextMessage
 * @Description: TODO 响应文本消息
 * @author YoungSmith
 * @date 2017年6月10日 下午11:29:10
 *
 */
public class TextMessage extends BaseMessage {
	// 回复的消息类容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

}
