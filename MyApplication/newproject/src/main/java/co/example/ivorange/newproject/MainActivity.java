package co.example.ivorange.newproject;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	private Button mBtnShow;
	private Button mBtnSwitch;
	private Boolean mIsAdd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mIsAdd=true;
		setContentView(R.layout.activity_main);
		mBtnShow=(Button)findViewById(R.id.btn_show);
		mBtnSwitch=(Button)findViewById(R.id.btn_switch);
		mBtnSwitch.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mIsAdd=!mIsAdd;
				if(mIsAdd){
					mBtnSwitch.setText(""+mIsAdd);
				}else{
					mBtnSwitch.setText(""+mIsAdd);
				}
			}
		});
		mBtnShow.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mIsAdd){
				    insertRecord("Tom2222");
					Toast.makeText(getApplicationContext(),"add in sql",Toast.LENGTH_SHORT).show();
				}else{
					displayRecords();

				}
			}
		});
	}

	private void insertRecord(String userName) {
		ContentValues values = new ContentValues();
		values.put(MyUsers.User.USER_NAME, userName);
		getContentResolver().insert(MyUsers.User.CONTENT_URI, values);
	}

	private void displayRecords() {
		String str="";
		String columns[] = new String[] { MyUsers.User._ID, MyUsers.User.USER_NAME };
		Uri myUri = MyUsers.User.CONTENT_URI;
		Cursor cur = managedQuery(myUri, columns,null, null, null );
		if (cur.moveToFirst()) {
			String id = null;
			String userName = null;
			do {
				id = cur.getString(cur.getColumnIndex(MyUsers.User._ID));
				userName = cur.getString(cur.getColumnIndex(MyUsers.User.USER_NAME));
				str+=id+"...."+userName+"..";
			} while (cur.moveToNext());
		}
		Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();
	}
}
