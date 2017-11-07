package businesslogic.billbl;

import businesslogicservice.billblservice.CashBillBLService;
import vo.CashBillVO;

public class CashBill implements CashBillBLService{

	CashBillVO cashbill;


	@Override
	public CashBillVO toBillVO(long id, String user, String member, int sum, int time) {
		// TODO Auto-generated method stub
		cashbill=new CashBillVO(id, user, member, time);
		return cashbill;
	}

	@Override
	public String conveyBill(CashBillVO cashbill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CashBillVO checkBill(CashBillVO cashbill) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
