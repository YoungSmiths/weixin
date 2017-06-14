package com.wangjing.wechat.pojo.message.resp;

/**
 * 
 * @ClassName: BaseMessage
 * @Description: TODO 消息基类
 * @author YoungSmith
 * @date 2017年6月10日 下午11:28:26
 *
 */
public class BaseMessage {
	// 接收方账号（收到的openId）
	private String ToUserName;
	// 开发者微信号
	private String FromUserName;
	// 消息创建时间(整型)
	private long CreateTime;
	// 消息类型（text/music/news）
	private String MsgType;
	// 位0x0001 被标记时，星标刚收到的消息
	private int FuncFlag;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public int getFuncFlag() {
		return FuncFlag;
	}

	public void setFuncFlag(int funcFlag) {
		FuncFlag = funcFlag;
	}
}
