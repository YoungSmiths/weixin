package com.wangjing.wechat.utils;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * 
 * @ClassName: MyX509TrustManager
 * @Description: TODO 证书信任管理器（用于https请求）
 * @author YoungSmith
 * @date 2017年6月10日 下午11:30:51
 *
 */
public class MyX509TrustManager implements X509TrustManager {
	public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
	}

	public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
	}

	public X509Certificate[] getAcceptedIssuers() {
		return null;
	}
}
