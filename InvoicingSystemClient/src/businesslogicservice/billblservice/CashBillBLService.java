package businesslogicservice.billblservice;

import po.CashBillPO;
import vo.CashBillVO;

public interface CashBillBLService {
	public CashBillVO toCashBillVO (CashBillPO po);
	public String conveyBill(CashBillVO cashbill);
	public CashBillVO checkBill(CashBillVO cashbill);
}
