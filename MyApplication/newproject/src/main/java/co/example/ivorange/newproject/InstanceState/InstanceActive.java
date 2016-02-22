package co.example.ivorange.newproject.InstanceState;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import co.example.ivorange.newproject.R;

public class InstanceActive extends AppCompatActivity {

	private static String SAVE_INSTANCE = "state_instance";
	private static String SAVE_TEXT = "state_text";
	private String mString = "";
	private TextView mText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_instance_active);
		mText = (TextView) findViewById(R.id.text_demo);
		mString = "save";
//		if (savedInstanceState != null) {
//			Log.d("instance", "onCreate..." + savedInstanceState.getString(SAVE_TEXT));
//			mString = savedInstanceState.getString(SAVE_TEXT);
//		}
		mText.setText(mString);

	}


	@Override
	protected void onSaveInstanceState(Bundle outState) {
		outState.putString(SAVE_TEXT, "........");
		Log.d("instance", "..onSaveInstanceState");
		super.onSaveInstanceState(outState);

	}


	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		String text=savedInstanceState.getString(SAVE_TEXT);
		mText.setText(text+"onRestoreInstanceState");
		Log.d("instance", "..onRestoreInstanceState");
		super.onRestoreInstanceState(savedInstanceState);
	}
}
