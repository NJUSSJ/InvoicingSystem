package businesslogicservice.billblservice;

import java.sql.Date;

import po.ReceiveBillPO;
import vo.ReceiveBillVO;

public interface ReceiveBillBLService {
	public ReceiveBillVO toReceiveBillVO(ReceiveBillPO po);
	public String conveyBill(ReceiveBillVO paybill);
	public ReceiveBillVO checkBill(ReceiveBillVO paybill);
}
