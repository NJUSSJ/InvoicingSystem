package businesslogicservice.billblservice;

import java.sql.Date;
import java.util.ArrayList;

import po.CashBillPO;
import vo.CashBillVO;

public interface CashBillBLService {
	public CashBillVO toCashBillVO (CashBillPO po);
	public boolean submitCashBill(CashBillVO cashbill);
	public boolean checkCashBill(boolean pass,long id);
	public boolean deleteCashBill(CashBillVO cashbill);
	public ArrayList<CashBillVO> findCashBillByTime(Date time);
}
