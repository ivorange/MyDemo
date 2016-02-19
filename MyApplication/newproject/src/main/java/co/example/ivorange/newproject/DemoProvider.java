package co.example.ivorange.newproject;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.os.CancellationSignal;
import android.provider.BaseColumns;
import android.support.annotation.Nullable;

import java.security.Provider;
import java.sql.SQLException;

/**
 * Created by ivorange on 16/2/19.
 */
public class DemoProvider extends ContentProvider {

	public final Uri CONTENT_URI=Uri.parse("content://com.google.android.MyContentProvider");
	private SQLiteDatabase sqlDB;
	private DatabaseHelper    dbHelper;
	private static final String  DATABASE_NAME = "User.db";
	private static final int  DATABASE_VERSION= 1;
	private static final String TABLE_NAME= "User";
	private static final String TAG ="MyContentProvider";

	private static class DatabaseHelper extends SQLiteOpenHelper {
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			//创建用于存储数据的表
			db.execSQL("Create table " + TABLE_NAME + "( _id INTEGER PRIMARY KEY AUTOINCREMENT, USER_NAME TEXT);");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
			onCreate(db);
		}
	}


	@Nullable
	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
						String sortOrder) {
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		qb.setTables(TABLE_NAME);
		Cursor c = qb.query(db, projection, selection, null, null, null, sortOrder);
		c.setNotificationUri(getContext().getContentResolver(), uri);
		return c;
	}

	@Nullable
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		sqlDB = dbHelper.getWritableDatabase();
		long rowId = sqlDB.insert(TABLE_NAME,null, values);
		if (rowId > 0) {
			Uri rowUri = ContentUris.appendId(MyUsers.User.CONTENT_URI.buildUpon(), rowId).build();
			getContext().getContentResolver().notifyChange(rowUri, null);
			return rowUri;
		}
		return null;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		return 0;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
		return 0;
	}


	@Nullable
	@Override
	public String getType(Uri uri) {
		return null;
	}

	@Override
	public boolean onCreate() {
		dbHelper=new DatabaseHelper(getContext());

		return dbHelper==null?false:true;
	}



}

