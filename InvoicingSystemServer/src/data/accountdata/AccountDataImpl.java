package data.accountdata;
/**
 * @author shisj
 */
import java.rmi.RemoteException;

import dataservice.accountdataservice.accountdataservice;
import po.AccountPO;

public class AccountDataImpl implements accountdataservice {

	/**
	 * 根据id查找账户
	 */
	@Override
	public AccountPO find(long id) throws RemoteException {
		// TODO Auto-generated method stub
		
		return null;
	}

	/**
	 * 插入新的账户对象
	 */
	@Override
	public void insert(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	/**
	 * 删除账户对象
	 */
	@Override
	public void delete(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 维护账户对象
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
