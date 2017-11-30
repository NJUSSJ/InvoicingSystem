package businesslogicservice.billblservice;

import po.PayBillPO;
import vo.PayBillVO;

public interface PayBillBLService {
	public PayBillVO toPayBillVO(PayBillPO po);
	public String conveyBill(PayBillVO paybill);
	public PayBillVO checkBill();
}
