package dataservice.billdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CashBillPO;

public interface CashBillDataService {
	public void insert(CashBillPO po) throws RemoteException;
	public void delete(CashBillPO po) throws RemoteException;
	public void update(CashBillPO po) throws RemoteException;
	public CashBillPO find(long id) throws RemoteException;
	public ArrayList<CashBillPO> finds(String field) throws RemoteException;
}
