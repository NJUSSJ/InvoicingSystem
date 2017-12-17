package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import po.LossBillPO;
import rmi.RemoteHelper;
import vo.ImportBillVO;
import vo.LossBillVO;

public class LossBill{
	public LossBillVO toLossBillVO(LossBillPO lossBillPO) {
		return new LossBillVO(lossBillPO.getID(),lossBillPO.getUserID(),lossBillPO.getName(),lossBillPO.getTime(),lossBillPO.getState(),lossBillPO.getNum(),lossBillPO.getSum());
	}
	public boolean submitLossBill(LossBillVO lossBill) {
		try {
			return RemoteHelper.getInstance().getLossBillDataService().insert(lossBill.toLossBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean checkLossBill(boolean pass, long id) {
		try {
			LossBillVO vo=toLossBillVO(RemoteHelper.getInstance().getLossBillDataService().findLossBillbyID(id));
			if(pass){
				vo.setState(1);
			}else{
				vo.setState(2);
			}
			return RemoteHelper.getInstance().getLossBillDataService().update(vo.toLossBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return pass;
	}
	public boolean deleteLossBill(LossBillVO lossBill) {
		try {
			return RemoteHelper.getInstance().getLossBillDataService().delete(lossBill.toLossBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	public LossBillVO findLossBillByID(long id) {
		try {
			return toLossBillVO(RemoteHelper.getInstance().getLossBillDataService().findLossBillbyID(id));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<LossBillVO> findLossBillByTime(Date time) {
		ArrayList<LossBillVO> temp=null;
		try {
			temp=new ArrayList<LossBillVO>();
			ArrayList<LossBillPO> lossBills=RemoteHelper.getInstance().getLossBillDataService().findLossBillbyTime(time);
			for(int i=0;i<lossBills.size();i++){
				temp.add(toLossBillVO(lossBills.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return temp;
	}
	public ArrayList<LossBillVO> findLossBills(){
		ArrayList<LossBillVO> temp=null;
		try {
			temp=new ArrayList<LossBillVO>();
			ArrayList<LossBillPO> bills=RemoteHelper.getInstance().getLossBillDataService().findLossBills();
			for(int i=0;i<bills.size();i++){
				temp.add(toLossBillVO(bills.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return temp;
	}
	public ArrayList<LossBillVO> findLossBillsByInterval(Date begin,Date end){
		ArrayList<LossBillVO> bills=findLossBills();
		ArrayList<LossBillVO> result=new ArrayList<LossBillVO>();
		for(LossBillVO each:bills){
			if(each.getTime().after(begin)&&each.getTime().before(end)){
				result.add(each);
			}
		}
		return bills;
	}
	public ArrayList<LossBillVO> findLossBillsByField(Date begin,Date end,String userName){
		return null;
	}
	
}
