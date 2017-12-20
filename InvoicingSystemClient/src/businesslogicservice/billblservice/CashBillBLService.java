package businesslogicservice.billblservice;

import java.sql.Date;
import java.util.ArrayList;

import po.CashBillPO;
import vo.CashBillVO;

public interface CashBillBLService {
	public CashBillVO toCashBillVO (CashBillPO po);
	public boolean submitCashBill(CashBillVO cashbill);
	public boolean checkCashBill(boolean pass,String id);
	public boolean deleteCashBill(CashBillVO cashbill);
	public CashBillVO findCashBillByID(String id);
	public ArrayList<CashBillVO> findCashBillByTime(Date time);
	public ArrayList<CashBillVO> findCashBills();
	public ArrayList<CashBillVO> findCashBillsByInterval(Date begin,Date end);
	public ArrayList<CashBillVO> findCashBillsByField(Date begin,Date end,String userName);
	public ArrayList<CashBillVO> findCashBillsByState(int state);
	public ArrayList<CashBillVO> findCashBillsByUser(long userid);
}
