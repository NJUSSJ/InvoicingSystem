package businesslogic.tablebl;

import java.sql.Date;

import businesslogicservice.tableblservice.OperateConditionTableBLService;
import vo.OperateConditionTableVO;

public class OperateConditionTableController implements OperateConditionTableBLService{
	OperateConditionTable impl=new OperateConditionTable();
	@Override
	public OperateConditionTableVO findByInterval(Date begin, Date end) {
		return impl.findByInterval(begin, end);
	}

}
