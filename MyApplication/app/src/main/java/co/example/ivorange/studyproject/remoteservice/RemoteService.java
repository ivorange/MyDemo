package co.example.ivorange.studyproject.remoteservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by ivorange on 16/2/19.
 */
public class RemoteService  extends Service{

	private BookImpl book=new BookImpl();
	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		try {
			Thread.sleep(60000);
		}catch (Exception ex){

		}
		return book;
	}


	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {

		return super.onStartCommand(intent, flags, startId);
	}


	@Override
	public void onTaskRemoved(Intent rootIntent) {
		super.onTaskRemoved(rootIntent);
	}
}
