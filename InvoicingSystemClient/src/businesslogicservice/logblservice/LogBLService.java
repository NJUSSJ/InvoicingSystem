package businesslogicservice.logblservice;

import java.util.ArrayList;

import po.LogPO;
import vo.LogVO;

public interface LogBLService {
	public boolean addLog(LogVO logVO);
	public ArrayList<LogVO> findLogs();
	public ArrayList<LogVO> findLogByUserID(long userid);
	public ArrayList<LogVO> findLogByField(String field);
	public LogVO toLogVO(LogPO logPO);
	public long findLargestID();
}
