package businesslogicservice.logblservice;

import java.util.ArrayList;

import vo.LogVO;

public interface LogBLService {
	public boolean addLog(LogVO vo);
	public ArrayList<LogVO> findLog();
	public ArrayList<LogVO> findLogByUserID(long userid);
	public ArrayList<LogVO> findLogByType(String type);
}
