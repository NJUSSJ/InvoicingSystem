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

	@Override
	public LogVO toLogVO(LogPO logPo) {
		// TODO �Զ����ɵķ������
		return null;
	}

}
