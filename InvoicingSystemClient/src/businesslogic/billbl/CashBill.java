package businesslogic.billbl;

import java.util.ArrayList;

import businesslogicservice.billblservice.CashBillBLService;
import po.CashBillPO;
import vo.CashBillVO;

public class CashBill implements CashBillBLService{


	@Override
	public String conveyBill(CashBillVO cashbill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CashBillVO checkBill(CashBillVO cashbill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CashBillVO toCashBillVO(CashBillPO po) {
		// TODO 自动生成的方法存根
		ArrayList<String> tmpitems = new ArrayList<String>();
		String[] tmp=po.getItems().split(" ");
		for(int i=0;i<tmp.length;i++){
			tmpitems.add(tmp[i]);
		}
		return new CashBillVO(po.getID(),po.getUserID(),po.getAccountID(),tmpitems,po.getTime(),po.getState());
	}
	
	
}
