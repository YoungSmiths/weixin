package com.wangjing.wechat.pojo.message.req;

/**
 * 
 * @ClassName: ImageMessage
 * @Description: TODO 图片消息
 * @author YoungSmith
 * @date 2017年6月10日 下午11:26:58
 *
 */
public class ImageMessage extends BaseMessage {
	// 图片链接（由系统生成）
	private String PicUrl;
	// 图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
	private String mediaId;

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public ImageMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImageMessage(String toUserName, String fromUserName, long createTime, String msgType, String msgId) {
		super(toUserName, fromUserName, createTime, msgType, msgId);
		// TODO Auto-generated constructor stub

	}

	public ImageMessage(String picUrl, String mediaId) {
		super();
		PicUrl = picUrl;
		this.mediaId = mediaId;
	}

}
