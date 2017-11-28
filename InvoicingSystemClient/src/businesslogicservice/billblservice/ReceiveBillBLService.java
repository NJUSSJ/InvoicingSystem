package businesslogicservice.billblservice;

import java.sql.Date;

import vo.ReceiveBillVO;

public interface ReceiveBillBLService {
	public ReceiveBillVO toBillVO(String id, long user,long member,int sum ,Date time);
	public String conveyBill(ReceiveBillVO paybill);
	public ReceiveBillVO checkBill(ReceiveBillVO paybill);
}
