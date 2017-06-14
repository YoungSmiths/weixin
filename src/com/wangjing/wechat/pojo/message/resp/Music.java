package com.wangjing.wechat.pojo.message.resp;
/**
 * 
* @ClassName: Music 
* @Description: TODO 音乐消息中的Music定义音乐中的model
* @author YoungSmith
* @date 2017年6月10日 下午11:28:35 
*
 */
public class Music {
	//音乐名称
	private String Title;
	//音乐描述
	private String Description;
	//音乐链接
	private String MusicUrl;
	//高质量音乐链接，WIFI环境下优先使用该链接播放音乐
	private String HQMusicUrl;
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
	public String getMusicUrl() {
		return MusicUrl;
	}
	public void setMusicUrl(String musicUrl) {
		MusicUrl = musicUrl;
	}
	public String getHQMusicUrl() {
		return HQMusicUrl;
	}
	public void setHQMusicUrl(String hQMusicUrl) {
		HQMusicUrl = hQMusicUrl;
	}
	
}
