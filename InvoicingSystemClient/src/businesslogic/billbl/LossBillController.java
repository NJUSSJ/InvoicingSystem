package businesslogic.billbl;

import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.billblservice.LossBillBLService;
import po.LossBillPO;
import vo.LossBillVO;

public class LossBillController implements LossBillBLService{
	LossBill lossBillImpl=new LossBill();
	@Override
	public LossBillVO toLossBillVO(LossBillPO lossBillPO) {
		// TODO �Զ����ɵķ������
		return lossBillImpl.toLossBillVO(lossBillPO);
	}

	@Override
	public boolean submitLossBill(LossBillVO lossBill) {
		// TODO �Զ����ɵķ������
		return lossBillImpl.submitLossBill(lossBill);
	}

	@Override
	public boolean checkLossBill(boolean pass, long id) {
		// TODO �Զ����ɵķ������
		return lossBillImpl.checkLossBill(pass, id);
	}

	@Override
	public boolean deleteLossBill(LossBillVO lossBill) {
		// TODO �Զ����ɵķ������
		return lossBillImpl.deleteLossBill(lossBill);
	}

	@Override
	public LossBillVO findLossBillByID(long id) {
		// TODO �Զ����ɵķ������
		return lossBillImpl.findLossBillByID(id);
	}

	@Override
	public ArrayList<LossBillVO> findLossBillByTime(Date time) {
		// TODO �Զ����ɵķ������
		return lossBillImpl.findLossBillByTime(time);
	}

	@Override
	public ArrayList<LossBillVO> findLossBills() {
		// TODO �Զ����ɵķ������
		return lossBillImpl.findLossBills();
	}
	
}
