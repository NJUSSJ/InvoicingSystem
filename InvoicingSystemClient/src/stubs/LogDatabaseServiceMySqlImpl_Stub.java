package stubs;

import java.rmi.RemoteException;
import java.sql.Date;
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
	public ArrayList<LogPO> findLogbyType(String type) throws RemoteException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public int getLogNum() throws RemoteException {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public boolean delete(Date time) throws RemoteException {
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public boolean update(LogPO po) throws RemoteException {
		// TODO �Զ����ɵķ������
		return false;
	}

}