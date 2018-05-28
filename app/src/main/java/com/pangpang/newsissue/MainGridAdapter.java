package com.pangpang.newsissue;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainGridAdapter extends BaseAdapter {

	// 1.경향신문
	// 2.국민일보
	// 3.노컷뉴스
	// 4.동아일보
	// 5.매일경제
	// 6.세계일보
	// 7.아이뉴스
	// 8.오마이뉴스
	// 9.이데일리
	// 10.이티뉴스
	// 11.조선일보
	// 12.중앙일보
	// 13.파이낸셜뉴스
	// 14.한겨레
	// 15.한국일보
	// 16.헤럴드
	// 17.MBC
	// 18.MBN
	// 19.SBS

	private Integer[] imgs = new Integer[] { R.drawable.icon_kyunghyang,
			R.drawable.icon_kookmin, R.drawable.icon_nocut,
			R.drawable.icon_donga, R.drawable.icon_maeil,
			R.drawable.icon_segye, R.drawable.icon_inews24,
			R.drawable.icon_ohmynews, R.drawable.icon_edaily,
			R.drawable.icon_etnews, R.drawable.icon_chosun,
			R.drawable.icon_chungang, R.drawable.icon_financial,
			R.drawable.icon_hankyoreh, R.drawable.icon_hankook,
			R.drawable.icon_herald, R.drawable.icon_mbc, R.drawable.icon_mbn,
			R.drawable.icon_sbs };

	private Context mContext;
	private int deviceWidth;

	public MainGridAdapter(Context mContext, int deviceWidth) {
		this.mContext = mContext;
		this.deviceWidth = deviceWidth;
	}

	@Override
	public int getCount() {
		return imgs.length;
	}

	@Override
	public Object getItem(int arg0) {
		return imgs[arg0];
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup paren) {
		ImageView imageView;
		if (convertView == null) {
			imageView = new ImageView(mContext);

			if (deviceWidth < 600) {
				imageView.setLayoutParams(new GridView.LayoutParams(130, 130));
			} else {
				imageView.setLayoutParams(new GridView.LayoutParams(150, 150));
			}

			// imageView.setLayoutParams(new GridView.LayoutParams(150, 150));
			imageView.setAdjustViewBounds(false);
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(8, 8, 8, 8);
		} else {
			imageView = (ImageView) convertView;
		}
		imageView.setImageResource(imgs[position]);
		return imageView;
	}

}
