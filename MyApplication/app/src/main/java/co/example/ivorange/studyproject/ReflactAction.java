package co.example.ivorange.studyproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Method;
import java.util.Objects;

public class ReflactAction extends AppCompatActivity {

	private Button mBtnReflect;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reflact_action);
		mBtnReflect = (Button) findViewById(R.id.btn_add);
		mBtnReflect.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				justDoIt();
			}
		});
	}

	public void justDoIt() {
		try {
			Class<?> classDemo = Class.forName("co.example.ivorange.studyproject.ReflactDemo");
			Object instance=classDemo.newInstance();
			Method method = classDemo.getDeclaredMethod("addMethod", new Class[]{int
					.class, int.class});
			method.setAccessible(true);
			Object object=method.invoke(instance,new Object[]{new Integer(2),new Integer(4)});
			Log.d("result","...."+object);

		} catch (Exception ex) {
			 throw new RuntimeException("..."+ex);
		}

	}
}
