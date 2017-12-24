package businesslogic.tablebl;

import java.sql.Date;

import businesslogicservice.tableblservice.ManageConditionTableBLService;
import vo.OperateConditionTableVO;

public class OperateConditionTableController implements ManageConditionTableBLService{
	OperateConditionTable impl=new OperateConditionTable();
	@Override
	public OperateConditionTableVO findByInterval(Date begin, Date end) {
		return impl.findByInterval(begin, end);
	}
	@Override
	public boolean exportAsExcel(OperateConditionTableVO vo, String path) {
		return impl.exportAsExcel(vo, path);
	}

}
