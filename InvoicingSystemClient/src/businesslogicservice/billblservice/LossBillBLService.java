package businesslogicservice.billblservice;

import businesslogic.billbl.CommodityList;
import vo.LossBillVO;

public interface LossBillBLService {
	public LossBillVO toBillVO(long id,String user,String member,CommodityList list,int time);
	public String conveyBill(LossBillVO lossbill);
	public LossBillVO checkBill(LossBillVO lossbill);
}
