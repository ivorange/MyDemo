package co.example.ivorange.clientremote;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.weather.demo.weather;


public class MainActivity extends AppCompatActivity {

	private TextView mTextShow;
	private weather mBean;
	private ServiceConnection serviceConnection;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mTextShow=(TextView)findViewById(R.id.text_show);
		init();
	}


	public void init() {
		serviceConnection = new ServiceConnection() {
			@Override
			public void onServiceConnected(ComponentName name, IBinder service) {
				mBean= weather.Stub.asInterface(service);
				Log.d("onServiceConnected","..."+mBean);
				try
				{
					mTextShow.setText(mBean.displayWeather());

				}catch (Exception ex){
					throw new RuntimeException("the Exception is "+ex);
				}
			}

			@Override
			public void onServiceDisconnected(ComponentName name) {
				Log.d("onServiceConnected","...onServiceDisconnected");
			}
		};
		Intent intent = new Intent();
		intent.setPackage("co.example.ivorange.serviceremote");
		// 设置Intent Action 属性
		intent.setAction("Myservice");
		// 绑定服务
		bindService(intent, serviceConnection, Service.BIND_AUTO_CREATE);

	}
}
