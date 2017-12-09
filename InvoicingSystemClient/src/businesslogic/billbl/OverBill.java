package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import po.OverBillPO;
import rmi.RemoteHelper;
import vo.OverBillVO;

public class OverBill{

	public OverBillVO toOverBillVO(OverBillPO overBillPO) {
		// TODO �Զ����ɵķ������
		CommodityList list=new CommodityList(overBillPO.getCommodityList());
		return new OverBillVO(overBillPO.getID(),overBillPO.getUserID(),list,overBillPO.getTime(),
				overBillPO.getState());
	}
	public boolean submitOverBill(OverBillVO overBill) {
		// TODO �Զ����ɵķ������
		try {
			return RemoteHelper.getInstance().getOverBillDataService().insert(overBill.toOverBillPO());
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}
	public boolean checkOverBill(boolean pass, long id) {
		// TODO �Զ����ɵķ������
		try {
			OverBillVO vo=toOverBillVO(RemoteHelper.getInstance().getOverBillDataService().findOverBillbyID(id));
			if(pass){
				vo.setState(1);
			}else{
				vo.setState(2);
			}
			return RemoteHelper.getInstance().getOverBillDataService().update(vo.toOverBillPO());
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return pass;
	}
	public boolean deleteOverBill(OverBillVO overBill) {
		// TODO �Զ����ɵķ������
		try {
			return RemoteHelper.getInstance().getOverBillDataService().delete(overBill.toOverBillPO());
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}
	public OverBillVO findOverBillByID(long id) {
		// TODO �Զ����ɵķ������
		try {
			return toOverBillVO(RemoteHelper.getInstance().getOverBillDataService().findOverBillbyID(id));
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<OverBillVO> findOverBillByTime(Date time) {
		// TODO �Զ����ɵķ������
		ArrayList<OverBillVO> temp=new ArrayList<OverBillVO>();
		try {
			ArrayList<OverBillPO> overBills=RemoteHelper.getInstance().getOverBillDataService().findOverBillbyTime(time);
			for(int i=0;i<overBills.size();i++){
				temp.add(toOverBillVO(overBills.get(i)));
			}
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return temp;
	}
	public ArrayList<OverBillVO> findOverBills(){
		ArrayList<OverBillVO> temp=null;
		try {
			temp=new ArrayList<OverBillVO>();
			ArrayList<OverBillPO> bills=RemoteHelper.getInstance().getOverBillDataService().findOverBills();
			for(int i=0;i<bills.size();i++){
				temp.add(toOverBillVO(bills.get(i)));
			}
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return temp;
	}
	
}
