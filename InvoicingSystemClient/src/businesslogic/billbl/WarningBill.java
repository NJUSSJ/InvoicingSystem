package businesslogic.billbl;

import java.sql.Date;

import businesslogicservice.billblservice.WarningBillBLService;
import vo.WarningBillVO;

public class WarningBill implements WarningBillBLService {

	WarningBillVO warningbill;
	@Override
	public WarningBillVO toBillVO(long id, long user, CommodityList list, Date time) {
		// TODO Auto-generated method stub
		warningbill=new WarningBillVO(id, user, list, time);
		return warningbill;
	}

	@Override
	public String conveyBill(WarningBillVO warningbill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WarningBillVO checkBill(WarningBillVO warninbill) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
