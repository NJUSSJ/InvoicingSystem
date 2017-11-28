package businesslogicservice.billblservice;

import java.sql.Date;

import businesslogic.billbl.CommodityList;
import vo.OverBillVO;

public interface OverBillBLService {
	public OverBillVO toBillVO(long id,long userid,long memberid,CommodityList list,Date time);
	public String conveyBill(OverBillVO overbill);
	public OverBillVO checkBill(OverBillVO overbill);
}
