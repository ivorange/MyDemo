package co.example.ivorange.newproject.reference;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

import co.example.ivorange.newproject.R;

public class ReferenceActiive extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reference_actiive);
		ReferenceDemoClass referenceDemoClass=new ReferenceDemoClass();
		WeakReference<ReferenceDemoClass> weakReference=new WeakReference<ReferenceDemoClass>(referenceDemoClass);
		referenceDemoClass=null;
		if(weakReference.get()==null){
			Log.d("weakReference","....对象进入垃圾回收机制");
		}else {
			Log.d("weakReference","....对象未进入垃圾回收机制");
		}
//		System.gc();

		if(weakReference.get()==null){
			Log.d("weakReference","....对象进入垃圾回收机制");
		}else {
			Log.d("weakReference","....对象未进入垃圾回收机制");
		}
	}
}
