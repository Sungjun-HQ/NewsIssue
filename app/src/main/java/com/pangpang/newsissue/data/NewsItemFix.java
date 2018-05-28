package com.pangpang.newsissue.data;

import java.util.HashMap;

import android.graphics.Bitmap;

public class NewsItemFix {

	private String newsTitle;
	private String newsPubDate;
	private String newsLink;
	private String newsDescription;
	private String newsImgUrl;
	private Bitmap newsImage;

	public NewsItemFix(HashMap<String, String> map) {
		this.newsTitle = map.get("title");
		this.newsPubDate = map.get("pubDate");
		this.newsLink = map.get("link");
		this.newsDescription = map.get("description");
		this.newsImgUrl = map.get("img");

		// load or default image
		this.newsImage = null;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public String getNewsPubDate() {
		return newsPubDate;
	}

	public String getNewsLink() {
		return newsLink;
	}

	public String getNewsDescription() {
		return newsDescription;
	}

	public String getNewsImgUrl() {
		return newsImgUrl;
	}

	public Bitmap getNewsImage() {
		return newsImage;
	}

	public void setNewsImage(Bitmap newsImage) {
		this.newsImage = newsImage;
	}
}
