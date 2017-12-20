package businesslogicservice.billblservice;

import java.sql.Date;
import java.util.ArrayList;

import po.PayBillPO;
import vo.PayBillVO;

public interface PayBillBLService {
	public PayBillVO toPayBillVO(PayBillPO po);
	public boolean submitPayBill(PayBillVO payBill);
	public boolean checkPayBill(boolean pass,String id);
	public boolean deletePayBill(PayBillVO payBill);
	public PayBillVO findPayBillByID(String id);
	public ArrayList<PayBillVO> findPayBillByTime(Date time);
	public ArrayList<PayBillVO> findPayBills();
	public ArrayList<PayBillVO> findPayBillsByInterval(Date begin,Date end);
	public ArrayList<PayBillVO> findPayBillsByField(Date begin,Date end,String memberName,String userName);
	public ArrayList<PayBillVO> findPayBillsByState(int state);
	public ArrayList<PayBillVO> findPayBillsByUser(long userid);
}
