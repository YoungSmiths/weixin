package com.wangjing.wechat.pojo.message.req;

/**
 * 
 * @ClassName: VideoMessage
 * @Description: TODO
 * @author YoungSmith
 * @date 2017年6月10日 下午11:27:49
 *
 */
public class VideoMessage extends BaseMessage {
	private String MediaId;
	private String ThumbMediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

	public VideoMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VideoMessage(String toUserName, String fromUserName, long createTime, String msgType, String msgId) {
		super(toUserName, fromUserName, createTime, msgType, msgId);
		// TODO Auto-generated constructor stub
	}

}
