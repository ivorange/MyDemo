package co.example.ivorange.studyproject;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class CanvesDemo extends AppCompatActivity {

//	private ImageView mImgCanves;
	private ImageView mImgCanvasLayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_canves_demo);
//		mImgCanves=(ImageView)findViewById(R.id.img_canves);
//		mImgCanves.setImageBitmap(init());
		mImgCanvasLayer=(ImageView)findViewById(R.id.canvas_layer);
		mImgCanvasLayer.setImageBitmap(init());
	}

//	public Bitmap init(){
//		Bitmap bitmap=Bitmap.createBitmap(200,200, Bitmap.Config.RGB_565);
//		Canvas canvas=new Canvas(bitmap);
//		canvas.drawColor(Color.RED);
//		canvas.drawText("Demo Canvas", 0, 100, new Paint(Color.WHITE));
//		return bitmap;
//	}
	public Bitmap init(){

		Bitmap bitmap=Bitmap.createBitmap(300,300, Bitmap.Config.RGB_565);
		Canvas canvas=new Canvas(bitmap);
		Paint circlePaint=new Paint();
		int original=canvas.save();
		canvas.translate(50, 100);
		circlePaint.setColor(Color.RED);
		canvas.drawCircle(75, 75, 75, circlePaint);
		canvas.restore();
		canvas.saveLayerAlpha(0, 0, 50, 50, 0x88, Canvas.ALL_SAVE_FLAG);
		circlePaint.setColor(Color.BLUE);
		canvas.drawCircle(25, 25, 30, circlePaint);
		canvas.restore();
		int saveFlag=canvas.save();
		canvas.saveLayer(0,0,300,300,new Paint(),Canvas.ALL_SAVE_FLAG);
		circlePaint.setColor(Color.YELLOW);
		canvas.drawCircle(200, 200, 75, circlePaint);
		canvas.restoreToCount(original);
		return bitmap;
	}

}
