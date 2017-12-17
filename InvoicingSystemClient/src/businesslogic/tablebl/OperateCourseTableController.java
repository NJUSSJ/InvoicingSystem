package businesslogic.tablebl;

import java.util.Date;

import businesslogicservice.tableblservice.OperateCourseTableBLService;
import vo.OperateCourseTableVO;

public class OperateCourseTableController implements OperateCourseTableBLService{
	OperateCourseTable impl=new OperateCourseTable();
	@Override
	public OperateCourseTableVO findByDate(Date begin, Date end) {
		// TODO 自动生成的方法存根
		return impl.findByDate(begin, end);
	}

	@Override
	public OperateCourseTableVO findByType(Date begin, Date end, String type) {
		// TODO 自动生成的方法存根
		return impl.findByType(begin, end, type);
	}

	@Override
	public OperateCourseTableVO findByField(Date begin, Date end, String field) {
		// TODO 自动生成的方法存根
		return impl.findByField(begin, end, field);
	}

	@Override
	public boolean exportAsExcel(OperateCourseTableVO vo, String path) {
		// TODO 自动生成的方法存根
		return impl.exportAsExcel(vo, path);
	}

}
