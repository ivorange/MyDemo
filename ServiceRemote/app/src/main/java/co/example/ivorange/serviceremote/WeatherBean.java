package co.example.ivorange.serviceremote;

import android.os.RemoteException;

import com.weather.demo.weather;

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
