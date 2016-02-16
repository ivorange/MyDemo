package co.example.ivorange.studyproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

public class ImageLoaderDemo extends AppCompatActivity {

	//	private ImageView mImgDemo;
	private ImageLoader mLoader;
	private ImageAdapter mAdapter;
	private String[] imageUrls;
	private ImageLoaderConfiguration config;
	private Gallery mGallery;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_loader_demo);
//		mImgDemo=(ImageView)findViewById(R.id.img_demo);
		mGallery = (Gallery) findViewById(R.id.gallery_demo);
		initImageLoader();
		mLoader = ImageLoader.getInstance();
		mLoader.init(config);
		mAdapter = new ImageAdapter(imageUrls, getApplicationContext());
		mGallery.setAdapter(mAdapter);
//		mLoader.displayImage("http://pic.pptbz.com/pptpic/201511/2015111858890897.jpg", mImgDemo);
	}

	public void initImageLoader() {
		imageUrls = new String[]{"http://pic.pptbz.com/pptpic/201511/2015111858890897.jpg",
				"http://static.oschina.net/uploads/space/2014/1102/105150_o9WG_699232.png",
				"http://www.kwstu.com/Content/uploadFiles/images/20140406140008281.jpg",
				"http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1207/16/c0" +
						"/12347883_1342409469167.jpg", "http://pic5.nipic" +
				".com/20100112/1295091_184248499552_2.jpg"};
		config = new ImageLoaderConfiguration
				.Builder(getApplicationContext())
				.memoryCacheExtraOptions(480, 800) // max width, max height，即保存的每个缓存文件的最大长宽
				.threadPoolSize(3)//线程池内加载的数量
				.threadPriority(Thread.NORM_PRIORITY - 2)
				.denyCacheImageMultipleSizesInMemory()
				.memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024)) // You can pass
						// your own memory cache implementation/你可以通过自己的内存缓存实现
				.memoryCacheSize(2 * 1024 * 1024)
				.discCacheSize(50 * 1024 * 1024)
				.discCacheFileNameGenerator(new Md5FileNameGenerator())//将保存的时候的URI名称用MD5 加密
				.tasksProcessingOrder(QueueProcessingType.LIFO)
				.discCacheFileCount(100) //缓存的文件数量
				.defaultDisplayImageOptions(DisplayImageOptions.createSimple())
				.imageDownloader(new BaseImageDownloader(getApplicationContext(), 5 * 1000, 30 *
						1000)) // connectTimeout (5 s), readTimeout (30 s)超时时间
				.writeDebugLogs() // Remove for release app
				.build();//开始构建
	}

	public class ImageAdapter extends BaseAdapter {

		private String[] urls;
		private Context mCtx;

		public ImageAdapter(String[] strings, Context context) {
			this.urls = strings;
			mCtx = context;
		}

		@Override
		public int getCount() {
			return urls.length;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			final ImageView imageView = new ImageView(mCtx);
			DisplayImageOptions options = new DisplayImageOptions.Builder()
					.showImageForEmptyUri(R.drawable.chun1)
					.showImageOnFail(R.drawable.chun2)
					.resetViewBeforeLoading(false)
					.cacheInMemory(true)
					.cacheOnDisc(true)
					.imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
					.bitmapConfig(Bitmap.Config.RGB_565)
							//.displayer(new RoundedBitmapDisplayer(5))注释改行
					.build();
			mLoader.loadImage(urls[position], options, new ImageLoadingListener() {
				@Override
				public void onLoadingStarted(String s, View view) {

				}

				@Override
				public void onLoadingFailed(String s, View view, FailReason failReason) {

				}

				@Override
				public void onLoadingComplete(String s, View view, Bitmap bitmap) {
					imageView.setImageBitmap(bitmap);
				}

				@Override
				public void onLoadingCancelled(String s, View view) {

				}
			});
			return imageView;
		}
	}
}
