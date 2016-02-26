package co.example.ivorange.newproject.Interfacedemo;

import android.os.AsyncTask;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

/**
 * Created by ivorange on 16/2/23.
 */
public class DemoClass {

	private static AsyncHttpClient asyncHttpClient=new AsyncHttpClient();

	public interface dosomething{
		void success();
		void fail();
	}

}
