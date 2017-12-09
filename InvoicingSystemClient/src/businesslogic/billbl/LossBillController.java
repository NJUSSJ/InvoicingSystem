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
		// TODO 自动生成的方法存根
		return lossBillImpl.toLossBillVO(lossBillPO);
	}

	@Override
	public boolean submitLossBill(LossBillVO lossBill) {
		// TODO 自动生成的方法存根
		return lossBillImpl.submitLossBill(lossBill);
	}

	@Override
	public boolean checkLossBill(boolean pass, long id) {
		// TODO 自动生成的方法存根
		return lossBillImpl.checkLossBill(pass, id);
	}

	@Override
	public boolean deleteLossBill(LossBillVO lossBill) {
		// TODO 自动生成的方法存根
		return lossBillImpl.deleteLossBill(lossBill);
	}

	@Override
	public LossBillVO findLossBillByID(long id) {
		// TODO 自动生成的方法存根
		return lossBillImpl.findLossBillByID(id);
	}

	@Override
	public ArrayList<LossBillVO> findLossBillByTime(Date time) {
		// TODO 自动生成的方法存根
		return lossBillImpl.findLossBillByTime(time);
	}

	@Override
	public ArrayList<LossBillVO> findLossBills() {
		// TODO 自动生成的方法存根
		return lossBillImpl.findLossBills();
	}
	
}
