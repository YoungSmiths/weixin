package com.wangjing.wechat.pojo.message.resp;

/**
 * 
 * @ClassName: MusicMessage
 * @Description: TODO 响应的音乐消息
 * @author YoungSmith
 * @date 2017年6月10日 下午11:28:49
 *
 */
public class MusicMessage extends BaseMessage {
	// 音乐
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}

}
