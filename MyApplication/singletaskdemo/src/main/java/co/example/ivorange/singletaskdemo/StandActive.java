package co.example.ivorange.singletaskdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StandActive extends AppCompatActivity {

	private Button mBtnStartInstance;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stand_active);
		mBtnStartInstance=(Button)findViewById(R.id.btn_startInstance);
		mBtnStartInstance.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(StandActive.this, SingleInstance.class);
				startActivity(intent);
			}
		});

	}
}
