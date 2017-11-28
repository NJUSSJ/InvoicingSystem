package businesslogic.billbl;

import businesslogicservice.billblservice.LossBillBLService;
import vo.LossBillVO;

public class LossBill  implements LossBillBLService {
	CommodityList lossList;
	LossBillVO lossbill;
	
	@Override
	public String conveyBill(LossBillVO lossbill) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public LossBillVO checkBill(LossBillVO lossbill) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public LossBillVO toBillVO(long id, long user, String member, CommodityList list,int time) {
		// TODO Auto-generated method stub
		lossbill=new LossBillVO(id, user, list, time);
		return lossbill;
	}
	
	
}
