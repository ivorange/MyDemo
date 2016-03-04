package co.example.ivorange.singletaskdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SingleInstance extends AppCompatActivity {

	private Button mBtnStart;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_single_instance);
		mBtnStart=(Button)findViewById(R.id.btn_startStande);
		mBtnStart.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(SingleInstance.this,StandActive.class);
				startActivity(intent);
			}
		});
	}
}
