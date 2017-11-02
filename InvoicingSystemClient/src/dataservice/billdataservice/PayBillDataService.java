package dataservice.billdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PayBillPO;

public interface PayBillDataService {
	public void insert(PayBillPO po) throws RemoteException;
	public void delete(PayBillPO po) throws RemoteException;
	public void update(PayBillPO po) throws RemoteException;
	public PayBillPO find(long id) throws RemoteException;
	public ArrayList<PayBillPO> finds(String field) throws RemoteException;
}
