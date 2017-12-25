package businesslogic.logbl;

import java.util.ArrayList;

import businesslogicservice.logblservice.LogBLService;
import po.LogPO;
import vo.LogVO;

public class LogController implements LogBLService{
	Log logImpl=new Log();
	@Override
	public boolean addLog(LogVO logVO) {
		return logImpl.addLog(logVO);
	}

	@Override
	public ArrayList<LogVO> findLogs() {
		return logImpl.findLogs();
	}

	@Override
	public ArrayList<LogVO> findLogByUserID(long userid) {
		return logImpl.findLogByUserID(userid);
	}

	@Override
	public ArrayList<LogVO> findLogByField(String field) {
		return logImpl.findLogByType(field);
	}

	@Override
	public LogVO toLogVO(LogPO logPO) {
		return logImpl.toLogVO(logPO);
	}

	@Override
	public long findLargestID() {
		return logImpl.findLargestID();
	}
	
}
