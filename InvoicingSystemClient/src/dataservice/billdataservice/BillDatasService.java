package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.BillPO;

public interface BillDatasService extends Remote {
	public void insert(BillPO b) throws RemoteException;
	public void delete(BillPO b) throws RemoteException;
	public void update(BillPO b) throws RemoteException;
	public BillPO find(int id) throws RemoteException;
	public void init() throws RemoteException;
	public void finish() throws RemoteException;
}
