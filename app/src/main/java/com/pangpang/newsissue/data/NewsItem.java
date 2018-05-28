package com.pangpang.newsissue.data;

import java.util.HashMap;

import android.graphics.Bitmap;
import android.util.Log;

public class NewsItem {

	private String newsTitle;
	private String newsPubDate;
	private String newsLink;
	private String newsDescription;
	private String newsImgUrl;
	private Bitmap newsImage;

	public NewsItem(HashMap<String, String> map) {
		this.newsTitle = map.get("title");
		this.newsPubDate = map.get("pubDate");
		this.newsLink = map.get("link");
		this.newsDescription = map.get("description");
		this.newsImgUrl = map.get("img");

		// load or default image
		this.newsImage = null;
		if (newsPubDate != null) {
			Log.i("length", "newsPubDate.length():" + newsPubDate.length());

			DateChange dc = new DateChange();
			if (31 <= newsPubDate.length()) {
				this.newsPubDate = dc.changeDate(newsPubDate);
			} else if (newsPubDate.length() == 30) {
				this.newsPubDate = dc.inewsDate(newsPubDate);
			} else if (newsPubDate.length() == 24) {
				this.newsPubDate = dc.kukinewsDate(newsPubDate);
			} else if (newsPubDate.length() == 25) {
				this.newsPubDate = dc.ohmynewsDate(newsPubDate);
			} else if (newsPubDate.length() == 19) {
				this.newsPubDate = dc.mbcDate(newsPubDate);
			} else if (newsPubDate.length() == 29) {
				this.newsPubDate = dc.mkDate(newsPubDate);
			}
		}
	}

	// private String changeDate(String pubDate) {
	//
	// String temp = pubDate.substring(12, 16) + "년 "
	// + changeMonth(pubDate.substring(8, 11)) + "월 "
	// + pubDate.substring(5, 7) + "일 " + pubDate.substring(17, 19)
	// + "시 " + pubDate.substring(20, 22) + "분";
	//
	// return temp;
	// }
	//
	// private String changeMonth(String month) {
	// String mMonth = "";
	//
	// HashMap<String, String> monthMap = new HashMap<String, String>();
	// monthMap.put("Jan", "1");
	// monthMap.put("Feb", "2");
	// monthMap.put("Mar", "3");
	// monthMap.put("Apr", "4");
	// monthMap.put("May", "5");
	// monthMap.put("Jun", "6");
	// monthMap.put("Jul", "7");
	// monthMap.put("Aug", "8");
	// monthMap.put("Sep", "9");
	// monthMap.put("Oct", "10");
	// monthMap.put("Nov", "11");
	// monthMap.put("Dec", "12");
	//
	// mMonth = monthMap.get(month);
	//
	// return mMonth;
	// }

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

	public void setNewsPubDate(String newsPubDate) {
		this.newsPubDate = newsPubDate;
	}
}
