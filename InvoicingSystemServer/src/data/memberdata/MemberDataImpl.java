package data.memberdata;


import java.rmi.RemoteException;

import dataservice.memberdataservice.MemberDataService;
import po.MemberPO;

public class MemberDataImpl implements MemberDataService{

	@Override
	public MemberPO find(String name) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean insert(MemberPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean delete(MemberPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean update(MemberPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public void init() throws RemoteException {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void finish() throws RemoteException {
		// TODO 自动生成的方法存根
		
	}
	

}
