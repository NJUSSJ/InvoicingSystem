package stubs;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.logdataservice.LogDataService;
import po.LogPO;

public class LogDatabaseServiceMySqlImpl_Stub implements LogDataService {

	@Override
	public boolean insert(LogPO po) throws RemoteException {
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public ArrayList<LogPO> findLogs() throws RemoteException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ArrayList<LogPO> findLogbyOperator(long operatorID) throws RemoteException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public boolean delete(LogPO po) throws RemoteException {
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public boolean update(LogPO po) throws RemoteException {
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
