package businesslogic.tablebl;

import java.sql.Date;

import businesslogicservice.tableblservice.OperateCourseTableBLService;
import vo.OperateCourseTableVO;

public class OperateCourseTableController implements OperateCourseTableBLService{
	OperateCourseTable impl=new OperateCourseTable();
	@Override
	public OperateCourseTableVO findByInterval(Date begin, Date end) {
		return impl.findByInterval(begin, end);
	}
	
	@Override
	public boolean exportAsExcel(OperateCourseTableVO vo, String path) {
		return impl.exportAsExcel(vo, path);
	}

	@Override
	public OperateCourseTableVO findByField(Date begin, Date end,String type, String memberName, String userName) {
		return impl.findByField(begin, end,type, memberName, userName);
	}

}
