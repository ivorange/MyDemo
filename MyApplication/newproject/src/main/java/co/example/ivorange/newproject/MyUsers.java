package co.example.ivorange.newproject;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by ivorange on 16/2/19.
 */
public class MyUsers {
	public static final String AUTHORITY  = "co.example.ivorange.newproject.DemoProvider";

	// BaseColumn类中已经包含了 _id字段
	public static final class User implements BaseColumns {
		public static final Uri CONTENT_URI  = Uri.parse("content://co.example.ivorange.newproject.DemoProvider");
		// 表数据列
		public static final String  USER_NAME  = "USER_NAME";
	}
}
