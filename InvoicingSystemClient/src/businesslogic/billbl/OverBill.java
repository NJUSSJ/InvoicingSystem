package businesslogic.billbl;

import businesslogicservice.billblservice.OverBillBLService;
import po.OverBillPO;
import vo.OverBillVO;

public class OverBill extends Bill implements OverBillBLService {
	CommodityList list;
	public OverBillPO makeOverBill(OverBillVO vo){
		return null;
	}
}
