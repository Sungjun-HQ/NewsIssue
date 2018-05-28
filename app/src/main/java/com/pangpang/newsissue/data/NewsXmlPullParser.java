package com.pangpang.newsissue.data;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;

import org.xmlpull.v1.*;

import android.os.*;
import android.util.*;

public class NewsXmlPullParser extends
		AsyncTask<String, String, ArrayList<NewsItem>> {

	private InputStream isText = null;
	private NewsItem mNewsItem;
	private HashMap<String, String> newsMap;
	private ArrayList<NewsItem> news_list = new ArrayList<NewsItem>();

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		// onPreExecute(), invoked on the UI thread before the task is executed.
		// This step is normally used to setup the task, for instance by showing
		// a progress bar in the user interface.
	}

	@Override
	protected ArrayList<NewsItem> doInBackground(String... params) {
		// doInBackground(Params...), invoked on the background thread
		// immediately after onPreExecute() finishes executing. This step is
		// used to perform background computation that can take a long time. The
		// parameters of the asynchronous task are passed to this step. The
		// result of the computation must be returned by this step and will be
		// passed back to the last step. This step can also use
		// publishProgress(Progress...) to publish one or more units of
		// progress. These values are published on the UI thread, in the
		// onProgressUpdate(Progress...) step.

		try {
			URL text = new URL(params[0]);
			isText = text.openStream();

			XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory
					.newInstance();
			xmlPullParserFactory.setNamespaceAware(true);
			XmlPullParser xmlPullParser = xmlPullParserFactory.newPullParser();
			xmlPullParser.setInput(isText, null); // euc-kr, UTF-8

			int eventType = xmlPullParser.getEventType();
			String nTag = null;
			boolean check_item = false;
			boolean check_title = false;
			boolean check_link = false;
			boolean check_description = false;
			boolean check_pubDate = false;

			while (eventType != XmlPullParser.END_DOCUMENT) {
				String title = null;
				String pubDate = null;
				String link = null;
				String description = null;
				Matcher matcher = null;

				switch (eventType) {
				case XmlPullParser.START_TAG:
					nTag = xmlPullParser.getName();
					if (nTag.compareTo("item") == 0) {
						check_item = true;
						newsMap = new HashMap<String, String>();
					}
					if (nTag.compareTo("title") == 0) {
						check_title = true;
					}
					if (nTag.compareTo("pubDate") == 0) {
						check_pubDate = true;
					}
					if (nTag.compareTo("link") == 0) {
						check_link = true;
					}
					if (nTag.compareTo("description") == 0) {
						check_description = true;
					}
					break;
				case XmlPullParser.TEXT:
					nTag = xmlPullParser.getName();
					if (check_item && check_title) {
						title = xmlPullParser.getText();
						newsMap.put("title", title);
					}
					if (check_item && check_pubDate) {
						pubDate = xmlPullParser.getText();
						newsMap.put("pubDate", pubDate);
					}
					if (check_item && check_link) {
						link = xmlPullParser.getText();
						newsMap.put("link", link);
					}
					if (check_item && check_description) {
						description = xmlPullParser.getText();
						newsMap.put("description", description);

						// get <img src=''>
						Pattern nonValidPattern = Pattern
								.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>");
						matcher = nonValidPattern.matcher(description);
						while (matcher.find()) {
							newsMap.put("img", matcher.group(1));
						}
					}

					break;
				case XmlPullParser.END_TAG:
					nTag = xmlPullParser.getName();
					if (nTag.compareTo("item") == 0) {
						check_item = false;
						mNewsItem = new NewsItem(newsMap);
						news_list.add(mNewsItem);
					}
					if (nTag.compareTo("title") == 0) {
						check_title = false;
					}
					if (nTag.compareTo("pubDate") == 0) {
						check_pubDate = false;
					}
					if (nTag.compareTo("link") == 0) {
						check_link = false;
					}
					if (nTag.compareTo("description") == 0) {
						check_description = false;
					}
					break;
				} // end switch~case
				eventType = xmlPullParser.next();
			} // end xmlParsing while

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			Log.e("xmlparsing", "Error >>>>>", e);
			e.printStackTrace();
		} finally {
			try {
				isText.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return news_list;
	}

	@Override
	protected void onProgressUpdate(String... values) {
		super.onProgressUpdate(values);
		// onProgressUpdate(Progress...), invoked on the UI thread after a call
		// to publishProgress(Progress...). The timing of the execution is
		// undefined. This method is used to display any form of progress in the
		// user interface while the background computation is still executing.
		// For instance, it can be used to animate a progress bar or show logs
		// in a text field.
	}

	@Override
	protected void onPostExecute(ArrayList<NewsItem> result) {
		super.onPostExecute(result);
		// onPostExecute(Result), invoked on the UI thread after the background
		// computation finishes. The result of the background computation is
		// passed to this step as a parameter.

		// mAdapter.notifyDataSetChanged();
		for (int i = 0; i < result.size(); i++) {
			// ArrayList<HashMap<String, String>> list_board = array[i];
			Log.i("xmlparsing", "Title:" + result.get(i).getNewsTitle());
			Log.i("xmlparsing", "pubDate:" + result.get(i).getNewsPubDate());
			Log.i("xmlparsing", "link:" + result.get(i).getNewsLink());
			Log.i("xmlparsing", "description:"
					+ result.get(i).getNewsDescription());
			Log.i("xmlparsing", "img:" + result.get(i).getNewsImgUrl());
		}
	}

}
