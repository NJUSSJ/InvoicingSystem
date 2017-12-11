 package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import businesslogic.commoditybl.CommodityController;
import po.SaleBillPO;
import rmi.RemoteHelper;
import vo.CommodityVO;
import vo.SaleBillVO;

public class SaleBill{

	public SaleBillVO toSaleBillVO(SaleBillPO po) {
		// TODO �Զ����ɵķ������
		CommodityList list=new CommodityList(po.getCommodityList());
		return new SaleBillVO(po.getID(),po.getUserID(),po.getMemberID(),list,po.getSum(),po.getState(),
				po.getTime(),po.getRemark());
	}
	public boolean submitSaleBill(SaleBillVO saleBill) {
		// TODO �Զ����ɵķ������
		try {
			return RemoteHelper.getInstance().getSaleBillDataService().insert(saleBill.toSaleBillPO());
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}
	public boolean checkSaleBill(boolean pass, long id) {
		// TODO �Զ����ɵķ������
		try {
			SaleBillVO vo=toSaleBillVO(RemoteHelper.getInstance().getSaleBillDataService().findSaleBillbyID(id));
			if(pass){
				vo.setState(1);
			}else{
				vo.setState(2);
			}
			return RemoteHelper.getInstance().getSaleBillDataService().update(vo.toSaleBillPO());
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteSaleBill(SaleBillVO saleBill) {
		// TODO �Զ����ɵķ������
		try {
			return RemoteHelper.getInstance().getSaleBillDataService().delete(saleBill.toSaleBillPO());
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}
	public SaleBillVO findSaleBillByID(long id) {
		// TODO �Զ����ɵķ������
		try {
			return toSaleBillVO(RemoteHelper.getInstance().getSaleBillDataService().findSaleBillbyID(id));
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<SaleBillVO> findSaleBillByTime(Date time) {
		// TODO �Զ����ɵķ������
		ArrayList<SaleBillVO> temp=new ArrayList<SaleBillVO>();
		try {
			ArrayList<SaleBillPO> saleBills=RemoteHelper.getInstance().getSaleBillDataService().
					findSaleBillbyTime(time);
			for(int i=0;i<saleBills.size();i++){
				temp.add(toSaleBillVO(saleBills.get(i)));
			}
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return temp;
	}
	public ArrayList<SaleBillVO> findSaleBills(){
		ArrayList<SaleBillVO> temp=null;
		try {
			temp=new ArrayList<SaleBillVO>();
			ArrayList<SaleBillPO> bills=RemoteHelper.getInstance().getSaleBillDataService().findSaleBills();
			for(int i=0;i<bills.size();i++){
				temp.add(toSaleBillVO(bills.get(i)));
			}
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return temp;
	}
}
