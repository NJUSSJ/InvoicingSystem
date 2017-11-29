package businesslogicservice.logblservice;

import vo.LogVO;

public interface LogBLService {
	public boolean addRecord(LogVO vo);
	public void checkRecord();
}
