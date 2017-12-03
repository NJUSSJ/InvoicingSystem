package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.billblservice.WarningBillBLService;
import po.PayBillPO;
import po.WarningBillPO;
import rmi.RemoteHelper;
import vo.PayBillVO;
import vo.WarningBillVO;

public class WarningBill implements WarningBillBLService {

	@Override
	public WarningBillVO toWarningBillVO(WarningBillPO po) {
		// TODO 自动生成的方法存根
		return new WarningBillVO(po.getID(),po.getUserID(),new CommodityList(po.getCommodityList()),
				po.getTime(),po.getState());
	}

	@Override
	public boolean submitWarningBill(WarningBillVO warningBill) {
		// TODO 自动生成的方法存根
		try {
			return RemoteHelper.getInstance().getWarningBillDataService().insert(warningBill.toWarningBillPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean checkWarningBill(boolean pass, long id) {
		// TODO 自动生成的方法存根
		try {
			WarningBillVO vo=toWarningBillVO(RemoteHelper.getInstance().getWarningBillDataService().findWarningBillbyID(id));
			if(pass){
				vo.setState(1);
			}else{
				vo.setState(2);
			}
			return RemoteHelper.getInstance().getWarningBillDataService().update(vo.toWarningBillPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteWarningBill(WarningBillVO warningBill) {
		// TODO 自动生成的方法存根
		try {
			return RemoteHelper.getInstance().getWarningBillDataService().delete(warningBill.toWarningBillPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public WarningBillVO findWarningBillByID(long id) {
		// TODO 自动生成的方法存根
		try {
			return toWarningBillVO(RemoteHelper.getInstance().getWarningBillDataService().findWarningBillbyID(id));
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<WarningBillVO> findWarningBillByTime(Date time) {
		// TODO 自动生成的方法存根
		ArrayList<WarningBillVO> temp=new ArrayList<WarningBillVO>();
		try {
			ArrayList<WarningBillPO> warningBills=RemoteHelper.getInstance().getWarningBillDataService().findWarningBillbyTime(time);
			for(int i=0;i<warningBills.size();i++){
				temp.add(toWarningBillVO(warningBills.get(i)));
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return temp;
	}

	
	
}
