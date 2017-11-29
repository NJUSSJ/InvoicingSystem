package businesslogicservice.billblservice;

import java.sql.Date;

import vo.PayBillVO;

public interface PayBillBLService {
	public PayBillVO toBillVO(String id, long userid,long memberid,double sum ,Date time,int state);
	public String conveyBill(PayBillVO paybill);
	public PayBillVO checkBill();
}
