package com.wangjing.wechat.main;

import com.wangjing.wechat.pojo.AccessToken;
import com.wangjing.wechat.utils.WeixinUtil;
/**
 * 
* @ClassName: MenuManager 
* @Description: TODO
* @author YoungSmith
* @date 2017年6月10日 下午11:26:13 
*
 */
public class MenuManager {
	// private static Logger log = LoggerFactory.getLogger(MenuManager.class);

	public static void main(String[] args) {
		// 第三方用户唯一凭证
		String appId = "wx17f074deba8fa00a";
		// 第三方用户唯一凭证密钥
		String appSecret = "e4fb6add1f21475defffc812fdc538f1";

		// 调用接口获取access_token
//		AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);
//		System.out.println(at);
	}
}
