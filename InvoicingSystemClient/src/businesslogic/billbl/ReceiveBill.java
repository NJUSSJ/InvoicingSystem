package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import businesslogic.memberbl.MemberController;
import po.ReceiveBillPO;
import rmi.RemoteHelper;
import vo.ImportBillVO;
import vo.MemberVO;
import vo.ReceiveBillVO;

public class ReceiveBill{

	public ReceiveBillVO toReceiveBillVO(ReceiveBillPO po) {
		AccountList list=new AccountList(po.getAccountList());
		return new ReceiveBillVO(po.getID(),po.getUserID(),po.getMemberID(),list,po.getSum(),po.getTime(),po.getState());
	}
	public boolean submitReceiveBill(ReceiveBillVO receiveBill) {
		try {
			return RemoteHelper.getInstance().getReceiveBillDataService().insert(receiveBill.toReceiveBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean checkReceiveBill(boolean pass, long id) {
		try {
			ReceiveBillVO vo=toReceiveBillVO(RemoteHelper.getInstance().getReceiveBillDataService().findReceiveBillbyID(id));
			if(pass){
				vo.setState(1);
				MemberController memberCon=new MemberController();
				MemberVO member=memberCon.findMemberByID(id);
				double money=member.getShouldPay()-vo.getSum();
				member.setShouldPay(money);
				memberCon.updateMember(member);
			}else{
				vo.setState(2);
			}
			return RemoteHelper.getInstance().getReceiveBillDataService().update(vo.toReceiveBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteReceiveBill(ReceiveBillVO payBill) {
		try {
			return RemoteHelper.getInstance().getReceiveBillDataService().delete(payBill.toReceiveBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	public ReceiveBillVO findReceiveBillByID(long id) {
		try {
			return toReceiveBillVO(RemoteHelper.getInstance().getReceiveBillDataService().findReceiveBillbyID(id));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<ReceiveBillVO> findReceiveBillByTime(Date time) {
		ArrayList<ReceiveBillVO> temp=new ArrayList<ReceiveBillVO>();
		try {
			ArrayList<ReceiveBillPO> receiveBills=RemoteHelper.getInstance().getReceiveBillDataService().findReceiveBillbyTime(time);
			for(int i=0;i<receiveBills.size();i++){
				temp.add(toReceiveBillVO(receiveBills.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return temp;
	}
	public ArrayList<ReceiveBillVO> findReceiveBills(){
		ArrayList<ReceiveBillVO> temp=null;
		try {
			temp=new ArrayList<ReceiveBillVO>();
			ArrayList<ReceiveBillPO> bills=RemoteHelper.getInstance().getReceiveBillDataService().findReceiveBills();
			for(int i=0;i<bills.size();i++){
				temp.add(toReceiveBillVO(bills.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} 
		return temp;
	}
	public ArrayList<ReceiveBillVO> findReceiveBillsByInterval(Date begin,Date end){
		ArrayList<ReceiveBillVO> bills=findReceiveBills();
		ArrayList<ReceiveBillVO> result=new ArrayList<ReceiveBillVO>();
		for(ReceiveBillVO each:bills){
			if(each.getTime().after(begin)&&each.getTime().before(end)){
				result.add(each);
			}
		}
		return bills;
	}

}
