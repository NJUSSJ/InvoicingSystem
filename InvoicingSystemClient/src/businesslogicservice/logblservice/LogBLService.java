package businesslogicservice.logblservice;

import java.util.ArrayList;

import po.LogPO;
import vo.LogVO;

public interface LogBLService {
	public boolean addLog(LogVO logVO);
	public ArrayList<LogVO> findLogs();
	public ArrayList<LogVO> findLogByUserID(long userid);
	public ArrayList<LogVO> findLogByType(String type);
	public LogVO toLogVO(LogPO logPO);
}
