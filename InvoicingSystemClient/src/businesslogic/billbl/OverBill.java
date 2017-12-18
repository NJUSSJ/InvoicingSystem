package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import po.CashBillPO;
import po.OverBillPO;
import rmi.RemoteHelper;
import vo.CashBillVO;
import vo.ImportBillVO;
import vo.OverBillVO;

public class OverBill{

	public OverBillVO toOverBillVO(OverBillPO overBillPO) {
		if(overBillPO==null){
			return null;
		}
		return new OverBillVO(overBillPO.getID(),overBillPO.getUserID(),overBillPO.getCommodityName(),overBillPO.getTime(),
				overBillPO.getState(),overBillPO.getNum(),overBillPO.getSum());
	}
	public boolean submitOverBill(OverBillVO overBill) {
		try {
			return RemoteHelper.getInstance().getOverBillDataService().insert(overBill.toOverBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean checkOverBill(boolean pass, long id) {
		try {
			OverBillVO vo=toOverBillVO(RemoteHelper.getInstance().getOverBillDataService().findOverBillbyID(id));
			if(pass){
				vo.setState(1);
			}else{
				vo.setState(2);
			}
			return RemoteHelper.getInstance().getOverBillDataService().update(vo.toOverBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return pass;
	}
	public boolean deleteOverBill(OverBillVO overBill) {
		try {
			return RemoteHelper.getInstance().getOverBillDataService().delete(overBill.toOverBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	public OverBillVO findOverBillByID(long id) {
		try {
			return toOverBillVO(RemoteHelper.getInstance().getOverBillDataService().findOverBillbyID(id));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<OverBillVO> findOverBillByTime(Date time) {
		ArrayList<OverBillVO> temp=new ArrayList<OverBillVO>();
		try {
			ArrayList<OverBillPO> overBills=RemoteHelper.getInstance().getOverBillDataService().findOverBillbyTime(time);
			for(int i=0;i<overBills.size();i++){
				temp.add(toOverBillVO(overBills.get(i)));
			}
		} catch (RemoteException e) {
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
			e.printStackTrace();
		}
		return temp;
	}
	public ArrayList<OverBillVO> findOverBillsByInterval(Date begin,Date end){
		ArrayList<OverBillVO> bills=findOverBills();
		ArrayList<OverBillVO> result=new ArrayList<OverBillVO>();
		for(OverBillVO each:bills){
			if(each.getTime().after(begin)&&each.getTime().before(end)){
				result.add(each);
			}
		}
		return bills;
	}
	public ArrayList<OverBillVO> findOverBillsByField(Date begin,Date end,String userName){
		ArrayList<OverBillVO> result=new ArrayList<OverBillVO>();
		ArrayList<OverBillPO> bills;
		try {
			bills = RemoteHelper.getInstance().getOverBillDataService().findOverBillbyField(userName);
			for(OverBillPO po:bills){
				result.add(toOverBillVO(po));
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<OverBillVO> findOverBillsByState(int state){
		ArrayList<OverBillVO> result=new ArrayList<OverBillVO>();
		ArrayList<OverBillPO> bills;
		try {
			bills = RemoteHelper.getInstance().getOverBillDataService().findOverBillbyState(state);
			for(OverBillPO po:bills){
				result.add(toOverBillVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
}
