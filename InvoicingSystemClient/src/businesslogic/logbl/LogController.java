package businesslogic.logbl;

import java.util.ArrayList;

import businesslogicservice.logblservice.LogBLService;
import po.LogPO;
import vo.LogVO;

public class LogController implements LogBLService{
	Log logImpl=new Log();
	@Override
	public boolean addLog(LogVO logVO) {
		// TODO 自动生成的方法存根
		return logImpl.addLog(logVO);
	}

	@Override
	public ArrayList<LogVO> findLog() {
		// TODO 自动生成的方法存根
		return logImpl.findLog();
	}

	@Override
	public ArrayList<LogVO> findLogByUserID(long userid) {
		// TODO 自动生成的方法存根
		return logImpl.findLogByUserID(userid);
	}

	@Override
	public ArrayList<LogVO> findLogByType(String type) {
		// TODO 自动生成的方法存根
		return logImpl.findLogByType(type);
	}

	@Override
	public LogVO toLogVO(LogPO logPO) {
		// TODO 自动生成的方法存根
		return logImpl.toLogVO(logPO);
	}
	
}
