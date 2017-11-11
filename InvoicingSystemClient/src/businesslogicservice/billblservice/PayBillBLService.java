package businesslogicservice.billblservice;

import vo.PayBillVO;

public interface PayBillBLService {
	public PayBillVO toBillVO(long id, String user,String member,int sum ,int time);
	public String conveyBill(PayBillVO paybill);
	public PayBillVO checkBill();
}
