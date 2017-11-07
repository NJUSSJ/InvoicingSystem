package businesslogicservice.billblservice;

import vo.CashBillVO;

public interface CashBillBLService {
	public CashBillVO toBillVO(long id,String user,String member,int sum,int time);
	public String conveyBill(CashBillVO cashbill);
	public CashBillVO checkBill(CashBillVO cashbill);
}
