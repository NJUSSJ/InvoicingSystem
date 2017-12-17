package businesslogicservice.billblservice;

import java.sql.Date;
import java.util.ArrayList;

import po.ReceiveBillPO;
import vo.ReceiveBillVO;

public interface ReceiveBillBLService {
	public ReceiveBillVO toReceiveBillVO(ReceiveBillPO po);
	public boolean submitReceiveBill(ReceiveBillVO receiveBill);
	public boolean checkReceiveBill(boolean pass,long id);
	public boolean deleteReceiveBill(ReceiveBillVO payBill);
	public ReceiveBillVO findReceiveBillByID(long id);
	public ArrayList<ReceiveBillVO> findReceiveBillByTime(Date time);
	public ArrayList<ReceiveBillVO> findReceiveBills();
	public ArrayList<ReceiveBillVO> findReceiveBillsByInterval(Date begin,Date end);
	public ArrayList<ReceiveBillVO> findReceiveBillsByField(Date begin,Date end,String memberName,String userName);
	public ArrayList<ReceiveBillVO> findReceiveBillsByState(int state);
}
