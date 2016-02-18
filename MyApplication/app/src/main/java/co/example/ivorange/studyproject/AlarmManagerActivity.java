package co.example.ivorange.studyproject;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlarmManagerActivity extends Activity {
	private Button setBtn, cancelBtn;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarm_manager);

		setBtn = (Button)findViewById(R.id.set);
		cancelBtn = (Button)findViewById(R.id.cancel);

		final AlarmManager am = (AlarmManager)this.getSystemService(ALARM_SERVICE);

		Intent intent = new Intent(AlarmManagerActivity.this,MyReceiver.class);
		intent.setAction("com.maker.alarmManager.app.MY_ACTION");
		intent.putExtra("msg", "闹钟事件发生了");
		final PendingIntent pi = PendingIntent.getBroadcast(this, 0, intent, 0);
		final long time = System.currentTimeMillis();

		setBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				am.setRepeating(AlarmManager.RTC_WAKEUP, time, 3000, pi);
			}
		});

		cancelBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				am.cancel(pi);
			}
		});

		IntentFilter intentFilter=new IntentFilter();
		intentFilter.addAction("com.maker.alarmManager.app.MY_ACTION");
		MyReceiver myReceiver=new MyReceiver();
		this.registerReceiver(myReceiver,intentFilter);
	}

	public class MyReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			String  msg = intent.getStringExtra("msg");
			Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
		}
	}
}
