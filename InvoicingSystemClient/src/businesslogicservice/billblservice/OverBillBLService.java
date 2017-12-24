package businesslogicservice.billblservice;

import java.sql.Date;
import java.util.ArrayList;

import po.OverBillPO;
import vo.OverBillVO;

public interface OverBillBLService {
	public OverBillVO toOverBillVO(OverBillPO overBillPO);
	public boolean submitOverBill(OverBillVO overBill);
	public boolean checkOverBill(boolean pass,long id);
	public boolean deleteOverBill(OverBillVO overBill);
	public OverBillVO findOverBillByID(long id);
	public ArrayList<OverBillVO> findOverBillByTime(Date time);
	public ArrayList<OverBillVO> findOverBills();
	public ArrayList<OverBillVO> findOverBillsByInterval(Date begin,Date end);
	public ArrayList<OverBillVO> findOverBillsByField(Date begin,Date end,String userName);
	public ArrayList<OverBillVO> findOverBillsByState(int state);
	public ArrayList<OverBillVO> findOverBillsByUser(long id);
	public boolean fakeDelete(long id);
}
