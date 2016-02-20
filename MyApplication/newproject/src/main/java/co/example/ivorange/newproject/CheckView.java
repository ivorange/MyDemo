package co.example.ivorange.newproject;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ivorange on 16/2/20.
 */
public class CheckView extends TextView {

	private View.OnClickListener mOnclickListener;
	private Context mCtx;
	private Drawable mBgDrawable;
	private int mTextWidth;
	private int mTextHeight;
	private boolean mIsShowRemoveIcon;

	public CheckView(Context context) {
		super(context);
	}

	public CheckView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(attrs);

	}

	public CheckView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(attrs);
	}



	public void init(AttributeSet attributeSet){
		TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet,
				R.styleable.demoView);
		mIsShowRemoveIcon=typedArray.getBoolean(R.styleable
				.demoView_isshowicon, false);
		typedArray.recycle();

	}

	public void setmIsShowRemoveIcon(boolean isShowRemoveIcon){
		FastBitmapDrawable fastBitmapDrawable=(FastBitmapDrawable)getCompoundDrawables()[1];
		fastBitmapDrawable.setmIsShowRemoveIcon(isShowRemoveIcon);
		fastBitmapDrawable.invalidateSelf();
	}


	public void setuoDrawable(){

		Bitmap bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.chun1);
		FastBitmapDrawable drawable=new FastBitmapDrawable(bitmap,getContext());
		drawable.setBounds(0, 0, 300,200);
		setCompoundDrawables(null, drawable, null, null);

	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		setuoDrawable();
		setmIsShowRemoveIcon(mIsShowRemoveIcon);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		mTextWidth=w;
		mTextHeight=h;

	}
}
