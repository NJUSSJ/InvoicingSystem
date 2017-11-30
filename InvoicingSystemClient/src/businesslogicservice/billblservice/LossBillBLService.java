package businesslogicservice.billblservice;

import java.sql.Date;

import businesslogic.billbl.CommodityList;
import vo.LossBillVO;

public interface LossBillBLService {
	public LossBillVO toBillVO(long id,long user,long member,CommodityList list,Date time);
	public String conveyBill(LossBillVO lossbill);
	public LossBillVO checkBill(LossBillVO lossbill);
}
