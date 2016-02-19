package co.example.ivorange.studyproject.remoteservice;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import co.example.ivorange.studyproject.BookInfo;
import co.example.ivorange.studyproject.R;

public class RemoteServiceActive extends AppCompatActivity {

	private BookInfo bookInfo;
	// 声明 Button
	private Button btn;
	// 实例化ServiceConnection
	private ServiceConnection conn = new ServiceConnection() {
		@Override
		synchronized public void onServiceConnected(ComponentName name, IBinder service) {
			// 获得IPerson接口
			bookInfo = BookInfo.Stub.asInterface(service);
			if (bookInfo != null)
				try {
					// RPC 方法调用
					bookInfo.setName("Google Android SDK开发范例大全");
					bookInfo.setPrice(55);
					bookInfo.ssetPublish("人民邮电出版社");
					String msg = bookInfo.display();
					// 显示方法调用返回值
					Toast.makeText(RemoteServiceActive.this, msg, Toast.LENGTH_LONG)
							.show();
				} catch (RemoteException e) {
					e.printStackTrace();
				}
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.d("onServiceDisconnected","...onServiceDisconnected..."+name);
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 设置当前视图布局
		setContentView(R.layout.activity_remote_service_active);
		// 实例化Button
		btn = (Button) findViewById(R.id.Button1);
		//为Button添加单击事件监听器
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 实例化Intent
				Intent intent = new Intent();
				intent.setPackage(getPackageName());
				// 设置Intent Action 属性
				intent.setAction("com.android.aidl.action.MY_REMOTE_SERVICE");
				// 绑定服务
				bindService(intent, conn, Service.BIND_AUTO_CREATE);
			}
		});
	}
}
