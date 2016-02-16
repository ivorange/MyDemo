package co.example.ivorange.studyproject;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by ivorange on 16/2/16.
 */
public class DigitalClockWidgetSweet extends LinearLayout {


	private ImageView mImg0;
	private ImageView mimg1;
	private ImageView mimgGril;
	private ImageView mimgWeek;

	public DigitalClockWidgetSweet(Context context) {
		super(context);
		initView();
	}

	public DigitalClockWidgetSweet(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView();
	}

	public DigitalClockWidgetSweet(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initView();
	}

	public void initView(){
		LayoutInflater.from(getContext()).inflate(R.layout.foto_clock_widget_sweet,this,true);
		mImg0=(ImageView)findViewById(R.id.img_time0);
		mimg1=(ImageView)findViewById(R.id.img_time1);
		mimgWeek=(ImageView)findViewById(R.id.img_time_week);
		mimgGril=(ImageView)findViewById(R.id.img_gril);
		mImg0.setImageResource(R.drawable.time_0);
		mimg1.setImageResource(R.drawable.time_5);
		mimgWeek.setImageResource(R.drawable.monday);
		mimgGril.setImageResource(R.drawable.girl01);

	}

}
