package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import po.PayBillPO;
import rmi.RemoteHelper;
import vo.PayBillVO;

public class PayBill {

	public PayBillVO toPayBillVO(PayBillPO po) {
		// TODO 自动生成的方法存根
		AccountList list=new AccountList(po.getAccountList());
		return new PayBillVO(po.getID(),po.getUserID(),po.getMemberID(),list,po.getSum(),po.getTime(),po.getState());
	}

	public boolean submitPayBill(PayBillVO payBill) {
		// TODO 自动生成的方法存根
		try {
			return RemoteHelper.getInstance().getPayBillDataService().insert(payBill.toPayBillPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkPayBill(boolean pass, long id) {
		// TODO 自动生成的方法存根
		try {
			PayBillVO vo=toPayBillVO(RemoteHelper.getInstance().getPayBillDataService().findPayBillbyID(id));
			if(pass){
				vo.setState(1);
			}else{
				vo.setState(2);
			}
			return RemoteHelper.getInstance().getPayBillDataService().update(vo.toPayBillPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	public boolean deletePayBill(PayBillVO payBill) {
		// TODO 自动生成的方法存根
		try {
			return RemoteHelper.getInstance().getPayBillDataService().delete(payBill.toPayBillPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	public PayBillVO findPayBillByID(long id) {
		// TODO 自动生成的方法存根
		try {
			return toPayBillVO(RemoteHelper.getInstance().getPayBillDataService().findPayBillbyID(id));
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<PayBillVO> findPayBillByTime(Date time) {
		// TODO 自动生成的方法存根
		ArrayList<PayBillVO> temp=new ArrayList<PayBillVO>();
		try {
			ArrayList<PayBillPO> payBills=RemoteHelper.getInstance().getPayBillDataService().findPayBillbyTime(time);
			for(int i=0;i<payBills.size();i++){
				temp.add(toPayBillVO(payBills.get(i)));
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return temp;
	}
	public ArrayList<PayBillVO> findPayBills(){
		ArrayList<PayBillVO> temp=null;
		try {
			temp=new ArrayList<PayBillVO>();
			ArrayList<PayBillPO> bills=RemoteHelper.getInstance().getPayBillDataService().findPayBills();
			for(int i=0;i<bills.size();i++){
				temp.add(toPayBillVO(bills.get(i)));
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return temp;
	}
	
}
