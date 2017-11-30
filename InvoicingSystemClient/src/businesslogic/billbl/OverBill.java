package businesslogic.billbl;

import java.sql.Date;

import businesslogicservice.billblservice.OverBillBLService;
import vo.OverBillVO;

public class OverBill  implements OverBillBLService {
	CommodityList overList;
	OverBillVO overbill;
	@Override
	public OverBillVO toBillVO(long id, long userid, long memberid, CommodityList list, Date time) {
		// TODO Auto-generated method stub
		overbill=new OverBillVO(id, userid, list, time);
		return overbill;
	}
	@Override
	public String conveyBill(OverBillVO overbill) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public OverBillVO checkBill(OverBillVO overbill) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateMember() {
		
	}
	
	public void updateAccount() {
		
	}
}
