package com.wangjing.wechat.operation;

import java.util.Map;

/**
 * 
 * @ClassName: AbstractOperation
 * @Description: TODO
 * @author YoungSmith
 * @date 2017年6月11日 上午12:31:08
 *
 */
public abstract class AbstractOperation implements Operation {
	private Object response;

	protected Map<String, String> requestMap;

	public abstract void parseRequest();

	public abstract Object getResponse();

	public abstract void DeepProcessing();

	public abstract void done();

	public Object execute() {
		parseRequest();
		DeepProcessing();
		response = getResponse();
		done();
		return response;
	}

	public void setRequestMap(Map<String, String> requestMap) {
		this.requestMap = requestMap;
	}

	Map<String, String> getRequestMap() {
		return requestMap;
	}

}
