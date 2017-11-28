package businesslogic.billbl;

import java.sql.Date;

import businesslogicservice.billblservice.ReceiveBillBLService;
import vo.ReceiveBillVO;

public class ReceiveBill  implements ReceiveBillBLService{

	ReceiveBillVO receivebill;

	@Override
	public ReceiveBillVO toBillVO(String id, long user, long member, int sum, Date time) {
		// TODO Auto-generated method stub
		receivebill=new ReceiveBillVO(id, user, member, sum, time);
		return receivebill;
	}

	@Override
	public String conveyBill(ReceiveBillVO paybill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReceiveBillVO checkBill(ReceiveBillVO paybill) {
		// TODO Auto-generated method stub
		return null;
	}
	
	


}
