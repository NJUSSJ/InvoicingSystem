package businesslogicservice.tableblservice;

import java.sql.Date;

import vo.OperateConditionTableVO;

public interface OperateConditionTableBLService {
	public OperateConditionTableVO findByInterval(Date begin,Date end);
}
