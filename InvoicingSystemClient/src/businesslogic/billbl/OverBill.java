package businesslogic.billbl;

import businesslogicservice.billblservice.OverBillBLService;
import vo.OverBillVO;

public class OverBill  implements OverBillBLService {
	CommodityList overList;
	OverBillVO overbill;
	@Override
	public OverBillVO toBillVO(long id, String user, String member, CommodityList list, int time) {
		// TODO Auto-generated method stub
		overbill=new OverBillVO(id, user, list, time);
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

	
}
