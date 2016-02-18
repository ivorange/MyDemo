package co.example.ivorange.studyproject;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by ivorange on 16/2/18.
 */
public class ServiceDemo extends Service {

	private AsyncHttpClient mAsyncClient;
	private String[] urls;

	public ServiceDemo() {
		super();
		mAsyncClient = new AsyncHttpClient();
		urls = new String[]{"http://img.article.pchome" +
				".net/00/35/35/37/pic_lib/s960x639/Huanxiang05s960x639.jpg", "http://img.article" +
				".pchome.net/00/35/35/37/pic_lib/s960x639/Huanxiang05s960x639.jpg", "" +
				".net/00/35/35/37/pic_lib/s960x639/Huanxiang05s960x639.jpg", "http://img.article" +
				".pchome.net/00/35/35/37/pic_lib/s960x639/Huanxiang05s960x639.jpg", "" +
				".net/00/35/35/37/pic_lib/s960x639/Huanxiang05s960x639.jpg", "http://img.article" +
				".pchome.net/00/35/35/37/pic_lib/s960x639/Huanxiang05s960x639.jpg", "" +
				".net/00/35/35/37/pic_lib/s960x639/Huanxiang05s960x639.jpg", "http://img.article" +
				".pchome.net/00/35/35/37/pic_lib/s960x639/Huanxiang05s960x639.jpg"};
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("service", "onCreate()");
	}

	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		Log.d("service", "onBind()");
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d("service", "onStartCommand()");
		for (int i=0;i<urls.length;i++){
			final int index=i;
			mAsyncClient.get(urls[i], new AsyncHttpResponseHandler() {
				@Override
				public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
					Bitmap bitmap = BitmapFactory.decodeByteArray(responseBody, 0, responseBody
							.length);
					File file = new File(getCacheDir().getPath(), "down" + index + ".jpg");
					try {
						FileOutputStream fileOutputStream = new FileOutputStream(file);
						bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
						fileOutputStream.flush();
						fileOutputStream.close();
						Log.d("service", "...get a jpg " + index);
					} catch (Exception ex) {
						throw new RuntimeException("..." + ex);
					}

					super.onSuccess(statusCode, headers, responseBody);
				}

				@Override
				public void onFailure(int statusCode, Header[] headers, byte[] responseBody,
									  Throwable
						error) {
						if(responseBody!=null){
							Log.e("service","onFailure.."+responseBody.toString());

						}

					super.onFailure(statusCode, headers, responseBody, error);
				}

				@Override
				public void onRetry() {
					super.onRetry();
				}
			});
		}

		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		Log.d("service", "onDestroy()");
		super.onDestroy();
	}
}
