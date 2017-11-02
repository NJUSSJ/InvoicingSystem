package stubs;

import java.rmi.RemoteException;

import dataservice.billdataservice.BillDatasService;
import po.BillPO;

public class BillDatabaseServiceMySqlImpl_Stub implements BillDatasService{

	@Override
	public void delete(BillPO b) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete Succeed");
	}

	@Override
	public BillPO find(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return new BillPO();
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Init");
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Finish");
		
	}

	@Override
	public void insert(BillPO b) throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("Insert");
	}

	@Override
	public void update(BillPO b) throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("Insert");
	}

}
