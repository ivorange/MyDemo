package co.example.ivorange.studyproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServiceActivityDemo extends AppCompatActivity {

	private ServiceDemo mService;
	private Button mBtnStart;
	private Button mBtnStop;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service_demo);
		init();
		mBtnStart=(Button)findViewById(R.id.btn_start);
		mBtnStart.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//start()
				Intent intent=new Intent(ServiceActivityDemo.this,ServiceDemo.class);
				startService(intent);
			}
		});
		mBtnStop=(Button)findViewById(R.id.btn_stop);
		mBtnStop.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(ServiceActivityDemo.this,ServiceDemo.class);
				stopService(intent);
			}
		});

	}

	public void init(){
		mService=new ServiceDemo();
	}
}
