package dataservice.billdataservice;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import po.PayBillPO;

public interface PayBillDataService {
	public boolean insert(PayBillPO po) throws RemoteException;
	public boolean delete(PayBillPO po) throws RemoteException;
	public boolean update(PayBillPO po) throws RemoteException;
	public PayBillPO findPayBillbyID(long id) throws RemoteException;
	public ArrayList<PayBillPO> findPayBills() throws RemoteException;
	public ArrayList<PayBillPO> findPayBillbyTime(Date time) throws RemoteException;
	public ArrayList<PayBillPO> findPayBillbyState(int state) throws RemoteException;
}
