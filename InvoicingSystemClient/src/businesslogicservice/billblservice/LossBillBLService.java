package businesslogicservice.billblservice;

import java.sql.Date;
import java.util.ArrayList;

import po.LossBillPO;
import vo.LossBillVO;

public interface LossBillBLService {
	public LossBillVO toLossBillVO(LossBillPO lossBillPO);
	public boolean submitLossBill(LossBillVO lossBill);
	public boolean checkLossBill(boolean pass,long id);
	public boolean deleteLossBill(LossBillVO lossBill);
	public LossBillVO findLossBillByID(long id);
	public ArrayList<LossBillVO> findLossBillByTime(Date time);
	public ArrayList<LossBillVO> findLossBills();
	public ArrayList<LossBillVO> findLossBillsByInterval(Date begin,Date end);
	public ArrayList<LossBillVO> findLossBillsByField(Date begin,Date end,String userName);
	public ArrayList<LossBillVO> findLossBillsByState(int state);
}
