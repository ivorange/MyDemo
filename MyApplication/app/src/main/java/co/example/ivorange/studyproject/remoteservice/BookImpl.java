package co.example.ivorange.studyproject.remoteservice;

import android.os.RemoteException;

import co.example.ivorange.studyproject.BookInfo;

/**
 * Created by ivorange on 16/2/19.
 */
public class BookImpl extends BookInfo.Stub {

	private String mName;
	@Override
	public void setName(String name) throws RemoteException {
		mName=name;
	}

	@Override
	public void setPrice(int price) throws RemoteException {

	}

	@Override
	public void ssetPublish(String pname) throws RemoteException {

	}

	@Override
	public String display() throws RemoteException {
		return mName;
	}
}
