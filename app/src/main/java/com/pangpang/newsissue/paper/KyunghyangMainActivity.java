package com.pangpang.newsissue.paper;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.pangpang.newsissue.R;
import com.pangpang.newsissue.news.NewsMainFragmentFix;

public class KyunghyangMainActivity extends FragmentActivity implements
		ActionBar.TabListener {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	NewsMainFragmentFix nm1;
	NewsMainFragmentFix nm2;
	NewsMainFragmentFix nm3;
	NewsMainFragmentFix nm4;
	NewsMainFragmentFix nm5;
	NewsMainFragmentFix nm6;
	NewsMainFragmentFix nm7;
	NewsMainFragmentFix nm8;
	NewsMainFragmentFix nm9;
	NewsMainFragmentFix nm10;
	NewsMainFragmentFix nm11;
	NewsMainFragmentFix nm12;
	NewsMainFragmentFix nm13;

	Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news_activity_main);

		// Set up the action bar.
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getApplicationContext(), getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		// When swiping between different sections, select the corresponding
		// tab. We can also use ActionBar.Tab#select() to do this if we have
		// a reference to the Tab.
		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);
					}
				});

		// For each of the sections in the app, add a tab to the action bar.
		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
			// Create a tab with text corresponding to the page title defined by
			// the adapter. Also specify this Activity object, which implements
			// the TabListener interface, as the callback (listener) for when
			// this tab is selected.
			actionBar.addTab(actionBar.newTab()
					.setText(mSectionsPagerAdapter.getPageTitle(i))
					.setTabListener(this));
		}

		new Thread(new Runnable() {

			@Override
			public void run() {
				nm1 = new NewsMainFragmentFix(mContext,
						"http://www.khan.co.kr/rss/rssdata/total_news.xml");
				nm2 = new NewsMainFragmentFix(mContext,
						"http://www.khan.co.kr/rss/rssdata/politic_news.xml");
				nm3 = new NewsMainFragmentFix(mContext,
						"http://www.khan.co.kr/rss/rssdata/economy_news.xml");
				nm4 = new NewsMainFragmentFix(mContext,
						"http://www.khan.co.kr/rss/rssdata/society_news.xml");
				nm5 = new NewsMainFragmentFix(mContext,
						"http://www.khan.co.kr/rss/rssdata/kh_world.xml");
				nm6 = new NewsMainFragmentFix(mContext,
						"http://www.khan.co.kr/rss/rssdata/kh_sports.xml");
				nm7 = new NewsMainFragmentFix(mContext,
						"http://www.khan.co.kr/rss/rssdata/culture_news.xml");
				nm8 = new NewsMainFragmentFix(mContext,
						"http://www.khan.co.kr/rss/rssdata/kh_entertainment.xml");
				nm9 = new NewsMainFragmentFix(mContext,
						"http://www.khan.co.kr/rss/rssdata/it_news.xml");
				nm10 = new NewsMainFragmentFix(mContext,
						"http://www.khan.co.kr/rss/rssdata/local_news.xml");
				nm11 = new NewsMainFragmentFix(mContext,
						"http://www.khan.co.kr/rss/rssdata/kh_special.xml");
				nm12 = new NewsMainFragmentFix(mContext,
						"http://www.khan.co.kr/rss/rssdata/people_news.xml");
				nm13 = new NewsMainFragmentFix(mContext,
						"http://www.khan.co.kr/rss/rssdata/opinion_news.xml");
			}
		}).start();
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(Context context, FragmentManager fm) {
			super(fm);
			mContext = context;
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			// Fragment fragment = new DummySectionFragment();
			// Bundle args = new Bundle();
			// args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position +
			// 1);
			// fragment.setArguments(args);
			// return fragment;
			switch (position) {
			case 0:
				return nm1;
			case 1:
				return nm2;
			case 2:
				return nm3;
			case 3:
				return nm4;
			case 4:
				return nm5;
			case 5:
				return nm6;
			case 6:
				return nm7;
			case 7:
				return nm8;
			case 8:
				return nm9;
			case 9:
				return nm10;
			case 10:
				return nm11;
			case 11:
				return nm12;
			case 12:
				return nm13;
			}
			return null;
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 13;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			// Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_total); // 전체
			case 1:
				return getString(R.string.title_politics); // 정치
			case 2:
				return getString(R.string.title_economy); // 경제
			case 3:
				return getString(R.string.title_national); // 사회
			case 4:
				return getString(R.string.title_international); // 국제
			case 5:
				return getString(R.string.title_sports); // 스포츠
			case 6:
				return getString(R.string.title_culture2); // 문화
			case 7:
				return getString(R.string.title_entertainment); // 연예
			case 8:
				return getString(R.string.title_it); // IT
			case 9:
				return getString(R.string.title_local); // 전국
			case 10:
				return getString(R.string.title_special); // 기획
			case 11:
				return getString(R.string.title_people); // 인물
			case 12:
				return getString(R.string.title_opinion); // 오피니언
			}
			return null;
		}
	}

}