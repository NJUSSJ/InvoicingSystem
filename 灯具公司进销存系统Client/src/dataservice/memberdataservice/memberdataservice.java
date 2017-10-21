package dataservice.memberdataservice;

import java.rmi.RemoteException;

import po.MemberPO;

public interface memberdataservice {

	public MemberPO find(String name) throws RemoteException;
	public void insert(MemberPO po) throws RemoteException;
	public void delete(MemberPO po) throws RemoteException;
	public void update(MemberPO po) throws RemoteException;
	public void init() throws RemoteException;
	public void finish() throws RemoteException;

}
