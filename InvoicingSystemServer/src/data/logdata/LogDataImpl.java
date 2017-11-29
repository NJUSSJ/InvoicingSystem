package data.logdata;

import java.rmi.RemoteException;

import dataservice.logdataservice.logdataservice;
import po.LogPO;

public class LogDataImpl implements logdataservice {

	@Override
	public void insert(LogPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String sql="insert into logs (id,time,type,userid)"
				+ "values"
				+ "('";
	}

	@Override
	public void findLogs() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findLogbyOperator(long operatorID) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(LogPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(LogPO po) throws RemoteException {
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
