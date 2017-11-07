package businesslogicservice.billblservice;

import businesslogic.billbl.CommodityList;
import vo.WarningBillVO;

public interface WarningBillBLService {
	public WarningBillVO toiBillVO(long id, String user,CommodityList list,int time);
	public String conveyBill(WarningBillVO warningbill);
	public WarningBillVO checkBill(WarningBillVO warninbill);
}
