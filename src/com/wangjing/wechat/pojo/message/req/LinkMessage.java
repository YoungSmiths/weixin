package com.wangjing.wechat.pojo.message.req;

/**
 * 
 * @ClassName: LinkMessage
 * @Description: TODO 链接消息
 * @author YoungSmith
 * @date 2017年6月10日 下午11:27:14
 *
 */
public class LinkMessage extends BaseMessage {
	// 消息标题
	private String Title;
	// 消息描述
	private String Description;
	// 消息链接
	private String Url;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public LinkMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LinkMessage(String toUserName, String fromUserName, long createTime, String msgType, String msgId) {
		super(toUserName, fromUserName, createTime, msgType, msgId);
		// TODO Auto-generated constructor stub
	}

}
