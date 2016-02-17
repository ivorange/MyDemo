package co.example.ivorange.studyproject;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ToastDemo extends AppCompatActivity {


	private Button mBtnToast;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_toast_demo);
		mBtnToast=(Button)findViewById(R.id.btn_show_toast);
		mBtnToast.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showToast(getApplication());
			}
		});
	}

	public void showToast(Context ctx){
		Toast toast=new Toast(ctx);
		FrameLayout frameLayout=new FrameLayout(ctx);
		frameLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams
				.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
		ImageView imageView=new ImageView(ctx);
		imageView.setImageResource(R.drawable.girl01);
		frameLayout.addView(imageView, 300, 300);
		toast.setView(frameLayout);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}

}
