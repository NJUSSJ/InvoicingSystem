package businesslogicservice.tableblservice;

import java.sql.Date;

import vo.OperateCourseTableVO;

/**
 * 
 * @author yrz:��Ӫ���̱� bl�ӿ�
 *
 */
public interface OperateCourseTableBLService {
	public OperateCourseTableVO findByInterval(Date begin,Date end);
	public OperateCourseTableVO findByField(Date begin,Date end,String type,String memberName,String userName);
}
