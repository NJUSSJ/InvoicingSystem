package data.logdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.logdataservice.logdataservice;
import po.LogPO;

public class LogDataImpl implements logdataservice {

	@Override
	public boolean insert(LogPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String sql="insert into logs (id,time,type,userid)"
				+ "values"
				+ "('"+po.getID()+"','"+po.getTime()+"','"+po.getType()+"','"+po.getUserID()+",)";
	}

	@Override
	public ArrayList<LogPO> findLogs() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<LogPO> findLogbyOperator(long operatorID) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete(LogPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean update(LogPO po) throws RemoteException {
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
