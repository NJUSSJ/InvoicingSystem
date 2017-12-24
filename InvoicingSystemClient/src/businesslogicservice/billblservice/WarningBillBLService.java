package businesslogicservice.billblservice;

import java.sql.Date;
import java.util.ArrayList;

import po.WarningBillPO;
import vo.WarningBillVO;

public interface WarningBillBLService {
	public WarningBillVO toWarningBillVO(WarningBillPO po);
	public boolean submitWarningBill(WarningBillVO warningBill);
	public boolean checkWarningBill(boolean pass,long id);
	public boolean deleteWarningBill(WarningBillVO warningBill);
	public WarningBillVO findWarningBillByID(long id);
	public ArrayList<WarningBillVO> findWarningBillByTime(Date time);
	public ArrayList<WarningBillVO> findWarningBills();
	public ArrayList<WarningBillVO> findWarningBillsByState(int state);
	public ArrayList<WarningBillVO> findWarningBillsByUser(long userid);
	public boolean fakeDelete(long id);
}
