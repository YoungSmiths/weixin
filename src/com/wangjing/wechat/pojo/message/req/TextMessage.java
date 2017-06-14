package com.wangjing.wechat.pojo.message.req;
/**
 * 
 * @ClassName: TextMessage
 * @Description: TODO 文本消息
 * @author YoungSmith
 * @date 2017年6月10日 下午11:27:41
 *
 */
public class TextMessage extends BaseMessage {
	// 消息内容
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public TextMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TextMessage(String toUserName, String fromUserName, long createTime, String msgType, String msgId) {
		super(toUserName, fromUserName, createTime, msgType, msgId);
		// TODO Auto-generated constructor stub
	}

}
