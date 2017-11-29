package businesslogic.logbl;

import java.rmi.RemoteException;

import businesslogicservice.logblservice.LogBLService;
import po.LogPO;
import rmi.RemoteHelper;
import vo.LogVO;

public class Log implements LogBLService{

	@Override
	public boolean addRecord(LogVO vo) {
		// TODO Auto-generated method stub
		LogPO tmpLogPO=vo.toPO();
		try {
			return RemoteHelper.getInstance().getLogDataService().insert(tmpLogPO);
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void checkRecord() {
		// TODO Auto-generated method stub
		
	}

}
