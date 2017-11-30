package dataservice.memberdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.MemberPO;

public interface MemberDataService {

	public MemberPO find(String name) throws RemoteException;
	public ArrayList<MemberPO> findMembers() throws RemoteException;
	public ArrayList<MemberPO> fings(String field) throws RemoteException;
	public boolean insert(MemberPO po) throws RemoteException;
	public boolean delete(MemberPO po) throws RemoteException;
	public boolean update(MemberPO po) throws RemoteException;
	public void init() throws RemoteException;
	public void finish() throws RemoteException;


}
