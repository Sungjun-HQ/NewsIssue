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
import com.pangpang.newsissue.news.NewsMainFragment;

public class FNNewsMainActivity extends FragmentActivity implements
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

	NewsMainFragment nm1;
	NewsMainFragment nm2;
	NewsMainFragment nm3;
	NewsMainFragment nm4;
	NewsMainFragment nm5;
	NewsMainFragment nm6;
	NewsMainFragment nm7;
	NewsMainFragment nm8;
	NewsMainFragment nm9;
	NewsMainFragment nm10;
	NewsMainFragment nm11;
	NewsMainFragment nm12;
	NewsMainFragment nm13;
	NewsMainFragment nm14;
	NewsMainFragment nm15;

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
				nm1 = new NewsMainFragment(mContext,
						"http://www.fnnews.com/rss/fn_realnews_all.xml");
				nm2 = new NewsMainFragment(mContext,
						"http://www.fnnews.com/rss/fn_realnews_stock.xml");
				nm3 = new NewsMainFragment(mContext,
						"http://www.fnnews.com/rss/fn_realnews_finance.xml");
				nm4 = new NewsMainFragment(mContext,
						"http://www.fnnews.com/rss/fn_realnews_realestate.xml");
				nm5 = new NewsMainFragment(mContext,
						"http://www.fnnews.com/rss/fn_realnews_industry.xml");
				nm6 = new NewsMainFragment(mContext,
						"http://www.fnnews.com/rss/fn_realnews_economy.xml");
				nm7 = new NewsMainFragment(mContext,
						"http://www.fnnews.com/rss/fn_realnews_it.xml");
				nm8 = new NewsMainFragment(mContext,
						"http://www.fnnews.com/rss/fn_realnews_circulation.xml");
				nm9 = new NewsMainFragment(mContext,
						"http://www.fnnews.com/rss/fn_realnews_international.xml");
				nm10 = new NewsMainFragment(mContext,
						"http://www.fnnews.com/rss/fn_realnews_politics.xml");
				nm11 = new NewsMainFragment(mContext,
						"http://www.fnnews.com/rss/fn_realnews_society.xml");
				nm12 = new NewsMainFragment(mContext,
						"http://www.fnnews.com/rss/fn_realnews_culture.xml");
				nm13 = new NewsMainFragment(mContext,
						"http://www.fnnews.com/rss/fn_realnews_sports.xml");
				nm14 = new NewsMainFragment(mContext,
						"http://www.fnnews.com/rss/fn_realnews_edu.xml");
				nm15 = new NewsMainFragment(mContext,
						"http://www.fnnews.com/rss/fn_realnews_people.xml");
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
			case 13:
				return nm14;
			case 14:
				return nm15;
			}
			return null;
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 15;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			// Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_total);
			case 1:
				return getString(R.string.title_stock);
			case 2:
				return getString(R.string.title_finances);
			case 3:
				return getString(R.string.title_property);
			case 4:
				return getString(R.string.title_industry);
			case 5:
				return getString(R.string.title_economy);
			case 6:
				return getString(R.string.title_science2);
			case 7:
				return getString(R.string.title_economyss);
			case 8:
				return getString(R.string.title_international);
			case 9:
				return getString(R.string.title_politics);
			case 10:
				return getString(R.string.title_national);
			case 11:
				return getString(R.string.title_culture2);
			case 12:
				return getString(R.string.title_sports);
			case 13:
				return getString(R.string.title_education);
			case 14:
				return getString(R.string.title_peoples);

			}
			return null;
		}
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	// public static class DummySectionFragment extends Fragment {
	// /**
	// * The fragment argument representing the section number for this
	// * fragment.
	// */
	// public static final String ARG_SECTION_NUMBER = "section_number";
	//
	// public DummySectionFragment() {
	// }
	//
	// @Override
	// public View onCreateView(LayoutInflater inflater, ViewGroup container,
	// Bundle savedInstanceState) {
	// View rootView = inflater.inflate(R.layout.fragment_main_dummy,
	// container, false);
	// TextView dummyTextView = (TextView) rootView
	// .findViewById(R.id.section_label);
	// dummyTextView.setText(Integer.toString(getArguments().getInt(
	// ARG_SECTION_NUMBER)));
	// return rootView;
	// }
	// }

}
