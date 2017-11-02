package dataservice.billdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.SaleBillPO;

public interface SaleBillDataService {
	public void insert(SaleBillPO po) throws RemoteException;
	public void delete(SaleBillPO po) throws RemoteException;
	public void update(SaleBillPO po) throws RemoteException;
	public SaleBillPO find(long id) throws RemoteException;
	public ArrayList<SaleBillPO> finds(String field) throws RemoteException;
}
