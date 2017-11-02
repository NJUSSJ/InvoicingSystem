package dataservice.billdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ReceiveBillPO;

public interface ReceiveBillDataService {
	public void insert(ReceiveBillPO po) throws RemoteException;
	public void delete(ReceiveBillPO po) throws RemoteException;
	public void update(ReceiveBillPO po) throws RemoteException;
	public ReceiveBillPO find(long id) throws RemoteException;
	public ArrayList<ReceiveBillPO> finds(String field) throws RemoteException;
}
