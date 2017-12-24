package businesslogic.tablebl;

import java.sql.Date;

import businesslogicservice.tableblservice.ManageCourseTableBLService;
import vo.OperateCourseTableVO;

public class OperateCourseTableController implements ManageCourseTableBLService{
	OperateCourseTable impl=new OperateCourseTable();
	@Override
	public OperateCourseTableVO findByInterval(Date begin, Date end) {
		return impl.findByInterval(begin, end);
	}
	

	@Override
	public OperateCourseTableVO findByField(Date begin, Date end,String type, String memberName, String userName) {
		return impl.findByField(begin, end,type, memberName, userName);
	}

}
