package businesslogicservice.tableblservice;

import java.sql.Date;

import vo.OperateCourseTableVO;

/**
 * 
 * @author yrz:经营历程表 bl接口
 *
 */
public interface OperateCourseTableBLService {
	public OperateCourseTableVO findByInterval(Date begin,Date end);
	public OperateCourseTableVO findByField(Date begin,Date end,String type,String memberName,String userName);
}
