package dataservice.logdataservice;

import java.rmi.RemoteException;

import po.LogPO;

public interface LogDataService {

	public boolean insert(LogPO po) throws RemoteException;
	public void delete(LogPO po) throws RemoteException;
	public void update(LogPO po) throws RemoteException;
	public void init() throws RemoteException;
	public void finish() throws RemoteException;

}
