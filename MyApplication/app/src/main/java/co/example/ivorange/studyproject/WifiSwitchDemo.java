package co.example.ivorange.studyproject;

import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.lang.reflect.Method;

public class WifiSwitchDemo extends AppCompatActivity {

	private Button mBtnWIFI;
	private Button mBntBlueTooth;
	private Button mBtnAirMode;
	private Button mBtnNewtWork;
 	private BluetoothAdapter mBlueToothAdapter;
	private WifiManager mWifiManager;
	private ConnectivityManager mConnectivityManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wifi_switch_demo);
		mBtnWIFI=(Button)findViewById(R.id.btn_wifi);
		mBtnAirMode=(Button)findViewById(R.id.btn_Air);
		mBtnNewtWork=(Button)findViewById(R.id.btn_NetWork);
		mBntBlueTooth=(Button)findViewById(R.id.btn_BlueTooth);
		mWifiManager=(WifiManager)getSystemService(Context.WIFI_SERVICE);
		mBlueToothAdapter=BluetoothAdapter.getDefaultAdapter();
		mConnectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

		mBtnWIFI.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mWifiManager.isWifiEnabled()){
					mWifiManager.setWifiEnabled(false);
				}else
				{
					mWifiManager.setWifiEnabled(true);
				}
			}
		});
//		mBtnAirMode.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				if(getAirplaneModeStatus()){
//					setAirplaneMode(getApplicationContext(),false);
//
//				}else
//				{
//					setAirplaneMode(getApplicationContext(),true);
//				}
//			}
//		});


		mBntBlueTooth.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				switch (mBlueToothAdapter.getState()){
					case BluetoothAdapter.STATE_ON:
						mBlueToothAdapter.disable();
						break;
					case BluetoothAdapter.STATE_TURNING_ON:
						mBlueToothAdapter.disable();
						break;
					case BluetoothAdapter.STATE_OFF:
						mBlueToothAdapter.enable();
						break;
					case BluetoothAdapter.STATE_TURNING_OFF:
						mBlueToothAdapter.enable();
				}
			}
		});
		mBtnNewtWork.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
//				if(getMobileDataState(getApplicationContext())){
//					setMobileData(getApplicationContext(),false);
//				}else{
//					setMobileData(getApplicationContext(),true);
//				}
				if(Build.VERSION.SDK_INT>10){
					Intent intent=new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
					startActivity(intent);
				}else {
					Intent intent=new Intent();
					intent.setComponent(new ComponentName("com.android.settings", "com.android" +
							".settings.WirelessSettings"));
					intent.setAction("android.intent.action.VIEW");
					startActivity(intent);
				}
			}
		});

		if(isConn(getApplicationContext())){
			mBtnNewtWork.setBackgroundColor(Color.WHITE);
		}else {
			mBtnNewtWork.setBackgroundColor(Color.GRAY);
		}


	}

	public static boolean isConn(Context context){
		boolean bisConnFlag=false;
		ConnectivityManager conManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo network = conManager.getActiveNetworkInfo();
		if(network!=null){
			bisConnFlag=conManager.getActiveNetworkInfo().isAvailable();
		}
		return bisConnFlag;
	}

	public static void setMobileData(Context pContext, boolean pBoolean) {

		try {

			ConnectivityManager mConnectivityManager = (ConnectivityManager) pContext.getSystemService(Context.CONNECTIVITY_SERVICE);

			Class ownerClass = mConnectivityManager.getClass();

			Class[] argsClass = new Class[1];
			argsClass[0] = boolean.class;

			Method method = ownerClass.getMethod("setMobileDataEnabled", argsClass);

			method.invoke(mConnectivityManager, pBoolean);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("移动数据设置错误: " + e.toString());
		}
	}

	public static boolean getMobileDataState(Context pContext) {

		try {

			ConnectivityManager mConnectivityManager = (ConnectivityManager) pContext.getSystemService(Context.CONNECTIVITY_SERVICE);

			Class ownerClass = mConnectivityManager.getClass();

			Method method = ownerClass.getMethod("getMobileDataEnabled", null);

			Boolean isOpen = (Boolean) method.invoke(mConnectivityManager, null);

			return isOpen;

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println("得到移动数据状态出错");
			return false;
		}

	}

}
