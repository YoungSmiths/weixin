package com.wangjing.wechat.operation;

import com.wangjing.wechat.bean.VerificationCode;
import com.wangjing.wechat.constants.VerificationCodeType;
import com.wangjing.wechat.pojo.message.req.TextMessage;
import com.wangjing.wechat.pojo.redpaper.req.CommonRedPaperReq;
import com.wangjing.wechat.service.RedPaperService;
import com.wangjing.wechat.service.VerificationCodeService;

public class TextOperation extends MessageOperation {

	public TextOperation(String type) {
		super(type);
	}

	private TextMessage textMessage;

	@Override
	public Object getResponse() {
		// TODO Auto-generated method stub
		VerificationCode code = VerificationCodeService.getVerificationCode(textMessage.getContent());
		String response = "";
		if (VerificationCodeType.codeType.CASH.name().equals(code.getType())) {
			CommonRedPaperReq commonRedPaperReq = new CommonRedPaperReq();
			commonRedPaperReq.setNonce_str(textMessage.getContent());
			commonRedPaperReq.setSign("");
			commonRedPaperReq.setMch_billno(textMessage.getContent());
			commonRedPaperReq.setMch_id("");
			commonRedPaperReq.setWxappid("");
			commonRedPaperReq.setSend_name("望京印刷");
			commonRedPaperReq.setRe_openid(textMessage.getFromUserName());
			commonRedPaperReq.setTotal_amount(10);
			commonRedPaperReq.setTotal_num(1);
			commonRedPaperReq.setWishing("感谢您参加猜灯谜活动，祝您元宵节快乐！");
			commonRedPaperReq.setClient_ip("192.168.1.29");
			commonRedPaperReq.setAct_name("618活动");
			commonRedPaperReq.setRemark("猜越多得越多，快来抢！");
			// 非必须
			commonRedPaperReq.setScene_id("");
			commonRedPaperReq.setRisk_info("");
			commonRedPaperReq.setConsume_mch_id("");
			boolean flag = RedPaperService.sendRedPaper(commonRedPaperReq);
			if (flag == true)
				response = "发送红包中，请耐心等候。。。";
			else
				response = "success";
		} else if (VerificationCodeType.codeType.GIFT.equals(code.getType())) {
			response = "恭喜您获得metaBook一台";
		} else if (VerificationCodeType.codeType.RAFFLLE.equals(code.getType()))
			response = "恭喜您获取50元代金券";
		else
			response = "success";
		VerificationCodeService.setVerificatonCodeUsed(textMessage.getContent());
		return response;
	}

	@Override
	public void DeepProcessing() {

	}

	@Override
	public void done() {
		// TODO Auto-generated method stub

	}

	@Override
	void praseRequset2() {
		String content = requestMap.get("Content");
		textMessage = (TextMessage) baseMessage;
		textMessage.setContent(content);
	}

}
