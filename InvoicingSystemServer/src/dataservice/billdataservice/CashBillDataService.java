package dataservice.billdataservice;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import po.CashBillPO;

public interface CashBillDataService {
	public boolean insert(CashBillPO po) throws RemoteException;
	public boolean delete(CashBillPO po) throws RemoteException;
	public boolean update(CashBillPO po) throws RemoteException;
	public CashBillPO findCashBillbyID(long id) throws RemoteException;
	public ArrayList<CashBillPO> findCashBills() throws RemoteException;
	public ArrayList<CashBillPO> findCashBillbyTime(Date time) throws RemoteException;
	public ArrayList<CashBillPO> findCashBillbyState(int state) throws RemoteException;
}
