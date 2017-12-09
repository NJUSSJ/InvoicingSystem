package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import po.OverBillPO;
import rmi.RemoteHelper;
import vo.OverBillVO;

public class OverBill{

	public OverBillVO toOverBillVO(OverBillPO overBillPO) {
		// TODO 自动生成的方法存根
		CommodityList list=new CommodityList(overBillPO.getCommodityList());
		return new OverBillVO(overBillPO.getID(),overBillPO.getUserID(),list,overBillPO.getTime(),
				overBillPO.getState());
	}
	public boolean submitOverBill(OverBillVO overBill) {
		// TODO 自动生成的方法存根
		try {
			return RemoteHelper.getInstance().getOverBillDataService().insert(overBill.toOverBillPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	public boolean checkOverBill(boolean pass, long id) {
		// TODO 自动生成的方法存根
		try {
			OverBillVO vo=toOverBillVO(RemoteHelper.getInstance().getOverBillDataService().findOverBillbyID(id));
			if(pass){
				vo.setState(1);
			}else{
				vo.setState(2);
			}
			return RemoteHelper.getInstance().getOverBillDataService().update(vo.toOverBillPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return pass;
	}
	public boolean deleteOverBill(OverBillVO overBill) {
		// TODO 自动生成的方法存根
		try {
			return RemoteHelper.getInstance().getOverBillDataService().delete(overBill.toOverBillPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	public OverBillVO findOverBillByID(long id) {
		// TODO 自动生成的方法存根
		try {
			return toOverBillVO(RemoteHelper.getInstance().getOverBillDataService().findOverBillbyID(id));
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<OverBillVO> findOverBillByTime(Date time) {
		// TODO 自动生成的方法存根
		ArrayList<OverBillVO> temp=new ArrayList<OverBillVO>();
		try {
			ArrayList<OverBillPO> overBills=RemoteHelper.getInstance().getOverBillDataService().findOverBillbyTime(time);
			for(int i=0;i<overBills.size();i++){
				temp.add(toOverBillVO(overBills.get(i)));
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return temp;
	}
	
}
