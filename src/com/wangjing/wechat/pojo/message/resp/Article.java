package com.wangjing.wechat.pojo.message.resp;

/**
 * 
 * @ClassName: Article
 * @Description: TODO 图文消息中的Article类的定义图文model
 * @author YoungSmith
 * @date 2017年6月10日 下午11:28:11
 *
 */
public class Article {
	// 图文消息名称
	private String Title;
	// 图文消息描述
	private String Description;
	// 图文链接，支持JPG，PNG，格式，较好的效果为大图640*320，小图
	// 80*80，限制图片链接的域名需要与开发者填写的基本资料中的url一致
	private String PicUrl;
	// 点击图文消息跳转的链接
	private String Url;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

}
