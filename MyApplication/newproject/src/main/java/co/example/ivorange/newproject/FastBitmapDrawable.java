package co.example.ivorange.newproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by ivorange on 16/2/20.
 */
public class FastBitmapDrawable extends Drawable {

	private int mAlpha;
	private Paint mPaint=new Paint();
	private Bitmap mBitmap;
	private PaintFlagsDrawFilter mFilter;
	private boolean mIsShowRemoveIcon;
	private Rect mSourceBound;
	private Context mCtx;

	@Override
	public void draw(Canvas canvas) {
		Bitmap bitmap= BitmapFactory.decodeResource(mCtx.getResources(),R.drawable.icon_privateapp_select);
		if(mIsShowRemoveIcon){
			Rect removeRect=new Rect(mSourceBound.right*3/4,0,mSourceBound.right,mSourceBound.bottom*1/4);
//			WeakReference<Bitmap> bitmapWeakReference=new WeakReference<Bitmap>(bitmap);
			Rect appRect=new Rect(0,0,mSourceBound.right,mSourceBound.bottom);
			canvas.drawBitmap(mBitmap,null,appRect,mPaint);
			canvas.drawBitmap(bitmap, null, removeRect, mPaint);
			bitmap.recycle();
		} else {
			Rect appRect=new Rect(0,0,mSourceBound.right,mSourceBound.bottom);
			canvas.drawBitmap(mBitmap,null,appRect,mPaint);
		}
	}

	public FastBitmapDrawable(Bitmap bitmap,Context context) {
		mAlpha=255;
		mBitmap=bitmap;
		mPaint.setDither(true);
		mPaint.setAntiAlias(true);
		setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
		mSourceBound=getBounds();
		mPaint.setFilterBitmap(true);
		mFilter=new PaintFlagsDrawFilter(0,Paint.FILTER_BITMAP_FLAG);
		mIsShowRemoveIcon=false;
		mCtx=context;
	}

	public void setmIsShowRemoveIcon(boolean isShow){
		mIsShowRemoveIcon=isShow;
	}


	@Override
	public void setColorFilter(ColorFilter cf) {
		// No op
	}

	@Override
	public int getOpacity() {
		return PixelFormat.TRANSLUCENT;
	}

	@Override
	public void setAlpha(int alpha) {
		mAlpha = alpha;
		mPaint.setAlpha(alpha);
	}

	@Override
	public void setFilterBitmap(boolean filterBitmap) {
		mPaint.setFilterBitmap(filterBitmap);
		mPaint.setAntiAlias(filterBitmap);
	}

	public int getAlpha() {
		return mAlpha;
	}

	@Override
	public int getIntrinsicWidth() {
		return mBitmap.getWidth();
	}

	@Override
	public int getIntrinsicHeight() {
		return mBitmap.getHeight();
	}

	@Override
	public int getMinimumWidth() {
		return getBounds().width();
	}

	@Override
	public int getMinimumHeight() {
		return getBounds().height();
	}
}
