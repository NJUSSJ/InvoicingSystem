package businesslogicservice.billblservice;

import java.sql.Date;
import java.util.ArrayList;

import po.PayBillPO;
import vo.PayBillVO;

public interface PayBillBLService {
	public PayBillVO toPayBillVO(PayBillPO po);
	public boolean submitPayBill(PayBillVO payBill);
	public boolean checkPayBill(boolean pass,long id);
	public boolean deletePayBill(PayBillVO payBill);
	public PayBillVO findPayBillByID(long id);
	public ArrayList<PayBillVO> findPayBillByTime(Date time);
}
