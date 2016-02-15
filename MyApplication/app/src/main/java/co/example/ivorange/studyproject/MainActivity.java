package co.example.ivorange.studyproject;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView mImageFrame;
	private AnimationDrawable mAnimationDrable;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mImageFrame=(ImageView)findViewById(R.id.img_frame);
		mImageFrame.setImageResource(R.drawable.animation_list);
		mAnimationDrable=(AnimationDrawable)mImageFrame.getDrawable();
		mImageFrame.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mAnimationDrable.start();
			}
		});
	}
}
