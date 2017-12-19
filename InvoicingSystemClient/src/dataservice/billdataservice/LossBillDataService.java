package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import po.LossBillPO;

public interface LossBillDataService extends Remote {
	public boolean insert(LossBillPO po) throws RemoteException;
	public boolean delete(LossBillPO po) throws RemoteException;
	public boolean update(LossBillPO po) throws RemoteException;
	public LossBillPO findLossBillbyID(long id) throws RemoteException;
	public ArrayList<LossBillPO> findLossBillbyState(int state) throws RemoteException;
	public ArrayList<LossBillPO> findLossBills() throws RemoteException;
	public ArrayList<LossBillPO> findLossBillbyTime(Date time) throws RemoteException;
	public ArrayList<LossBillPO> findLossBillbyField(String user) throws RemoteException;
	public ArrayList<LossBillPO> findLossBillbyUser(long userid) throws RemoteException;
}

