package com.wangjing.wechat.operation;

import org.apache.commons.lang.StringUtils;

import com.wangjing.wechat.pojo.message.req.BaseMessage;
import com.wangjing.wechat.utils.ReflectUtils;

public abstract class MessageOperation extends AbstractOperation {
	protected BaseMessage baseMessage;

	public BaseMessage getBaseMessage() {
		return baseMessage;
	}

	public void setBaseMessage(BaseMessage baseMessage) {
		this.baseMessage = baseMessage;
	}

	public MessageOperation(String type) {
		super();
		String className = "com.wangjing.wechat.pojo.message.req." + StringUtils.capitalize(type) + "Message";
		baseMessage = (BaseMessage) ReflectUtils.getInstance(className);
	}

	public void parseRequest() {
		String ToUserName = requestMap.get("ToUserName");
		String FromUserName = requestMap.get("FromUserName");
		long CreateTime = Long.parseLong(requestMap.get("CreateTime"));
		String MsgType = requestMap.get("MsgType");
		String MsgId = requestMap.get("MsgId");
		baseMessage.setCreateTime(CreateTime);
		baseMessage.setFromUserName(FromUserName);
		baseMessage.setMsgId(MsgId);
		baseMessage.setMsgType(MsgType);
		baseMessage.setToUserName(ToUserName);
		praseRequset2();
	}

	abstract void praseRequset2();

}
