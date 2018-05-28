package com.pangpang.newsissue.news;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.pangpang.newsissue.R;
import com.pangpang.newsissue.data.ImageLoader;
import com.pangpang.newsissue.data.MyCustListAdapter;
import com.pangpang.newsissue.data.NewsItem;
import com.pangpang.newsissue.data.NewsXmlPullParser;

@SuppressLint("ValidFragment")
public class NewsMainFragment extends Fragment implements OnScrollListener {

	private Context mContext;
	private MyCustListAdapter MyCustListAdapter;
	private ArrayList<NewsItem> newList;
	private ListView list;
	private int taskPosition = -1;
	private String url;

	public NewsMainFragment(Context context, String url) {
		mContext = context;
		this.url = url;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		newList = new ArrayList<NewsItem>();

		NewsXmlPullParser xp = new NewsXmlPullParser();
		xp.execute(url);
		try {
			newList = xp.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.newlist, container, false);

		list = (ListView) root.findViewById(R.id.news);

		MyCustListAdapter = new MyCustListAdapter(mContext, R.layout.list_row,
				newList);

		list.setAdapter(MyCustListAdapter);
		list.setOnScrollListener(this);

		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				Intent intent = new Intent(mContext, NewsIn.class);
				intent.putExtra("index", position);
				intent.putExtra("title", newList.get(position).getNewsTitle());
				intent.putExtra("description", newList.get(position)
						.getNewsDescription());
				if (newList.get(position).getNewsImage() != null) {
					intent.putExtra("image", newList.get(position)
							.getNewsImage());
				}
				intent.putExtra("link", newList.get(position).getNewsLink());
				startActivity(intent);
			}
		});

		return root;
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		for (int i = firstVisibleItem; i < (firstVisibleItem + visibleItemCount); i++) {
			if (taskPosition < i) {
				startThread(i);
				taskPosition = i;
			}
		}
	}

	private void startThread(int position) {
		ImageLoader imgLoadTask = new ImageLoader(MyCustListAdapter);
		imgLoadTask.execute(position);
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {

	}

	public ArrayList<NewsItem> getNewList() {
		return newList;
	}

}
