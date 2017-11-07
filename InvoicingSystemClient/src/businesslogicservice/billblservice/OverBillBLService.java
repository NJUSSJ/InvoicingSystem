package businesslogicservice.billblservice;

import businesslogic.billbl.CommodityList;
import vo.OverBillVO;

public interface OverBillBLService {
	public OverBillVO toBillVO(long id,String user,String member,CommodityList list,int time);
	public String conveyBill(OverBillVO overbill);
	public OverBillVO checkBill(OverBillVO overbill);
}
