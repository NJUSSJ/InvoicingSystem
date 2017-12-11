package dataservice.memberdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.MemberPO;

public interface MemberDataService extends Remote {

	public MemberPO findMemberbyName(String name) throws RemoteException;
	public ArrayList<MemberPO> findMembers() throws RemoteException;
	public MemberPO findMemberbyID(long id) throws RemoteException;
	public ArrayList<MemberPO> findMembersbyField(String field) throws RemoteException;
	public boolean insert(MemberPO po) throws RemoteException;
	public boolean delete(MemberPO po) throws RemoteException;
	public boolean update(MemberPO po) throws RemoteException;


}
