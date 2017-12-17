package businesslogicservice.tableblservice;

import java.util.Date;

import vo.OperateCourseTableVO;

/**
 * 
 * @author yrz:经营历程表 bl接口
 *
 */
public interface OperateCourseTableBLService {
	public OperateCourseTableVO findByDate(Date begin,Date end);
	public OperateCourseTableVO findByType(Date begin,Date end,String type);
	public OperateCourseTableVO findByField(Date begin,Date end,String field);
	public boolean exportAsExcel(OperateCourseTableVO vo,String path);
}
