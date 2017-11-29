package businesslogicservice.billblservice;

import java.sql.Date;

import po.PayBillPO;
import vo.PayBillVO;

public interface PayBillBLService {
	public PayBillVO toPayBillVO(PayBillPO po);
	public String conveyBill(PayBillVO paybill);
	public PayBillVO checkBill();
}
