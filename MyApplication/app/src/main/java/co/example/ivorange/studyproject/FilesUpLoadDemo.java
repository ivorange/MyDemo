package co.example.ivorange.studyproject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FilesUpLoadDemo extends AppCompatActivity {


	private Button mBtnUp;
	private AsyncTask mAsync;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_files_up_load_demo);
		mBtnUp=(Button)findViewById(R.id.btn_up);

		mBtnUp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mAsync=new AsyncTask() {
					@Override
					protected Object doInBackground(Object[] params) {
						uploadFile();
						return null;
					}
				}.execute();
			}
		});

	}


	private void uploadFile()
	{
		//上传到服务器的指定位置
		String actionUrl = "http://myweb-10021579.file.myqcloud.com/myweb/android/";
		String end = "/r/n";
		String Hyphens = "--";
		String boundary = "*****";
		try
		{
			URL url = new URL(actionUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
      /* 允许Input、Output，不使用Cache */
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setUseCaches(false);
      /* 设定传送的method=POST */
			con.setRequestMethod("POST");
      /* setRequestProperty */
			con.setRequestProperty("Connection", "Keep-Alive");
			con.setRequestProperty("Charset", "UTF-8");
			con.setRequestProperty("Content-Type",
					"multipart/form-data;boundary=" + boundary);
      /* 设定DataOutputStream */
			DataOutputStream ds = new DataOutputStream(con.getOutputStream());
			ds.writeBytes(Hyphens + boundary + end);
			ds.writeBytes(end);
      /* 取得文件的FileInputStream */
			InputStream fStream = getResources().getAssets().open("renlian.jpg");
      /* 设定每次写入1024bytes */
			int bufferSize = 1024;
			byte[] buffer = new byte[bufferSize];
			int length = -1;
      /* 从文件读取数据到缓冲区 */
			while ((length = fStream.read(buffer)) != -1)
			{
        /* 将数据写入DataOutputStream中 */
				ds.write(buffer, 0, length);
			}
			ds.writeBytes(end);
			ds.writeBytes(Hyphens + boundary + Hyphens + end);
			fStream.close();
			ds.flush();
      /* 取得Response内容 */
			InputStream is = con.getInputStream();
			int ch;
			StringBuffer b = new StringBuffer();
			while ((ch = is.read()) != -1)
			{
				b.append((char) ch);
			}
			System.out.println("上传成功");
			Toast.makeText(getApplicationContext(), "上传成功", Toast.LENGTH_LONG)
					.show();
			ds.close();
		} catch (Exception e)
		{
			Log.d("debug1", "..." + e);

		}
	}


}

