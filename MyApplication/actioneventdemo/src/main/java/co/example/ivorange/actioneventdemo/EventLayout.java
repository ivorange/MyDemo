package co.example.ivorange.actioneventdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by ivorange on 16/2/25.
 */
public class EventLayout extends LinearLayout {

	public EventLayout(Context context) {
		super(context);
		init();
	}

	public EventLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public EventLayout(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	public void init(){
		LayoutInflater.from(getContext()).inflate(R.layout.event_layout,this,true);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		Log.d("touche_event","....onInterceptTouchEvent");
		return super.onInterceptTouchEvent(ev);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.d("touche_event","....onTouchEvent");
		return super.onTouchEvent(event);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		Log.d("touche_event","....dispatchTouchEvent");
		return super.dispatchTouchEvent(ev);
	}
}
