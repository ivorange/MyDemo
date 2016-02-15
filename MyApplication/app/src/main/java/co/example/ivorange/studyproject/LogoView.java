package co.example.ivorange.studyproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by ivorange on 16/2/15.
 */
public class LogoView extends View {

	private LinearGradient mLinearGra;
	private Paint mDrawPaint;
	private int mBgHeight;
	private int mBgwidth;
	private Matrix mBgPaintMatrix;
	private Timer mTimer;
	private TimerTask mTask;
	private int mIndex;
	private int mMaxCount;
	private Point mCenterPoint;

	public LogoView(Context context) {
		super(context);
		init();
	}

	public LogoView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public LogoView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	public void init() {
		mDrawPaint = new Paint();
		mBgPaintMatrix = new Matrix();
		mTimer = new Timer();
		mIndex = 0;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		mDrawPaint.setShader(mLinearGra);
		mBgPaintMatrix.setTranslate(mIndex, 0);
		mLinearGra.setLocalMatrix(mBgPaintMatrix);
		mDrawPaint.setTextSize(200);
		canvas.drawText("Logo.........", mCenterPoint.x, mCenterPoint.y, mDrawPaint);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		mBgHeight = h;
		mBgwidth = w;
		mLinearGra = new LinearGradient(-w, 0, w, 0, new int[]{getResources().getColor(R.color
				.white), getResources().getColor(R.color.white), getResources().getColor(R.color
				.two_green),getResources().getColor(R.color
				.white),getResources().getColor(R.color
				.white)}, new float[]{0, 0.4f,0.5f,0.6f,1f}, Shader.TileMode.CLAMP);
		mMaxCount = w;
		mCenterPoint = new Point(0, h / 2);
	}


	@Override
	public boolean onTouchEvent(MotionEvent event) {

		switch (event.getAction()) {
			case MotionEvent.ACTION_UP:
				mTask = new TimerTask() {
					@Override
					public void run() {
						if (mIndex < mMaxCount) {
							mIndex+=10;
							postInvalidate();

						} else {
							mIndex = 0;
							this.cancel();
						}
						Log.d("debug", "....debug");
					}
				};
				mTimer.schedule(mTask, 0, 10);
				break;
		}
		return true;
	}
}
