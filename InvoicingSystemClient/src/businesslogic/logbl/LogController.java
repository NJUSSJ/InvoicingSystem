package businesslogic.logbl;

import java.util.ArrayList;

import businesslogicservice.logblservice.LogBLService;
import po.LogPO;
import vo.LogVO;

public class LogController implements LogBLService{
	Log logImpl=new Log();
	@Override
	public boolean addLog(LogVO logVO) {
		// TODO �Զ����ɵķ������
		return logImpl.addLog(logVO);
	}

	@Override
	public ArrayList<LogVO> findLog() {
		// TODO �Զ����ɵķ������
		return logImpl.findLog();
	}

	@Override
	public ArrayList<LogVO> findLogByUserID(long userid) {
		// TODO �Զ����ɵķ������
		return logImpl.findLogByUserID(userid);
	}

	@Override
	public ArrayList<LogVO> findLogByType(String type) {
		// TODO �Զ����ɵķ������
		return logImpl.findLogByType(type);
	}

	@Override
	public LogVO toLogVO(LogPO logPO) {
		// TODO �Զ����ɵķ������
		return logImpl.toLogVO(logPO);
	}
	
}
