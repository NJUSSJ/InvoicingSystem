package businesslogicservice.billblservice;

import java.sql.Date;

import vo.PayBillVO;

public interface PayBillBLService {
	public PayBillVO toBillVO(String id, long user,long member,int sum ,Date time);
	public String conveyBill(PayBillVO paybill);
	public PayBillVO checkBill();
}
