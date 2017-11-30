package stubs;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.logdataservice.LogDataService;
import po.LogPO;

public class LogDatabaseServiceMySqlImpl_Stub implements LogDataService {

	@Override
	public boolean insert(LogPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public ArrayList<LogPO> findLogs() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<LogPO> findLogbyOperator(long operatorID) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean delete(LogPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean update(LogPO po) throws RemoteException {
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
