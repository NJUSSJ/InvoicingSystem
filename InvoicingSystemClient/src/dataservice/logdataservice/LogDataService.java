package dataservice.logdataservice;

import java.rmi.RemoteException;

import po.LogPO;

public interface LogDataService {
	public void insert(LogPO po) throws RemoteException;
	public void findLogs() throws RemoteException;
	public void findLogbyOperator(long operatorID) throws RemoteException;
	public void delete(LogPO po) throws RemoteException;
	public void update(LogPO po) throws RemoteException;
	public void init() throws RemoteException;
	public void finish() throws RemoteException;

}
