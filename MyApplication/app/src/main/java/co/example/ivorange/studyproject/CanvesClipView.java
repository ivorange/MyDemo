package co.example.ivorange.studyproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ivorange on 16/2/16.
 */
public class CanvesClipView extends View {

	private Paint mBgPaint;
	private Path mPath;

	public CanvesClipView(Context context) {
		super(context);
		init();
	}

	public CanvesClipView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public CanvesClipView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	public void init(){
		mBgPaint=new Paint();
		mBgPaint.setStrokeWidth(10);
		mPath=new Path();
	}

	public void drawSceen(Canvas canvas){

		canvas.clipRect(0, 0, 200, 200);
		canvas.drawColor(Color.WHITE);
		mBgPaint.setColor(Color.RED);
		canvas.drawLine(0, 0, 200, 200, mBgPaint);
		mBgPaint.setColor(Color.GREEN);
		canvas.drawCircle(50, 150, 50, mBgPaint);
		mBgPaint.setColor(Color.BLACK);
		mBgPaint.setTextSize(30);
		canvas.drawText("Clip Canves",40,30,mBgPaint);

	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.GRAY);
		canvas.save();
		canvas.translate(10, 10);
		drawSceen(canvas);
		canvas.restore();

		canvas.save();
		canvas.translate(300, 10);
		canvas.clipRect(10, 10, 210, 210);
		canvas.clipRect(80, 80, 160, 160, Region.Op.DIFFERENCE);
		drawSceen(canvas);
		canvas.restore();

		canvas.save();
		canvas.translate(10, 310);
		mPath.reset();
		canvas.clipPath(mPath);
		mPath.addCircle(80, 80, 80, Path.Direction.CCW);
		canvas.clipPath(mPath, Region.Op.REPLACE);
		drawSceen(canvas);
		canvas.restore();

		canvas.save();
		canvas.translate(310, 310);
		canvas.clipRect(10, 10, 80, 80);
		canvas.clipRect(60, 60, 210, 210, Region.Op.UNION);
		drawSceen(canvas);
		canvas.restore();

		canvas.save();
		canvas.translate(10, 610);
		canvas.clipRect(10, 10, 120, 120);
		canvas.clipRect(80, 80, 210, 210, Region.Op.XOR);
		drawSceen(canvas);
		canvas.restore();

		canvas.save();
		canvas.translate(310,610);
		canvas.clipRect(10, 10, 120, 120);
		canvas.clipRect(80, 80, 210, 210, Region.Op.REVERSE_DIFFERENCE);
		drawSceen(canvas);
		canvas.restore();
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
	}

}
