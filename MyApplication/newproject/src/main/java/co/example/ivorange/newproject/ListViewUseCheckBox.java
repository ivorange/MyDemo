package co.example.ivorange.newproject;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListViewUseCheckBox extends AppCompatActivity {

	private ListView mList;
	private List<HashMap<String, String>> mapList;
	private TextView mTextDemo;
	private CheckView mDemoView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view_use_check_box);
		mList = (ListView) findViewById(R.id.list_demo);
		mTextDemo = (TextView) findViewById(R.id.text_method);
//		initData();
//		testTextview();

//
	}

	public void initData() {
		mapList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			HashMap<String, String> hashMap = new HashMap<>();
			hashMap.put("item_key", "...the item is " + i);
			mapList.add(hashMap);
		}
		SimpleAdapter simpleAdapter = new SimpleAdapter(getApplicationContext(), mapList, R.layout
				.listview_items, new String[]{"item_key"}, new int[]{R.id.text_list});
		mList.setAdapter(simpleAdapter);
	}

	public void testTextview() {
		mTextDemo.setMovementMethod(ScrollingMovementMethod.getInstance());
	}

	public void testDemoView(){

	}
}
