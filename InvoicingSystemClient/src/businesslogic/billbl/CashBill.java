package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import po.CashBillPO;
import rmi.RemoteHelper;
import vo.CashBillVO;

public class CashBill{
	public CashBillVO toCashBillVO(CashBillPO po) {
		// TODO �Զ����ɵķ������
		String[] items=po.getItems().split(" ");
		ArrayList<String> temp=new ArrayList<String>();
		for(int i=0;i<items.length;i++){
			temp.add(items[i]);
		}
		
		return new CashBillVO(po.getID(),po.getUserID(),po.getAccountID(),temp,po.getTime(),
				po.getState());
	}
	public boolean submitCashBill(CashBillVO cashBill) {
		// TODO �Զ����ɵķ������
		try {
			return RemoteHelper.getInstance().getCashBillPromotinoDataService().insert(cashBill.toCashBillPO());
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}
	public boolean checkCashBill(boolean pass,long id) {
		try {
			CashBillVO cashBillVO=toCashBillVO(RemoteHelper.getInstance().
				getCashBillPromotinoDataService().findCashBillbyID(id));
			if(pass){
			cashBillVO.setState(1);
			}else{
			cashBillVO.setState(2);
			}
			return RemoteHelper.getInstance().getCashBillPromotinoDataService().update(cashBillVO.toCashBillPO());
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteCashBill(CashBillVO cashBill) {
		// TODO �Զ����ɵķ������
		try {
			return RemoteHelper.getInstance().getCashBillPromotinoDataService().delete(cashBill.toCashBillPO());
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}
	public ArrayList<CashBillVO> findCashBillByTime(Date time) {
		// TODO �Զ����ɵķ������
		ArrayList<CashBillVO> temp=null;
		
		try {
			temp=new ArrayList<CashBillVO>();
			ArrayList<CashBillPO> cashBills;
			cashBills = RemoteHelper.getInstance().
			getCashBillPromotinoDataService().findCashBillbyTime(time);
			for(int i=0;i<cashBills.size();i++){
				temp.add(toCashBillVO(cashBills.get(i)));
			}
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return temp;
		
	}

	
	
	
}
