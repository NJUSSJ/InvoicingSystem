package businesslogic.logbl;

import java.util.ArrayList;

import businesslogicservice.logblservice.LogBLService;
import vo.LogVO;

public class LogController implements LogBLService{
	Log logImpl=new Log();

	@Override
	public boolean addLog(LogVO vo) {
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public ArrayList<LogVO> findLog() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ArrayList<LogVO> findLogByUserID(long userid) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ArrayList<LogVO> findLogByType(String type) {
		// TODO �Զ����ɵķ������
		return null;
	}
	
}
