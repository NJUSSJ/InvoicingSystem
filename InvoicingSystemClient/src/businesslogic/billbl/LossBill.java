package businesslogic.billbl;

import java.sql.Date;

import businesslogicservice.billblservice.LossBillBLService;
import po.LossBillPO;
import vo.LossBillVO;

public class LossBill  implements LossBillBLService {

	@Override
	public LossBillVO toLossBillVO(LossBillPO lossBillPO) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean submitLossBill(LossBillVO lossBill) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean checkLossBill(boolean pass, long id) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean deleteLossBill(LossBillVO lossBill) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public LossBillVO findLossBillByID(long id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public LossBillVO findLossBillByTime(Date time) {
		// TODO 自动生成的方法存根
		return null;
	}
	
}
