package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import po.OverBillPO;

public interface OverBillDataService extends Remote {
	public boolean insert(OverBillPO po) throws RemoteException;
	public boolean delete(OverBillPO po) throws RemoteException;
	public boolean update(OverBillPO po) throws RemoteException;
	public OverBillPO findOverBillbyID(long id) throws RemoteException;
	public ArrayList<OverBillPO> findOverBills() throws RemoteException;
	public ArrayList<OverBillPO> findOverBillbyTime(Date time) throws RemoteException;
	public ArrayList<OverBillPO> findOverBillbyState(int state) throws RemoteException;
	public ArrayList<OverBillPO> findOverBillbyField(String user) throws RemoteException; 
}
