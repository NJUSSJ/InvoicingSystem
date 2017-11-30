package dataservice.logdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LogPO;

public interface LogDataService {
	public boolean insert(LogPO po) throws RemoteException;
	public ArrayList<LogPO> findLogs() throws RemoteException;
	public ArrayList<LogPO> findLogbyOperator(long operatorID) throws RemoteException;
	public boolean delete(LogPO po) throws RemoteException;
	public boolean update(LogPO po) throws RemoteException;
	public void init() throws RemoteException;
	public void finish() throws RemoteException;

}
