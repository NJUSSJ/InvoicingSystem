package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import po.ReceiveBillPO;

public interface ReceiveBillDataService extends Remote{
	public boolean insert(ReceiveBillPO po) throws RemoteException;
	public boolean delete(ReceiveBillPO po) throws RemoteException;
	public boolean update(ReceiveBillPO po) throws RemoteException;
	public ReceiveBillPO findReceiveBillbyID(long id) throws RemoteException;
	public ArrayList<ReceiveBillPO> findReceiveBills() throws RemoteException;
	public ArrayList<ReceiveBillPO> findReceiveBillbyTime(Date time) throws RemoteException;
	public ArrayList<ReceiveBillPO> findReceiveBillbyState(int state) throws RemoteException;
	public ArrayList<ReceiveBillPO> findReceiveBillbyField(String user,String member) throws RemoteException;

}
