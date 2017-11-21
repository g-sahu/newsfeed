package com.gsahu.newsfeed.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class NewsFeedResponse {
	@SerializedName("status")
	private String status = null;

	@SerializedName("source")
	private String source = null;

	@SerializedName("sortBy")
	private String sortBy = null;

	@SerializedName("articles")
	private List<Article> articles = null;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
}
