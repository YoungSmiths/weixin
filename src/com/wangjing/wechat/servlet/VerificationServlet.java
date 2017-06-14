package com.wangjing.wechat.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangjing.wechat.constants.VerificationCodeType;
import com.wangjing.wechat.service.VerificationCodeService;
import com.wangjing.wechat.utils.XmlUtils;

public class VerificationServlet extends HttpServlet {

	public VerificationServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 消息的接受、处理、响应
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 调用核心业务类型接受消息、处理消息
		String operationType = request.getParameter("operationType");
		int size = Integer.parseInt(request.getParameter("size"));
		int length = Integer.parseInt(request.getParameter("length"));
		String version = request.getParameter("version");

		try {
			boolean flag = false;
			String respMessage = "操作失败";
			if (VerificationCodeType.OperationType.GENERATE_VERIFICATON_CODE.name().equals(operationType)) {
				flag = VerificationCodeService.generateVerificationCode(size, length);
				if (flag == true)
					respMessage = "兑奖码生成完成";
			} else if (VerificationCodeType.OperationType.DOWNLOAD.name().equals(operationType)) {
				flag = VerificationCodeService.download(version);
				if (flag == true)
					respMessage = "下载成功";
			}
			// 响应消息
			PrintWriter out = response.getWriter();
			out.print(respMessage);
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 消息的接受、处理、响应
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 调用核心业务类型接受消息、处理消息
		Map<String, String> requestMap;
		try {
			requestMap = XmlUtils.pareXml(request);
			boolean flag = false;
			String operationType = requestMap.get("operationType");
			String respMessage = "操作失败";
			if (VerificationCodeType.OperationType.GENERATE_VERIFICATON_CODE.name().equals(operationType)) {
				int size = Integer.parseInt(requestMap.get("size"));
				int length = Integer.parseInt(requestMap.get("length"));
				flag = VerificationCodeService.generateVerificationCode(size, length);
				if (flag == true)
					respMessage = "兑奖码生成完成";
			} else if (VerificationCodeType.OperationType.DOWNLOAD.name().equals(operationType)) {
				String version = requestMap.get("version");
				flag = VerificationCodeService.download(version);
				if (flag == true)
					respMessage = "下载成功";
			}
			// 响应消息
			PrintWriter out = response.getWriter();
			out.print(respMessage);
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
