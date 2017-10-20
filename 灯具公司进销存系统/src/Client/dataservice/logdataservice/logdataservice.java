package Client.dataservice.logdataservice;

import java.rmi.RemoteException;

import Client.po.LogPO;

public interface logdataservice {

	public void insert(LogPO po) throws RemoteException;
	public void delete(LogPO po) throws RemoteException;
	public void update(LogPO po) throws RemoteException;
	public void init() throws RemoteException;
	public void finish() throws RemoteException;

}
