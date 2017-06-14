package com.wangjing.wechat.constants;

/**
 * 
 * @ClassName: VerificationCodeType
 * @Description: TODO
 * @author YoungSmith
 * @date 2017年6月10日 下午11:26:05
 *
 */
public interface VerificationCodeType {
	enum codeType {
		CASH, GIFT, RAFFLLE, REDPAPER
	}

	enum OperationType {
		GENERATE_VERIFICATON_CODE, DOWNLOAD
	}
}
