package stubs;

import java.rmi.RemoteException;

import dataservice.memberdataservice.MemberDataService;
import po.MemberPO;

public class MemberDatabaseServiceMySqlImpl_Stub implements MemberDataService{
	public MemberPO find(String name) throws RemoteException{
		System.out.println("Find succeed!");
		MemberPO mp=new MemberPO(0, 0, 0, 0, name, 0, name, name, 0, 0, 0, 0);
		return mp;
	}
	public boolean insert(MemberPO po) throws RemoteException{
		return true;
	}
	public boolean delete(MemberPO po) throws RemoteException{
		return true;
	}
	public boolean update(MemberPO po) throws RemoteException{
		return true;
	}
	public void init() throws RemoteException{
		System.out.println("Init succeed!");
	}
	public void finish() throws RemoteException{
		System.out.println("Finish succeed!");
	}
}
