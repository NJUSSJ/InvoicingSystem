package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.billblservice.CashBillBLService;
import po.CashBillPO;
import rmi.RemoteHelper;
import vo.CashBillVO;

public class CashBillController implements CashBillBLService{

	@Override
	public CashBillVO toCashBillVO(CashBillPO po) {
		// TODO 自动生成的方法存根
		String[] items=po.getItems().split(" ");
		ArrayList<String> temp=new ArrayList<String>();
		for(int i=0;i<items.length;i++){
			temp.add(items[i]);
		}
		
		return new CashBillVO(po.getID(),po.getUserID(),po.getAccountID(),temp,po.getTime(),
				po.getState());
	}

	@Override
	public boolean submitCashBill(CashBillVO cashbill) {
		// TODO 自动生成的方法存根
		try {
			return RemoteHelper.getInstance().getCashBillPromotinoDataService().insert(cashbill.toCashBillPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean checkCashBill(boolean pass) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean deleteCashBill(CashBillVO cashbill) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public ArrayList<CashBillVO> findCashBillByTime(Date time) {
		// TODO 自动生成的方法存根
		return null;
	}
	

}
