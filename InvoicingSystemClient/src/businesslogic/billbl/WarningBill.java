package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import po.WarningBillPO;
import rmi.RemoteHelper;
import vo.WarningBillVO;

public class WarningBill{
	public WarningBillVO toWarningBillVO(WarningBillPO po) {
		if(po==null){
			return null;
		}
		return new WarningBillVO(po.getID(),po.getUserID(),new CommodityList(po.getCommodityList()),
				po.getTime(),po.getState());
	}
	public boolean submitWarningBill(WarningBillVO warningBill) {
		try {
			return RemoteHelper.getInstance().getWarningBillDataService().insert(warningBill.toWarningBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean checkWarningBill(boolean pass, long id) {
		try {
			WarningBillVO vo=toWarningBillVO(RemoteHelper.getInstance().getWarningBillDataService().findWarningBillbyID(id));
			if(pass){
				vo.setState(1);
			}else{
				vo.setState(2);
			}
			return RemoteHelper.getInstance().getWarningBillDataService().update(vo.toWarningBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteWarningBill(WarningBillVO warningBill) {
		try {
			return RemoteHelper.getInstance().getWarningBillDataService().delete(warningBill.toWarningBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 根据id查找报警单
	 */
	public WarningBillVO findWarningBillByID(long id) {
		try {
			return toWarningBillVO(RemoteHelper.getInstance().getWarningBillDataService().findWarningBillbyID(id));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据时间查找报警单
	 */
	public ArrayList<WarningBillVO> findWarningBillByTime(Date time) {
		ArrayList<WarningBillVO> temp=new ArrayList<WarningBillVO>();
		try {
			ArrayList<WarningBillPO> warningBills=RemoteHelper.getInstance().getWarningBillDataService().findWarningBillbyTime(time);
			for(int i=0;i<warningBills.size();i++){
				temp.add(toWarningBillVO(warningBills.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return temp;
	}
	/**
	 * 查找所有报警单
	 */
	public ArrayList<WarningBillVO> findWarningBills(){
		ArrayList<WarningBillVO> temp=null;
		try {
			temp=new ArrayList<WarningBillVO>();
			ArrayList<WarningBillPO> bills=RemoteHelper.getInstance().getWarningBillDataService().findWarningBills();
			for(int i=0;i<bills.size();i++){
				temp.add(toWarningBillVO(bills.get(i)));
			}	
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return temp;
	}
	/**
	 * 根据状态查找报警单
	 */
	public ArrayList<WarningBillVO> findWarningBillsByState(int state){
		ArrayList<WarningBillVO> result=new ArrayList<WarningBillVO>();
		try {
			ArrayList<WarningBillPO> bills=RemoteHelper.getInstance().getWarningBillDataService().findWarningBillbyState(state);
			if(bills.isEmpty()) return result;
			for(WarningBillPO po:bills){
				result.add(toWarningBillVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 根据操作员id查找报警单
	 */
	public ArrayList<WarningBillVO> findWarningBillsByUser(long userid){
		ArrayList<WarningBillVO> result=new ArrayList<WarningBillVO>();
		try {
			ArrayList<WarningBillPO> bills=RemoteHelper.getInstance().getWarningBillDataService().findWarningBillbyUser(userid);
			for(WarningBillPO po:bills){
				result.add(toWarningBillVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 从邮箱中删除报警单
	 */
	public boolean fakeDelete(long id){
		WarningBillVO vo=findWarningBillByID(id);
		vo.setState(vo.getState()+2);
		try {
			return RemoteHelper.getInstance().getWarningBillDataService().update(vo.toWarningBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
}
