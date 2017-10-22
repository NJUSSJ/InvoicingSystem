package stubs;

import java.rmi.RemoteException;

import dataservice.memberdataservice.MemberDataService;
import po.MemberPO;

public class MemberDatabaseServiceMySqlImpl_Stub implements MemberDataService{
	public MemberPO find(String name) throws RemoteException{
		System.out.println("Find succeed!");
		MemberPO mp=new MemberPO();
		return mp;
	}
	public void insert(MemberPO po) throws RemoteException{
		System.out.println("Insert succeed!");
	}
	public void delete(MemberPO po) throws RemoteException{
		System.out.println("Delete succeed!");
	}
	public void update(MemberPO po) throws RemoteException{
		System.out.println("Update succeed!");
	}
	public void init() throws RemoteException{
		System.out.println("Init succeed!");
	}
	public void finish() throws RemoteException{
		System.out.println("Finish succeed!");
	}
}
