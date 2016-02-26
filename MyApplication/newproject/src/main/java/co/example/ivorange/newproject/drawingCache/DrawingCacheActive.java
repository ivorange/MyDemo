package co.example.ivorange.newproject.drawingCache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

import co.example.ivorange.newproject.R;

public class DrawingCacheActive extends AppCompatActivity {

	private ImageView mImgCache;
	private Bitmap mBitmap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drawing_cache_active);
		mImgCache=(ImageView)findViewById(R.id.img_cache);
		init();

	}

	public void init(){
		mImgCache.setDrawingCacheEnabled(true);
		mBitmap= BitmapFactory.decodeResource(getResources(),R.drawable.chun1);
		mImgCache.setImageBitmap(mBitmap);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		Bitmap cache=mImgCache.getDrawingCache();
		if(cache!=null){
			Log.d("cache","....hava cache bitmap");
		}
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
	}
}
