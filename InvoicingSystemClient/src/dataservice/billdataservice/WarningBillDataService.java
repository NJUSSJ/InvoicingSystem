package dataservice.billdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.WarningBillPO;

public interface WarningBillDataService {
	public void insert(WarningBillPO po) throws RemoteException;
	public void delete(WarningBillPO po) throws RemoteException;
	public void update(WarningBillPO po) throws RemoteException;
	public WarningBillPO find(long id) throws RemoteException;
}
