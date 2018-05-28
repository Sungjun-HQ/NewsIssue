package com.pangpang.newsissue.data;

import java.io.*;
import java.net.*;

import android.graphics.*;
import android.os.*;
import android.util.*;

public class ImageLoaderFix extends AsyncTask<Integer, Integer, Integer> {

	private MyCustListAdapterFix mAdapter;

	public ImageLoaderFix(MyCustListAdapterFix mApdater) {
		this.mAdapter = mApdater;
	}

	@Override
	protected Integer doInBackground(Integer... arg0) {
		downloadBitmap(arg0[0]);
		return null;
	}

	private void downloadBitmap(Integer position) {
		Bitmap tempImage = null;

		try {
			String img_url = mAdapter.getNews_list().get(position)
					.getNewsImgUrl();
			URL url = new URL(img_url);
			InputStream is = url.openStream();
			tempImage = BitmapFactory.decodeStream(is);
			is.close();
			if (tempImage == null) {
				Log.i("ImageLoadTask", "get tempImage bitmap failed");
			} else {
				Log.i("ImageLoadTask", "get tempImage bitmap successed");
				mAdapter.getNews_list().get(position).setNewsImage(tempImage);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// newsImage = tempImage;
	}

	@Override
	protected void onPostExecute(Integer result) {
		super.onPostExecute(result);
		mAdapter.notifyDataSetChanged();
	}

}
