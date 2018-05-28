package com.pangpang.newsissue.news;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.pangpang.newsissue.R;

@SuppressLint("CutPasteId")
public class NewsIn extends Activity {

	int flags = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newsdetail);

		ActionBar bar = getActionBar();
		flags = ActionBar.DISPLAY_SHOW_TITLE;
		int change = bar.getDisplayOptions() ^ flags;
		bar.setDisplayOptions(change, flags);

		TextView tv_title = (TextView) findViewById(R.id.newsTitle);
		// TextView tv_description = (TextView)
		// findViewById(R.id.newsDescription);
		TextView tv_link = (TextView) findViewById(R.id.newsLink);

		// ImageView newImg = (ImageView) findViewById(R.id.newsImg);
		// LinearLayout imglayout = (LinearLayout)
		// findViewById(R.id.news_detail_imglayout);
		// LinearLayout deslayout = (LinearLayout)
		// findViewById(R.id.news_detail_des);

		WebView web = (WebView) findViewById(R.id.webView1);
		WebSettings settings = web.getSettings();
		settings.setDefaultFontSize(18);

		// int index = getIntent().getExtras().getInt("index");
		String title = getIntent().getExtras().getString("title");
		String description = getIntent().getExtras().getString("description");
		String link = getIntent().getExtras().getString("link");

		// Log.i("link", link);

		tv_title.setText(title);

		// if (getIntent().getExtras().getParcelable("image") != null) {
		// Bitmap image = getIntent().getExtras().getParcelable("image");
		// image = Bitmap.createScaledBitmap(image, image.getWidth() * 3,
		// image.getHeight() * 3, true);
		// newImg.setImageBitmap(image);
		// // description = description.split(">")[1];
		// } else {
		// newImg.setVisibility(View.GONE);
		// imglayout.setVisibility(View.GONE);
		// }

		// DisplayMetrics displayMetrics = new DisplayMetrics();
		// getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		// int deviceWidth = displayMetrics.widthPixels;

		// description = breakText(tv_description.getPaint(), description,
		// deviceWidth);
		// CTextView textView = new CTextView(this);
		// textView.setText(description);
		// LinearLayout layout = (LinearLayout)
		// findViewById(R.id.news_detail_des);
		// layout.addView(textView);

		// Log.i("Size", "tv_description: " + tv_description.getWidth());
		// tv_description.setText(description);
		tv_link.setText(Html.fromHtml("<a href=\"" + link + "\">기사 더보기</a>"));
		tv_link.setMovementMethod(LinkMovementMethod.getInstance());

		web.loadData(description, "text/html; charset=UTF-8", null);

		// FragmentManager fm = getSupportFragmentManager();
		// FragmentTransaction tr = fm.beginTransaction();
		// NewsFragment nf = NewsFragment.newInstance(index);
		// tr.add(android.R.id.content, nf);
		// tr.commit();
	}
	/**
	 * 클래스설명 : 텍스트의 줄바꿈을 공백기준이 아닌 한글자 단위로 한다.
	 * 
	 * @version : 2011. 8. 06.
	 * @author : CEnA - mibany
	 * @분류 :
	 */
	// public class CTextView extends TextView {
	// private int mAvailableWidth = 0;
	// private Paint mPaint;
	// private List<String> mCutStr = new ArrayList<String>();
	//
	// public CTextView(Context context) {
	// super(context);
	// }
	//
	// public CTextView(Context context, AttributeSet attrs) {
	// super(context, attrs);
	// }
	//
	// private int setTextInfo(String text, int textWidth, int textHeight) {
	// // 그릴 페인트 세팅
	// mPaint = getPaint();
	// mPaint.setColor(getTextColors().getDefaultColor());
	// mPaint.setTextSize(getTextSize());
	//
	// int mTextHeight = textHeight;
	//
	// if (textWidth > 0) {
	// // 값 세팅
	// mAvailableWidth = textWidth - this.getPaddingLeft()
	// - this.getPaddingRight();
	//
	// mCutStr.clear();
	// int end = 0;
	// do {
	// // 글자가 width 보다 넘어가는지 체크
	// end = mPaint.breakText(text, true, mAvailableWidth, null);
	// if (end > 0) {
	// // 자른 문자열을 문자열 배열에 담아 놓는다.
	// mCutStr.add(text.substring(0, end));
	// // 넘어간 글자 모두 잘라 다음에 사용하도록 세팅
	// text = text.substring(end);
	// // 다음라인 높이 지정
	// if (textHeight == 0)
	// mTextHeight += getLineHeight();
	// }
	// } while (end > 0);
	// }
	// mTextHeight += getPaddingTop() + getPaddingBottom();
	// return mTextHeight;
	// }
	//
	// @Override
	// protected void onDraw(Canvas canvas) {
	// // 글자 높이 지정
	// float height = getPaddingTop() + getLineHeight();
	// for (String text : mCutStr) {
	// // 캔버스에 라인 높이 만큰 글자 그리기
	// canvas.drawText(text, getPaddingLeft(), height, mPaint);
	// height += getLineHeight();
	// }
	// }
	//
	// @Override
	// protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
	// super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	// int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
	// int parentHeight = MeasureSpec.getSize(heightMeasureSpec);
	// int height = setTextInfo(this.getText().toString(), parentWidth,
	// parentHeight);
	// // 부모 높이가 0인경우 실제 그려줄 높이만큼 사이즈를 놀려줌...
	// if (parentHeight == 0)
	// parentHeight = height;
	// this.setMeasuredDimension(parentWidth, parentHeight);
	// }
	//
	// @Override
	// protected void onTextChanged(final CharSequence text, final int start,
	// final int before, final int after) {
	// // 글자가 변경되었을때 다시 세팅
	// setTextInfo(text.toString(), this.getWidth(), this.getHeight());
	// }
	//
	// @Override
	// protected void onSizeChanged(int w, int h, int oldw, int oldh) {
	// // 사이즈가 변경되었을때 다시 세팅(가로 사이즈만...)
	// if (w != oldw) {
	// setTextInfo(this.getText().toString(), w, h);
	// }
	// }
	// }

}
