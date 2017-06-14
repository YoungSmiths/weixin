package com.wangjing.wechat.pojo.message.resp;

import java.util.List;

/**
 * 
 * @ClassName: NewsMessage
 * @Description: TODO 响应中的图文消息
 * @author YoungSmith
 * @date 2017年6月10日 下午11:28:59
 *
 */
public class NewsMessage extends BaseMessage {
	// 图文消息的个数，限制为10条以内
	private int ArticleCount;
	// 条条图文消息信息，默认第一个item为大图
	private List<Article> Article;

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public List<Article> getArticle() {
		return Article;
	}

	public void setArticle(List<Article> article) {
		Article = article;
	}
}
