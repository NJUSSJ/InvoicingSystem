package dataservice.billdataservice;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import po.WarningBillPO;

public interface WarningBillDataService {
	public boolean insert(WarningBillPO po) throws RemoteException;
	public boolean delete(WarningBillPO po) throws RemoteException;
	public boolean update(WarningBillPO po) throws RemoteException;
	public WarningBillPO findWarningBillbyID(long id) throws RemoteException;
	public ArrayList<WarningBillPO> findWarningBills() throws RemoteException;
	public ArrayList<WarningBillPO> findWarningBillbyTime(Date time) throws RemoteException;
	public ArrayList<WarningBillPO> findWarningBillbyState(int state) throws RemoteException;
}
