package dataservice.billdataservice;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import po.SaleBillPO;

public interface SaleBillDataService {
	public boolean insert(SaleBillPO po) throws RemoteException;
	public boolean delete(SaleBillPO po) throws RemoteException;
	public boolean update(SaleBillPO po) throws RemoteException;
	public SaleBillPO findSaleBillbyID(long id) throws RemoteException;
	public ArrayList<SaleBillPO> findSaleBills() throws RemoteException;
	public ArrayList<SaleBillPO> findSaleBillbyTime(Date time) throws RemoteException;
	public ArrayList<SaleBillPO> findSaleBillbyState(int state) throws RemoteException;
}
