package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import businesslogic.accountbl.AccountController;
import businesslogic.memberbl.MemberController;
import po.PayBillPO;
import rmi.RemoteHelper;
import vo.AccountVO;
import vo.MemberVO;
import vo.OverBillVO;
import vo.PayBillVO;

public class PayBill {

	public PayBillVO toPayBillVO(PayBillPO po) {
		if(po==null){
			return null;
		}
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

	public boolean checkPayBill(boolean pass, String id) {
		try {
			PayBillVO vo=toPayBillVO(RemoteHelper.getInstance().getPayBillDataService().findPayBillbyID(id));
			if(pass){
				vo.setState(1);
				//付款单通过以后，修改客户的应收和应收额度
				MemberController mcon=new MemberController();
				MemberVO member=mcon.findMemberByID(vo.getMemberID());
				double money=member.getShouldGet()-vo.getSum();
				member.setShouldGet(money);
				double quota=member.getShouldGet()-member.getShouldPay();
				member.setQuota(quota);
				mcon.updateMember(member);
				//减少账户里的金额
				AccountController acon=new AccountController();
				AccountList accountList=vo.getAccountList();
				for(int j=0;j<accountList.getListLength();j++){
					AccountLineItem lineItem=accountList.getItem(j);
					AccountVO accountVO=acon.findAccountByID(lineItem.getAccountID());
					accountVO.setDeposit(accountVO.getDeposit()-lineItem.getMoney());
					acon.updateAccount(accountVO);
				}
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

	public PayBillVO findPayBillByID(String id) {
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
			if(payBills==null||payBills.isEmpty()) return temp;
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
		if(bills==null){
			return null;
		}
		ArrayList<PayBillVO> result=new ArrayList<PayBillVO>();
		for(PayBillVO each:bills){
			if(each.getTime().after(begin)&&each.getTime().before(end)){
				if(each.getState()==1||each.getState()==3){
					result.add(each);
				}
			}
		}
		return bills;
	}
	public ArrayList<PayBillVO> findPayBillsByField(Date begin,Date end,String memberName,String userName){
		ArrayList<PayBillVO> result=new ArrayList<PayBillVO>();
		try {
			ArrayList<PayBillPO> bills=RemoteHelper.getInstance().getPayBillDataService().findPayBillbyField(userName, memberName);
			for(PayBillPO po:bills){
				if(po.getTime().before(end)&&po.getTime().after(begin)){
					if(po.getState()==1||po.getState()==3){
						result.add(toPayBillVO(po));
					}
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;	
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
			e.printStackTrace();
		}
		
		return result;
	}
	public ArrayList<PayBillVO> findPayBillsByUser(long userid){
		ArrayList<PayBillVO> result=new ArrayList<PayBillVO>();
		try {
			ArrayList<PayBillPO> bills=RemoteHelper.getInstance().getPayBillDataService().findPayBillbyUser(userid);
			for(PayBillPO po:bills){
				result.add(toPayBillVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	public boolean fakeDelete(String id){
		PayBillVO vo=findPayBillByID(id);
		vo.setState(vo.getState()+2);
		try {
			return RemoteHelper.getInstance().getPayBillDataService().update(vo.toPayBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
}
