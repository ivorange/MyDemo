package co.example.ivorange.newproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class GestureTestDemo extends AppCompatActivity {

	private GestureDetector mGesturer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gesture_test_demo);
		mGesturer=new GestureDetector(this,new GestureDemo());
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return mGesturer.onTouchEvent(event);
	}

	public class GestureDemo extends GestureDetector.SimpleOnGestureListener{

		@Override
		public void onLongPress(MotionEvent e) {
			Toast.makeText(getApplicationContext(),"onLongPress",Toast.LENGTH_LONG).show();
			super.onLongPress(e);
		}

		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
			if (distanceX>0){
				Toast.makeText(getApplicationContext(),"向右",Toast.LENGTH_LONG).show();

			}else {
				Toast.makeText(getApplicationContext(),"向左",Toast.LENGTH_LONG).show();
			}
			return super.onScroll(e1, e2, distanceX, distanceY);
		}

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
			if (velocityX>0){
				Toast.makeText(getApplicationContext(),"向右抛投",Toast.LENGTH_LONG).show();
			}else
			{
				Toast.makeText(getApplicationContext(),"向左抛投",Toast.LENGTH_LONG).show();
			}
			return super.onFling(e1, e2, velocityX, velocityY);
		}

		@Override
		public void onShowPress(MotionEvent e) {
			super.onShowPress(e);
		}

		@Override
		public boolean onDown(MotionEvent e) {
			return super.onDown(e);
		}

		@Override
		public boolean onDoubleTap(MotionEvent e) {
			return super.onDoubleTap(e);
		}

		@Override
		public boolean onDoubleTapEvent(MotionEvent e) {
			return super.onDoubleTapEvent(e);
		}
	}


}
