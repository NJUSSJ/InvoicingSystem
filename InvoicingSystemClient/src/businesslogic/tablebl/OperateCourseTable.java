package businesslogic.tablebl;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.billbl.SaleBillController;
import businesslogicservice.tableblservice.OperateCourseTableBLService;
import vo.OperateCourseTableVO;
import vo.SaleBillVO;

public class OperateCourseTable{

	public OperateCourseTableVO findByDate(Date begin, Date end) {
		return null;
	}

	public OperateCourseTableVO findByType(Date begin, Date end, String type) {
		return null;
	}

	public OperateCourseTableVO findByField(Date begin, Date end, String field) {
		return null;
	}

	public boolean exportAsExcel(OperateCourseTableVO vo, String path) {
		return false;
	}
	

}
