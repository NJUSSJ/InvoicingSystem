package data.accountdata;
/**
 * @author shisj
 */
import java.rmi.RemoteException;

import dataservice.accountdataservice.accountdataservice;
import po.AccountPO;

public class AccountDataImpl implements accountdataservice {

	/**
	 * ����id�����˻�
	 */
	@Override
	public AccountPO find(long id) throws RemoteException {
		// TODO Auto-generated method stub
		
		return null;
	}

	/**
	 * �����µ��˻�����
	 */
	@Override
	public void insert(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	/**
	 * ɾ���˻�����
	 */
	@Override
	public void delete(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ά���˻�����
	 */
	@Override
	public void update(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
