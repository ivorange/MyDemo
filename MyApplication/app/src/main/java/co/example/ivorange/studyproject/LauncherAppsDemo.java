package co.example.ivorange.studyproject;

import android.content.Context;
import android.content.pm.LauncherActivityInfo;
import android.content.pm.LauncherApps;
import android.os.UserHandle;
import android.os.UserManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class LauncherAppsDemo extends AppCompatActivity {

	private LauncherApps mLauncherApps;
	private UserManager mUserManager;
	private List<LauncherActivityInfo> mAllApps;
	private Button mBtnShow;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launcher_apps_demo);
		mBtnShow=(Button)findViewById(R.id.mBtnShow);
		mBtnShow.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				init();
			}
		});
	}
	public void init(){

		mAllApps=new ArrayList<>();
		mLauncherApps=(LauncherApps)getApplicationContext().getSystemService("launcherapps");
		mUserManager=(UserManager)getApplicationContext().getSystemService(Context.USER_SERVICE);
		for (UserHandle user:mUserManager.getUserProfiles()){
			mAllApps=mLauncherApps.getActivityList(null,user);
			for (int i=0;i<mAllApps.size();i++){
				Log.d("app_name","...."+mAllApps.get(i).getComponentName());
			}
		}
	}

}
