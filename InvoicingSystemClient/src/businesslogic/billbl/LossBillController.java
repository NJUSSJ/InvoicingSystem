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
		return lossBillImpl.toLossBillVO(lossBillPO);
	}

	@Override
	public boolean submitLossBill(LossBillVO lossBill) {
		return lossBillImpl.submitLossBill(lossBill);
	}

	@Override
	public boolean checkLossBill(boolean pass, long id) {
		return lossBillImpl.checkLossBill(pass, id);
	}

	@Override
	public boolean deleteLossBill(LossBillVO lossBill) {
		return lossBillImpl.deleteLossBill(lossBill);
	}

	@Override
	public LossBillVO findLossBillByID(long id) {
		return lossBillImpl.findLossBillByID(id);
	}

	@Override
	public ArrayList<LossBillVO> findLossBillByTime(Date time) {
		return lossBillImpl.findLossBillByTime(time);
	}

	@Override
	public ArrayList<LossBillVO> findLossBills() {
		return lossBillImpl.findLossBills();
	}

	@Override
	public ArrayList<LossBillVO> findLossBillsByInterval(Date begin, Date end) {
		return lossBillImpl.findLossBillsByInterval(begin, end);
	}

	@Override
	public ArrayList<LossBillVO> findLossBillsByField(Date begin, Date end, String userName) {
		return lossBillImpl.findLossBillsByField(begin, end, userName);
	}

	@Override
	public ArrayList<LossBillVO> findLossBillsByState(int state) {
		return lossBillImpl.findLossBillsByState(state);
	}

	@Override
	public ArrayList<LossBillVO> findLossBillsByUser(long id) {
		return lossBillImpl.findLossBillsByUser(id);
	}

	@Override
	public boolean fakeDelete(long id) {
		return lossBillImpl.fakeDelete(id);
	}
	
}
