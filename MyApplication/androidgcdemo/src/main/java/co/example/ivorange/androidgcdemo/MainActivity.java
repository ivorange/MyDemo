package co.example.ivorange.androidgcdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		testGc();
	}

	public void testGc(){
		GcBean gcBean=new GcBean();
		WeakReference<GcBean> weakReference=new WeakReference<GcBean>(gcBean);
		gcBean.setName("name");
		while (true){
			try{
				Thread.sleep(100);

			}catch (Exception ex){

			}
			if(weakReference.get()!=null){
				Log.d("weakReference","..."+weakReference);
			}else {
				Log.d("weakReference","...Null");
			}
		}
	}
}
