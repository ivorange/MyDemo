package co.example.ivorange.studyproject;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by ivorange on 16/2/19.
 */
public class TestRemoteService extends Service{
	private android.os.Handler serviceHandler = null;
	private int counter = 0;
	private TestCounterTask myTask = new TestCounterTask();

	public void onCreate() {
		super.onCreate();
		showInfo("remote service onCreate()");
	}

	public void onDestroy() {
		super.onDestroy();
		serviceHandler.removeCallbacks(myTask); //停止计数器
		serviceHandler = null;
		showInfo("remote service onDestroy()");
	}

	public void onStart(Intent intent, int startId) {
		// 开启计数器
		super.onStart(intent, startId);
		serviceHandler=new android.os.Handler();
		serviceHandler.postDelayed(myTask, 1000);
		showInfo("remote service onStart()");
	}

	//步骤2.1：具体实现接口中暴露给client的Stub，提供一个stub inner class来具体实现。
//	private ITestRemoteService.Stub stub= new ITestRemoteService.Stub() {
//		//步骤2.1：具体实现AIDL文件中接口的定义的各个方法。
//		public int getCounter() throws RemoteException {
//			showInfo("getCounter()");
//			return counter;
//		}
//	};

	//步骤2.2：当client连接时，将触发onBind()，Service向client返回一个stub对象，由此client可以通过stub对象来访问Service，本例中通过stub.getCounter()就可以获得计时器的当前计数。在这个例子中，我们向所有的client传递同一stub对象。
	public IBinder onBind(Intent arg0) {
//		showInfo("onBind() " + stub); //我们特别跟踪了stub对象的地址，可以在client连接service中看看通过ServiceConnection传递给client
		return null;
	}

	/* 用Runnable使用定时计数器，每10秒计数器加1。 */
	private class TestCounterTask implements Runnable{
		public void run() {
			++ counter;
			serviceHandler.postDelayed(myTask,10000);
			showInfo("running " + counter);
		}
	}
	/* showInfo( ) 帮助我们进行信息跟踪，更好了解Service的运行情况 */
	private void showInfo(String s){
		System.out.println("[" +getClass().getSimpleName()+"@" + Thread.currentThread().getName()+ "] " + s);
	}
}
