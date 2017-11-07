package businesslogicservice.billblservice;

import vo.ReceiveBillVO;

public interface ReceiveBillBLService {
	public ReceiveBillVO toBillVO(long id, String user,String member,int sum ,int time);
	public String conveyBill(ReceiveBillVO paybill);
	public ReceiveBillVO checkBill(ReceiveBillVO paybill);
}
