package stubs;

import java.sql.Time;
import java.util.ArrayList;

import businesslogicservice.logblservice.LogBLService;
import po.LogPO;
import vo.LogVO;
import vo.UserVO;

public class LogBLService_Stub implements LogBLService{

	@Override
	public boolean addLog(LogVO vo) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public ArrayList<LogVO> findLog() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<LogVO> findLogByUserID(long userid) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<LogVO> findLogByType(String type) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public LogVO toLogVO(LogPO logPo) {
		// TODO 自动生成的方法存根
		return null;
	}

}
