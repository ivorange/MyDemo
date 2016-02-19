package co.example.ivorange.clientremote;

import com.weather.demo.weather;


import android.os.RemoteException;

/**
 * Created by ivorange on 16/2/19.
 */
public class WeatherBean extends weather.Stub {

	private String mWeather="";

	@Override
	public String displayWeather() throws RemoteException {
		return mWeather;
	}

	@Override
	public void setWeather(String weather) throws RemoteException {
		mWeather=weather;
	}
}
