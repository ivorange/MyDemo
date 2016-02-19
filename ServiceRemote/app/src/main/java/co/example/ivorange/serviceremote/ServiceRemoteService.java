package co.example.ivorange.serviceremote;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by ivorange on 16/2/19.
 */
public class ServiceRemoteService extends Service {

	private Timer mTimer;
	private WeatherBean weatherBean=new WeatherBean();
	private int index=0;
	@Nullable
	@Override
	public IBinder onBind(final Intent intent) {
		TimerTask timerTask=new TimerTask() {
			@Override
			public void run() {
				index++;
				try {
					weatherBean.setWeather("now is."+index);

				}catch (Exception ex){

				}
			}
		};
		mTimer.schedule(timerTask,0,500);
		return weatherBean;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		try {
			while (true){
				index++;
				try {
					Thread.sleep(1000);

				}catch (Exception ex){

				}
				weatherBean.setWeather("now is "+index);
				Log.d("start", "..."+index);

			}

		}catch (Exception ex){

		}
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onCreate() {
		mTimer=new Timer();
		super.onCreate();
	}

	@Override
	public void onRebind(Intent intent) {

		super.onRebind(intent);

	}
}
