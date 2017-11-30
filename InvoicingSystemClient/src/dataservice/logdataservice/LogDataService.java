package dataservice.logdataservice;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;


import po.LogPO;

public interface LogDataService {
	public boolean insert(LogPO po) throws RemoteException;
	public ArrayList<LogPO> findLogs() throws RemoteException;
	public ArrayList<LogPO> findLogbyOperator(long operatorID) throws RemoteException;
	public ArrayList<LogPO> findLogbyType(String type) throws RemoteException;
	public int getLogNum() throws RemoteException;
	public boolean delete(Date time) throws RemoteException;
	public boolean update(LogPO po) throws RemoteException;

}
