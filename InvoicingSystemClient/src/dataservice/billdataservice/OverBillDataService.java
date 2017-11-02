package dataservice.billdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.OverBillPO;

public interface OverBillDataService {
	public void insert(OverBillPO po) throws RemoteException;
	public void delete(OverBillPO po) throws RemoteException;
	public void update(OverBillPO po) throws RemoteException;
	public OverBillPO find(long id) throws RemoteException;
	public ArrayList<OverBillPO> finds(String field) throws RemoteException;
}
