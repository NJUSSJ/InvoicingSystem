package businesslogicservice.billblservice;

import java.sql.Date;

import po.CashBillPO;
import vo.CashBillVO;

public interface CashBillBLService {
	public CashBillVO toCashBillVO (CashBillPO po);
	public String conveyBill(CashBillVO cashbill);
	public CashBillVO checkBill(CashBillVO cashbill);
}
