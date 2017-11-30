package businesslogic.logbl;

import java.util.ArrayList;

import businesslogicservice.logblservice.LogBLService;
import vo.LogVO;

public class LogController implements LogBLService{
	Log logImpl=new Log();

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
	
}
