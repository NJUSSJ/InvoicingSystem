package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.billblservice.LossBillBLService;
import po.LossBillPO;
import rmi.RemoteHelper;
import vo.LossBillVO;

public class LossBill{
	public LossBillVO toLossBillVO(LossBillPO lossBillPO) {
		// TODO �Զ����ɵķ������
		CommodityList list=new CommodityList(lossBillPO.getCommodityList());
		return new LossBillVO(lossBillPO.getID(),lossBillPO.getUserID(),list,lossBillPO.getTime(),lossBillPO.getState());
	}
	public boolean submitLossBill(LossBillVO lossBill) {
		// TODO �Զ����ɵķ������
		try {
			return RemoteHelper.getInstance().getLossBillDataService().insert(lossBill.toLossBillPO());
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}
	public boolean checkLossBill(boolean pass, long id) {
		// TODO �Զ����ɵķ������
		
		try {
			LossBillVO vo=toLossBillVO(RemoteHelper.getInstance().getLossBillDataService().findLossBillbyID(id));
			if(pass){
				vo.setState(1);
			}else{
				vo.setState(2);
			}
			return RemoteHelper.getInstance().getLossBillDataService().update(vo.toLossBillPO());
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return pass;
	}
	public boolean deleteLossBill(LossBillVO lossBill) {
		// TODO �Զ����ɵķ������
		try {
			return RemoteHelper.getInstance().getLossBillDataService().delete(lossBill.toLossBillPO());
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}
	public LossBillVO findLossBillByID(long id) {
		// TODO �Զ����ɵķ������
		try {
			return toLossBillVO(RemoteHelper.getInstance().getLossBillDataService().findLossBillbyID(id));
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<LossBillVO> findLossBillByTime(Date time) {
		// TODO �Զ����ɵķ������
		ArrayList<LossBillVO> temp=null;
		try {
			temp=new ArrayList<LossBillVO>();
			ArrayList<LossBillPO> lossBills=RemoteHelper.getInstance().getLossBillDataService().findLossBillbyTime(time);
			for(int i=0;i<lossBills.size();i++){
				temp.add(toLossBillVO(lossBills.get(i)));
			}
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return temp;
	}
	
}
