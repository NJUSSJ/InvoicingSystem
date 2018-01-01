package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import po.LossBillPO;
import rmi.RemoteHelper;
import vo.CashBillVO;
import vo.LossBillVO;

public class LossBill{
	public LossBillVO toLossBillVO(LossBillPO lossBillPO) {
		if(lossBillPO==null){
			return null;
		}
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
		if(bills==null)return null;
		ArrayList<LossBillVO> result=new ArrayList<LossBillVO>();
		for(LossBillVO each:bills){
			if(each.getTime().after(begin)&&each.getTime().before(end)){
				if(each.getState()==1||each.getState()==3){
					result.add(each);
				}
			}
		}
		return bills;
	}
	public ArrayList<LossBillVO> findLossBillsByField(Date begin,Date end,String userName){
		ArrayList<LossBillVO> result=new ArrayList<LossBillVO>();
		try {
			ArrayList<LossBillPO> bills=RemoteHelper.getInstance().getLossBillDataService().findLossBillbyField(userName);
			if(bills==null)return null;
			for(LossBillPO po:bills){
				if(po.getTime().before(end)&&(po.getTime().after(begin))){
					if(po.getState()==1||po.getState()==3){
						result.add(toLossBillVO(po));
					}
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<LossBillVO> findLossBillsByState(int state){
		ArrayList<LossBillVO> result=new ArrayList<LossBillVO>();
		ArrayList<LossBillPO> bills;
		try {
			bills = RemoteHelper.getInstance().getLossBillDataService().findLossBillbyState(state);
			for(LossBillPO po:bills){
				result.add(toLossBillVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<LossBillVO> findLossBillsByUser(long userid){
		ArrayList<LossBillVO> result=new ArrayList<LossBillVO>();
		try {
			ArrayList<LossBillPO> bills=RemoteHelper.getInstance().getLossBillDataService().findLossBillbyUser(userid);
			for(LossBillPO po:bills){
				result.add(toLossBillVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	public boolean fakeDelete(long id){
		LossBillVO vo=findLossBillByID(id);
		vo.setState(vo.getState()+2);
		try {
			return RemoteHelper.getInstance().getLossBillDataService().update(vo.toLossBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
}
