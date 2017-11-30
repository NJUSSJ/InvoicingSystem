package businesslogicservice.billblservice;

import po.CashBillPO;
import vo.CashBillVO;

public interface CashBillBLService {
	public CashBillVO toCashBillVO (CashBillPO po);
	public boolean conveyBill(CashBillVO cashbill);
	public boolean checkBill(boolean pass);
}
