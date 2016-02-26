package co.example.ivorange.studyproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;


public class FaceDemo extends AppCompatActivity {

	private String mHttpGet = "http://apicn.faceplusplus" +
			".com/v2/detection/detect?api_key=77e5a356e08bc1544399178034893c00&api_secret" +
			"=Z8IT2r4Ht1Lz7K6QRHTmDaiZTfDD5iHb&url=http://pic.ffpic" +
			".com/files/2014/1028/0928ffpicxdytdde07154.jpg&attribute=glass,pose,gender," +
			"age," +
			"race,smiling";
	private AsyncHttpClient httpClient;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_face_demo);
		httpClient = new AsyncHttpClient();
		httpClient.post(getURL(), new AsyncHttpResponseHandler() {
			@Override
			public void onStart() {
				super.onStart();
			}

			@Override
			public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
				if (statusCode == 200) {
					String string = new String(responseBody);
					Log.d("json", "..." + string);
				}
			}

			@Override
			public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable
					error) {
				super.onFailure(statusCode, headers, responseBody, error);
				Log.e("debug", "failure...." + error);
			}
		});
	}

	public String getURL() {
		String str = "";
		String content="";
		try {
			InputStreamReader reader = new InputStreamReader(getResources().getAssets().open
					("renlian.jpg"));
			BufferedReader bufferedReader=new BufferedReader(reader);
			while ((str=bufferedReader.readLine())!=null){
				content+=str;
			}
		} catch (Exception ex) {

		}
		str = "http://apicn.faceplusplus" +
				".com/v2/detection/detect?api_key=77e5a356e08bc1544399178034893c00&api_secret" +
				"=Z8IT2r4Ht1Lz7K6QRHTmDaiZTfDD5iHb&img="+content+"&attribute=glass,pose,gender," +
				"age," +
				"race,smiling";
		return str;
	}
}
