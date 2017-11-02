package dataservice.billdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LossBillPO;

public interface LossBillDataService {
	public void insert(LossBillPO po) throws RemoteException;
	public void delete(LossBillPO po) throws RemoteException;
	public void update(LossBillPO po) throws RemoteException;
	public LossBillPO find(long id) throws RemoteException;
	public ArrayList<LossBillPO> finds(String field) throws RemoteException;
}
