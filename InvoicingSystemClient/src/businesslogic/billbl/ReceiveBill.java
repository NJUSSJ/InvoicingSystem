package businesslogic.billbl;

import businesslogicservice.billblservice.ReceiveBillBLService;
import vo.ReceiveBillVO;

public class ReceiveBill  implements ReceiveBillBLService{

	ReceiveBillVO receivebill;

	@Override
	public ReceiveBillVO toBillVO(long id, String user, String member, int sum, int time) {
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
