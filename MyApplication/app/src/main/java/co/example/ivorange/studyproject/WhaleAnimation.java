package co.example.ivorange.studyproject;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ClipDrawable;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

public class WhaleAnimation extends AppCompatActivity {

	private ImageView mImgWhale;
	private ImageView mImgClip;
	private AnimationDrawable mAnimationAble;
	private Timer mTimer;
	private android.os.Handler mHandler;
	private int currentLevel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_whale_animation);
		currentLevel=0;
		mImgClip=(ImageView)findViewById(R.id.img_whale_clip);
		final ClipDrawable clipDrawable=(ClipDrawable)mImgClip.getDrawable();
		mTimer=new Timer();
		mImgWhale=(ImageView)findViewById(R.id.img_whale);
		mImgWhale.setImageResource(R.drawable.whale_animation_test);
		mAnimationAble=(AnimationDrawable)mImgWhale.getDrawable();
		mHandler=new android.os.Handler(){
			@Override
			public void handleMessage(Message msg) {
				if(msg.what==1001){
					clipDrawable.setLevel(currentLevel);
				}
			}
		};
		mImgClip.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				TimerTask timerTask = new TimerTask() {
					@Override
					public void run() {
						if(currentLevel<=10000){
							currentLevel+=200;
							Message message=new Message();
							message.what=1001;
							message.arg1=currentLevel;
							mHandler.sendMessage(message);
						}else
						{
							mAnimationAble.start();
							this.cancel();

						}
					}
				};
				mTimer.schedule(timerTask,0,80);
			}
		});
	}
}
