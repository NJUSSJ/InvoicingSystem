package data.memberdata;

import java.rmi.RemoteException;

import dataservice.memberdataservice.MemberDataService;
import po.MemberPO;

public class MemberDataImpl implements MemberDataService{

	@Override
	public MemberPO find(String name) throws RemoteException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public boolean insert(MemberPO po) throws RemoteException {
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public boolean delete(MemberPO po) throws RemoteException {
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public boolean update(MemberPO po) throws RemoteException {
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public void init() throws RemoteException {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void finish() throws RemoteException {
		// TODO �Զ����ɵķ������
		
	}
	
}
