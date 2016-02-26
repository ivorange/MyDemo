package co.example.ivorange.newproject.parsexmldemo;

import android.content.res.XmlResourceParser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import co.example.ivorange.newproject.R;

public class ParseXmlActivity extends AppCompatActivity {

	private XmlPullParser xmlPullParser;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parse_xml);
		xmlPullParser= Xml.newPullParser();
	}

	public void parseXml(){
		try
		{
			InputStream inputStream=getResources().getAssets().open("pack_config_20x16.xml");
			xmlPullParser.setInput(inputStream,"UTF-8");
			int eventype=xmlPullParser.getEventType();
			while (eventype!=XmlPullParser.END_DOCUMENT){

			}
		}catch (Exception ex){

		}
	}
}
