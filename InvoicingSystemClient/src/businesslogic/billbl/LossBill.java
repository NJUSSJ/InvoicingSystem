package businesslogic.billbl;

import java.sql.Date;

import businesslogicservice.billblservice.LossBillBLService;
import po.LossBillPO;
import vo.LossBillVO;

public class LossBill  implements LossBillBLService {

	@Override
	public LossBillVO toLossBillVO(LossBillPO lossBillPO) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public boolean submitLossBill(LossBillVO lossBill) {
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public boolean checkLossBill(boolean pass, long id) {
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public boolean deleteLossBill(LossBillVO lossBill) {
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public LossBillVO findLossBillByID(long id) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public LossBillVO findLossBillByTime(Date time) {
		// TODO �Զ����ɵķ������
		return null;
	}
	
}
