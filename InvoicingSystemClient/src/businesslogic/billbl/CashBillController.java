package businesslogic.billbl;

import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.billblservice.CashBillBLService;
import po.CashBillPO;
import rmi.RemoteHelper;
import vo.CashBillVO;

public class CashBillController implements CashBillBLService{

	@Override
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

	@Override
	public boolean submitCashBill(CashBillVO cashbill) {
		// TODO �Զ����ɵķ������
		return RemoteHelper.getInstance();
	}

	@Override
	public boolean checkCashBill(boolean pass) {
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public boolean deleteCashBill(CashBillVO cashbill) {
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public ArrayList<CashBillVO> findCashBillByTime(Date time) {
		// TODO �Զ����ɵķ������
		return null;
	}
	

}
