package co.example.ivorange.newprocessdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

	Button mBtnStartNewProcess;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mBtnStartNewProcess=(Button)findViewById(R.id.btn_start_new_process);
		mBtnStartNewProcess.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Main2Activity.class);
				startActivity(intent);
			}
		});
	}
}
