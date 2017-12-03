package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.billblservice.ReceiveBillBLService;
import po.PayBillPO;
import po.ReceiveBillPO;
import rmi.RemoteHelper;
import vo.PayBillVO;
import vo.ReceiveBillVO;

public class ReceiveBill{

	public ReceiveBillVO toReceiveBillVO(ReceiveBillPO po) {
		// TODO 自动生成的方法存根
		AccountList list=new AccountList(po.getAccountList());
		return new ReceiveBillVO(po.getID(),po.getUserID(),po.getMemberID(),list,po.getSum(),po.getTime(),po.getState());
	}
	public boolean submitReceiveBill(ReceiveBillVO receiveBill) {
		// TODO 自动生成的方法存根
		try {
			return RemoteHelper.getInstance().getReceiveBillDataService().insert(receiveBill.toReceiveBillPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	public boolean checkReceiveBill(boolean pass, long id) {
		// TODO 自动生成的方法存根
		try {
			ReceiveBillVO vo=toReceiveBillVO(RemoteHelper.getInstance().getReceiveBillDataService().findReceiveBillbyID(id));
			if(pass){
				vo.setState(1);
			}else{
				vo.setState(2);
			}
			return RemoteHelper.getInstance().getReceiveBillDataService().update(vo.toReceiveBillPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteReceiveBill(ReceiveBillVO payBill) {
		// TODO 自动生成的方法存根
		try {
			return RemoteHelper.getInstance().getReceiveBillDataService().delete(payBill.toReceiveBillPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	public ReceiveBillVO findReceiveBillByID(long id) {
		// TODO 自动生成的方法存根
		try {
			return toReceiveBillVO(RemoteHelper.getInstance().getReceiveBillDataService().findReceiveBillbyID(id));
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<ReceiveBillVO> findReceiveBillByTime(Date time) {
		// TODO 自动生成的方法存根
		ArrayList<ReceiveBillVO> temp=new ArrayList<ReceiveBillVO>();
		try {
			ArrayList<ReceiveBillPO> receiveBills=RemoteHelper.getInstance().getReceiveBillDataService().findReceiveBillbyTime(time);
			for(int i=0;i<receiveBills.size();i++){
				temp.add(toReceiveBillVO(receiveBills.get(i)));
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return temp;
	}

	


}
