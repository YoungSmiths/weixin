package com.wangjing.wechat.pojo.message.req;

/**
 * 
 * @ClassName: LocationMessage
 * @Description: TODO 地理位置消息
 * @author YoungSmith
 * @date 2017年6月10日 下午11:27:23
 *
 */
public class LocationMessage extends BaseMessage {
	// 地理位置维度
	private String Location_X;
	// 地理位置经度
	private String Location_Y;
	// 地图缩放大小
	private String Scale;
	// 地理位置信息
	private String Label;

	public String getLocation_X() {
		return Location_X;
	}

	public void setLocation_X(String locationX) {
		Location_X = locationX;
	}

	public String getLocation_Y() {
		return Location_Y;
	}

	public void setLocation_Y(String locationY) {
		Location_Y = locationY;
	}

	public String getScale() {
		return Scale;
	}

	public void setScale(String scale) {
		Scale = scale;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}

	public LocationMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocationMessage(String toUserName, String fromUserName, long createTime, String msgType, String msgId) {
		super(toUserName, fromUserName, createTime, msgType, msgId);
		// TODO Auto-generated constructor stub
	}

}
