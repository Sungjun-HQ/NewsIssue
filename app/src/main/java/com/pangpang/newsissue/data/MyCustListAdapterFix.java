package com.pangpang.newsissue.data;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pangpang.newsissue.R;

public class MyCustListAdapterFix extends BaseAdapter {

	Context context;
	LayoutInflater Inflater;
	ArrayList<NewsItemFix> news_list;
	int layout;

	public MyCustListAdapterFix(Context context, int layout,
			ArrayList<NewsItemFix> news_list) {
		this.context = context;
		Inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.news_list = news_list;
		this.layout = layout;
	}

	@Override
	public int getCount() {
		return news_list.size();
	}

	public ArrayList<NewsItemFix> getNews_list() {
		return news_list;
	}

	@Override
	public Object getItem(int positon) {
		return news_list.get(positon);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		NewsItemFix m = news_list.get(position);
		ViewHolder holder;
		if (convertView == null) {
			convertView = Inflater.inflate(layout, parent, false);
			// convertView = Inflater.inflate(R.layout.list_row, null);
			holder = new ViewHolder();
			holder.title = (TextView) convertView.findViewById(R.id.list_title);
			holder.pubdate = (TextView) convertView
					.findViewById(R.id.list_pubDate);
			holder.img = (ImageView) convertView.findViewById(R.id.list_img);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.title.setText(m.getNewsTitle());
		holder.pubdate.setText(m.getNewsPubDate());
		if (m.getNewsImage() != null) {
			holder.img.setImageBitmap(m.getNewsImage());
			holder.img.setVisibility(View.VISIBLE);
		} else {
			holder.img.setImageBitmap(null);
			holder.img.setVisibility(View.GONE);
		}

		return convertView;
	}

	static class ViewHolder {
		TextView title;
		TextView pubdate;
		ImageView img;
	}
}
