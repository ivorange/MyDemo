package co.example.ivorange.studyproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;

public class SarializaDemoActive extends AppCompatActivity {

	private SerializaDemo mDemo;
	private Button mBtnGet;
	private Button mBtnSet;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sarializa_demo_active);
		init();
		mBtnGet=(Button)findViewById(R.id.btn_get);
		mBtnGet.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mBtnGet.setText(get().getName());
			}
		});
		mBtnSet=(Button)findViewById(R.id.btn_set);
		mBtnSet.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				set();
			}
		});
	}

	public void init(){
		mDemo=new SerializaDemo();
		mDemo.setAge(19);
		mDemo.setId(1);
		mDemo.setName("Tom");
	}

	public void set(){
		try{
			FileOutputStream fileOutputStream=this.openFileOutput("Data.txt",MODE_PRIVATE);
			ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(mDemo);
			objectOutputStream.close();
			fileOutputStream.close();
		}catch (Exception ex){

		}
	}

	public SerializaDemo get(){
		SerializaDemo serializaDemo=null;
		try{
			FileInputStream fileInputStream=this.openFileInput("Data.txt");
			ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
			serializaDemo=(SerializaDemo)objectInputStream.readObject();

		}catch (Exception ex){
			throw new RuntimeException("..."+ex);
		}
		return serializaDemo;
	}
}
