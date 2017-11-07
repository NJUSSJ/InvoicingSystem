package businesslogic.billbl;

import businesslogicservice.billblservice.PayBillBLService;
import vo.PayBillVO;

public class PayBill  implements PayBillBLService{

	PayBillVO paybill;

	@Override
	public PayBillVO toBillVO(long id, String user, String member, int sum, int time) {
		// TODO Auto-generated method stub
		paybill=new PayBillVO(id, user, member, sum, time);
		return paybill;
	}

	@Override
	public String conveyBill(PayBillVO paybill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PayBillVO checkBill(PayBillVO paybill) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
