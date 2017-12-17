package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import businesslogic.memberbl.MemberController;
import po.CashBillPO;
import po.PayBillPO;
import rmi.RemoteHelper;
import vo.CashBillVO;
import vo.ImportBillVO;
import vo.MemberVO;
import vo.PayBillVO;

public class PayBill {

	public PayBillVO toPayBillVO(PayBillPO po) {
		AccountList list=new AccountList(po.getAccountList());
		return new PayBillVO(po.getID(),po.getUserID(),po.getMemberID(),list,po.getSum(),po.getTime(),po.getState());
	}

	public boolean submitPayBill(PayBillVO payBill) {
		try {
			return RemoteHelper.getInstance().getPayBillDataService().insert(payBill.toPayBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkPayBill(boolean pass, long id) {
		try {
			PayBillVO vo=toPayBillVO(RemoteHelper.getInstance().getPayBillDataService().findPayBillbyID(id));
			if(pass){
				vo.setState(1);
				//付款单通过以后，修改客户的应收和应收额度
				MemberController mcon=new MemberController();
				MemberVO member=mcon.findMemberByID(vo.getMemberID());
				double money=member.getShouldGet()-vo.getSum();
				member.setShouldGet(money);
				double quota=Math.pow(10, (money+"").length()-1)*Integer.parseInt((money+"").substring(0, 1));
				member.setQuota(quota);
				mcon.updateMember(member);
			}else{
				vo.setState(2);
			}
			return RemoteHelper.getInstance().getPayBillDataService().update(vo.toPayBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deletePayBill(PayBillVO payBill) {
		try {
			return RemoteHelper.getInstance().getPayBillDataService().delete(payBill.toPayBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public PayBillVO findPayBillByID(long id) {
		try {
			return toPayBillVO(RemoteHelper.getInstance().getPayBillDataService().findPayBillbyID(id));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<PayBillVO> findPayBillByTime(Date time) {
		ArrayList<PayBillVO> temp=new ArrayList<PayBillVO>();
		try {
			ArrayList<PayBillPO> payBills=RemoteHelper.getInstance().getPayBillDataService().findPayBillbyTime(time);
			for(int i=0;i<payBills.size();i++){
				temp.add(toPayBillVO(payBills.get(i)));
			}
		} catch (RemoteException e) {
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
			e.printStackTrace();
		}
		return temp;
	}
	public ArrayList<PayBillVO> findPayBillsByInterval(Date begin,Date end){
		ArrayList<PayBillVO> bills=findPayBills();
		ArrayList<PayBillVO> result=new ArrayList<PayBillVO>();
		for(PayBillVO each:bills){
			if(each.getTime().after(begin)&&each.getTime().before(end)){
				result.add(each);
			}
		}
		return bills;
	}
	public ArrayList<PayBillVO> findPayBillsByField(Date begin,Date end,String memberName,String userName){
		return null;	
	}
	public ArrayList<PayBillVO> findPayBillsByState(int state){
		ArrayList<PayBillVO> result=new ArrayList<PayBillVO>();
		ArrayList<PayBillPO> bills;
		try {
			bills = RemoteHelper.getInstance().getPayBillDataService().findPayBillbyState(state);
			for(PayBillPO po:bills){
				result.add(toPayBillVO(po));
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return result;
	}
}
