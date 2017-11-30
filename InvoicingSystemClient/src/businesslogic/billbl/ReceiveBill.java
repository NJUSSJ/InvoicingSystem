package businesslogic.billbl;

import businesslogicservice.billblservice.ReceiveBillBLService;
import po.ReceiveBillPO;
import vo.ReceiveBillVO;

public class ReceiveBill  implements ReceiveBillBLService{

	ReceiveBillVO receivebill;

	@Override
	public ReceiveBillVO toReceiveBillVO(ReceiveBillPO po) {
		// TODO Auto-generated method stub
		AccountList accountList=new AccountList();
		String[] tempInfo=po.getAccountList().split(" ");
		for(int i=0;i<tempInfo.length;i++){
			String[] temp=tempInfo[i].split(",");
			if(temp.length==2){
				accountList.addAccount(new AccountLineItem(Long.parseLong(temp[0]),
						Double.parseDouble(temp[1])));
			}else{//区分有备注的情况
				accountList.addAccount(new AccountLineItem(Long.parseLong(temp[0]),
						Double.parseDouble(temp[1]),temp[2]));
			}
		}
		receivebill=new ReceiveBillVO(po.getID(),po.getUserID(),po.getMemberID(),
				accountList,accountList.getSum(),po.getTime(),po.getState());
		return receivebill;
	}

	@Override
	public String conveyBill(ReceiveBillVO paybill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReceiveBillVO checkBill(ReceiveBillVO paybill) {
		// TODO Auto-generated method stub
		return null;
	}
	
	


}
