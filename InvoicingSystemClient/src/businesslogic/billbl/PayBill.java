package businesslogic.billbl;

import businesslogicservice.billblservice.PayBillBLService;
import po.PayBillPO;
import vo.PayBillVO;

public class PayBill  implements PayBillBLService{

	@Override
	public PayBillVO toPayBillVO(PayBillPO po) {
		// TODO Auto-generated method stub
		AccountList accountList=new AccountList();
		String[] temp=po.getAccountList().split(" ");
		for(int i=0;i<temp.length;i++){
			String[] tempinfo=temp[i].split(",");
			AccountLineItem item=new AccountLineItem(Long.parseLong(tempinfo[0]),
					Double.parseDouble(tempinfo[1]),tempinfo[2]);
			accountList.addAccount(item);
		}
		return new PayBillVO(po.getID(),po.getUserID(),po.getMemberID(),accountList,
				po.getSum(),po.getTime(),po.getState());
	}

	@Override
	public String conveyBill(PayBillVO paybill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PayBillVO checkBill() {
		// TODO 自动生成的方法存根
		return null;
	}

	
}
