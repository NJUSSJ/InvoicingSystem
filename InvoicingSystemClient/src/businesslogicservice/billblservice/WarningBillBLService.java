package businesslogicservice.billblservice;

import java.sql.Date;

import businesslogic.billbl.CommodityList;
import vo.WarningBillVO;

public interface WarningBillBLService {
	public WarningBillVO toBillVO(long id, long user,CommodityList list,Date time);
	public String conveyBill(WarningBillVO warningbill);
	public WarningBillVO checkBill(WarningBillVO warninbill);
}
