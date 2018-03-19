package com.gsahu.newsfeed.model;

import com.google.gson.annotations.SerializedName;

public class Article {
	private int id;
	
	@SerializedName("author")
	private String author = null;

	@SerializedName("title")
	private String title = null;
	
	@SerializedName("description")
	private String description = null;
	
	@SerializedName("url")
	private String url = null;
	
	@SerializedName("urlToImage")
	private String urlToImage = null;
	
	@SerializedName("publishedAt")
	private String publishedAt = null;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlToImage() {
		return urlToImage;
	}

	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}

	public String getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(String publishedAt) {
		this.publishedAt = publishedAt;
	}
}
