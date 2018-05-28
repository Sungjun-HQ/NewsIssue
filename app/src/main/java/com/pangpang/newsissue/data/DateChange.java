package com.pangpang.newsissue.data;

import java.util.HashMap;

public class DateChange {

	public String changeDate(String pubDate) {

		// Mon, 07 Oct 2013 09:47:36 +0900 (31)
		String temp = pubDate.substring(12, 16) + "년 "
				+ changeMonth(pubDate.substring(8, 11)) + "월 "
				+ pubDate.substring(5, 7) + "일 " + pubDate.substring(17, 19)
				+ "시 " + pubDate.substring(20, 22) + "분";

		return temp;
	}

	public String inewsDate(String pubDate) {

		// Mon,07 Oct 2013 08:02:02 +0900 (30)
		String temp = pubDate.substring(11, 15) + "년 "
				+ changeMonth(pubDate.substring(7, 10)) + "월 "
				+ pubDate.substring(4, 6) + "일 " + pubDate.substring(16, 18)
				+ "시 " + pubDate.substring(19, 21) + "분";

		return temp;
	}

	public String kukinewsDate(String pubDate) {

		// 7 Oct 2013 04:12:01 GMT (24)
		String temp = pubDate.substring(7, 11) + "년 "
				+ changeMonth(pubDate.substring(2, 5)) + "월 "
				+ pubDate.substring(0, 1) + "일 "
				+ (Integer.parseInt(pubDate.substring(12, 14)) + 9) + "시 "
				+ pubDate.substring(15, 17) + "분";

		return temp;
	}

	public String ohmynewsDate(String pubDate) {
		// 2013-10-07T14:24:01+09:00 Joins
		// 2013-10-07T10:28:02+09:00 (25)
		String temp = pubDate.substring(0, 4) + "년 " + pubDate.substring(5, 7)
				+ "월 " + pubDate.substring(8, 10) + "일 "
				+ pubDate.substring(11, 13) + "시 " + pubDate.substring(14, 16)
				+ "분";

		return temp;
	}

	public String mbcDate(String pubDate) {
		// 2013.10.07 13:23:33 (19)
		String temp = pubDate.substring(0, 4) + "년 " + pubDate.substring(5, 7)
				+ "월 " + pubDate.substring(8, 10) + "일 "
				+ pubDate.substring(11, 13) + "시 " + pubDate.substring(14, 16)
				+ "분";

		return temp;
	}

	public String mkDate(String pubDate) {
		// Mon, 07 Oct 2013 04:59:13 GMT (20)
		String temp = pubDate.substring(12, 16) + "년 "
				+ changeMonth(pubDate.substring(8, 11)) + "월 "
				+ pubDate.substring(5, 7) + "일 "
				+ (Integer.parseInt(pubDate.substring(17, 19)) + 9) + "시 "
				+ pubDate.substring(20, 22) + "분";

		return temp;
	}

	private String changeMonth(String month) {
		String mMonth = "";

		HashMap<String, String> monthMap = new HashMap<String, String>();
		monthMap.put("Jan", "1");
		monthMap.put("Feb", "2");
		monthMap.put("Mar", "3");
		monthMap.put("Apr", "4");
		monthMap.put("May", "5");
		monthMap.put("Jun", "6");
		monthMap.put("Jul", "7");
		monthMap.put("Aug", "8");
		monthMap.put("Sep", "9");
		monthMap.put("Oct", "10");
		monthMap.put("Nov", "11");
		monthMap.put("Dec", "12");

		mMonth = monthMap.get(month);

		return mMonth;
	}
}
