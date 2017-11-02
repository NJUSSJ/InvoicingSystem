package dataservice.billdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.GiftBillPO;

public interface GiftBillDataService {
	public void insert(GiftBillPO po) throws RemoteException;
	public void delete(GiftBillPO po) throws RemoteException;
	public void update(GiftBillPO po) throws RemoteException;
	public GiftBillPO find(long id) throws RemoteException;
	public ArrayList<GiftBillPO> finds(String field) throws RemoteException;
}
