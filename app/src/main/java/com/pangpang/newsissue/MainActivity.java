package com.pangpang.newsissue;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.pangpang.newsissue.paper.ChosunMainActivity;
import com.pangpang.newsissue.paper.ChungangMainActivity;
import com.pangpang.newsissue.paper.DongAMainActivity;
import com.pangpang.newsissue.paper.ETNewsMainActivity;
import com.pangpang.newsissue.paper.EdailyMainActivity;
import com.pangpang.newsissue.paper.FNNewsMainActivity;
import com.pangpang.newsissue.paper.HankookMainActivity;
import com.pangpang.newsissue.paper.HankyorehMainActivity;
import com.pangpang.newsissue.paper.HeraldMainActivity;
import com.pangpang.newsissue.paper.INewsMainActivity;
import com.pangpang.newsissue.paper.KukinewsMainActivity;
import com.pangpang.newsissue.paper.KyunghyangMainActivity;
import com.pangpang.newsissue.paper.MBCMainActivity;
import com.pangpang.newsissue.paper.MBNMainActivity;
import com.pangpang.newsissue.paper.MKMainActivity;
import com.pangpang.newsissue.paper.NocutMainActivity;
import com.pangpang.newsissue.paper.OhMyNewsMainActivity;
import com.pangpang.newsissue.paper.SBSMainActivity;
import com.pangpang.newsissue.paper.SegyeMainActivity;

public class MainActivity extends Activity {

	GridView mGridView;
	int flags = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_main);
		
		ActionBar bar = getActionBar();
		flags = ActionBar.DISPLAY_SHOW_TITLE;
		int change = bar.getDisplayOptions() ^ flags;
		bar.setDisplayOptions(change, flags);

		DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		int deviceWidth = displayMetrics.widthPixels;
		int deviceHeight = displayMetrics.heightPixels;

		Log.i("Size", "deviceWidth: " + deviceWidth);
		Log.i("Size", "deviceHeight: " + deviceHeight);

		if (deviceWidth < 600) {
			setContentView(R.layout.activity_main_small);
			mGridView = (GridView) findViewById(R.id.mainGridViewSmall);
		} else {
			setContentView(R.layout.activity_main);
			mGridView = (GridView) findViewById(R.id.mainGridView);
		}

		// mGridView = (GridView) findViewById(R.id.mainGridView);
		mGridView.setAdapter(new MainGridAdapter(this, deviceWidth));

		mGridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> paren, View view,
					int position, long id) {
				switch (position) {
				case 0:
					Intent intent0 = new Intent(getApplicationContext(),
							KyunghyangMainActivity.class);
					startActivity(intent0);
					break;
				case 1:
					Intent intent1 = new Intent(getApplicationContext(),
							KukinewsMainActivity.class);
					startActivity(intent1);
					break;
				case 2:
					Intent intent2 = new Intent(getApplicationContext(),
							NocutMainActivity.class);
					startActivity(intent2);
					break;
				case 3:
					Intent intent3 = new Intent(getApplicationContext(),
							DongAMainActivity.class);
					startActivity(intent3);
					break;
				case 4:
					Intent intent4 = new Intent(getApplicationContext(),
							MKMainActivity.class);
					startActivity(intent4);
					break;
				case 5:
					Intent intent5 = new Intent(getApplicationContext(),
							SegyeMainActivity.class);
					startActivity(intent5);
					break;
				case 6:
					Intent intent6 = new Intent(getApplicationContext(),
							INewsMainActivity.class);
					startActivity(intent6);
					break;
				case 7:
					Intent intent7 = new Intent(getApplicationContext(),
							OhMyNewsMainActivity.class);
					startActivity(intent7);
					break;
				case 8:
					Intent intent8 = new Intent(getApplicationContext(),
							EdailyMainActivity.class);
					startActivity(intent8);
					break;
				case 9:
					Intent intent9 = new Intent(getApplicationContext(),
							ETNewsMainActivity.class);
					startActivity(intent9);
					break;
				case 10:
					Intent intent10 = new Intent(getApplicationContext(),
							ChosunMainActivity.class);
					startActivity(intent10);
					break;
				case 11:
					Intent intent11 = new Intent(getApplicationContext(),
							ChungangMainActivity.class);
					startActivity(intent11);
					break;
				case 12:
					Intent intent12 = new Intent(getApplicationContext(),
							FNNewsMainActivity.class);
					startActivity(intent12);
					break;
				case 13:
					Intent intent13 = new Intent(getApplicationContext(),
							HankyorehMainActivity.class);
					startActivity(intent13);
					break;
				case 14:
					Intent intent14 = new Intent(getApplicationContext(),
							HankookMainActivity.class);
					startActivity(intent14);
					break;
				case 15:
					Intent intent15 = new Intent(getApplicationContext(),
							HeraldMainActivity.class);
					startActivity(intent15);
					break;
				case 16:
					Intent intent16 = new Intent(getApplicationContext(),
							MBCMainActivity.class);
					startActivity(intent16);
					break;
				case 17:
					Intent intent17 = new Intent(getApplicationContext(),
							MBNMainActivity.class);
					startActivity(intent17);
					break;
				case 18:
					Intent intent18 = new Intent(getApplicationContext(),
							SBSMainActivity.class);
					startActivity(intent18);
					break;
				default:
					break;
				}
			}
		});
	}
}
