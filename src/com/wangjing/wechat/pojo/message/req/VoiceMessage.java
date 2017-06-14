package com.wangjing.wechat.pojo.message.req;

/**
 * 
 * @ClassName: VoiceMessage
 * @Description: TODO 语音消息
 * @author YoungSmith
 * @date 2017年6月10日 下午11:27:56
 *
 */
public class VoiceMessage extends BaseMessage {
	// 媒体Id
	private String MediaId;
	// 语音格式
	private String Format;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

	public VoiceMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VoiceMessage(String toUserName, String fromUserName, long createTime, String msgType, String msgId) {
		super(toUserName, fromUserName, createTime, msgType, msgId);
		// TODO Auto-generated constructor stub
	}

}
