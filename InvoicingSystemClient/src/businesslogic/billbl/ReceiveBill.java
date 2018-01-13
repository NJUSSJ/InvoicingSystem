package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import businesslogic.accountbl.AccountController;
import businesslogic.memberbl.MemberController;
import po.ReceiveBillPO;
import rmi.RemoteHelper;
import vo.AccountVO;
import vo.MemberVO;
import vo.ReceiveBillVO;

public class ReceiveBill{

	public ReceiveBillVO toReceiveBillVO(ReceiveBillPO po) {
		if(po==null){
			return null;
		}
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
	public boolean checkReceiveBill(boolean pass, String id) {
		try {
			ReceiveBillVO vo=toReceiveBillVO(RemoteHelper.getInstance().getReceiveBillDataService().findReceiveBillbyID(id));
			if(pass){
				vo.setState(1);
				MemberController memberCon=new MemberController();
				MemberVO member=memberCon.findMemberByID(vo.getMemberID());
				double money=member.getShouldPay()-vo.getSum();
				member.setShouldPay(money);
				member.setQuota(member.getShouldGet()-member.getShouldPay());
				memberCon.updateMember(member);
				//增加账户里的金额
				AccountController acon=new AccountController();
				AccountList accountList=vo.getAccountList();
				for(int j=0;j<accountList.getListLength();j++){
					AccountLineItem lineItem=accountList.getItem(j);
					AccountVO accountVO=acon.findAccountByID(lineItem.getAccountID());
					accountVO.setDeposit(accountVO.getDeposit()+lineItem.getMoney());
					acon.updateAccount(accountVO);
				}
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
	/**
	 * 根据id查找收款单
	 */
	public ReceiveBillVO findReceiveBillByID(String id) {
		try {
			return toReceiveBillVO(RemoteHelper.getInstance().getReceiveBillDataService().findReceiveBillbyID(id));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据时间查找收款单
	 */
	public ArrayList<ReceiveBillVO> findReceiveBillByTime(Date time) {
		ArrayList<ReceiveBillVO> temp=new ArrayList<ReceiveBillVO>();
		try {
			ArrayList<ReceiveBillPO> receiveBills=RemoteHelper.getInstance().getReceiveBillDataService().findReceiveBillbyTime(time);
			if(receiveBills==null||receiveBills.isEmpty()) return temp;
			for(int i=0;i<receiveBills.size();i++){
				temp.add(toReceiveBillVO(receiveBills.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return temp;
	}
	/**
	 * 查找所有收款单
	 */
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
	/**
	 * 根据时间区间查找收款单 经营历程表
	 */
	public ArrayList<ReceiveBillVO> findReceiveBillsByInterval(Date begin,Date end){
		ArrayList<ReceiveBillVO> bills=findReceiveBills();
		if(bills==null){
			return null;
		}
		ArrayList<ReceiveBillVO> result=new ArrayList<ReceiveBillVO>();
		for(ReceiveBillVO each:bills){
			if(each.getTime().after(begin)&&each.getTime().before(end)){
				if(each.getState()==1||each.getState()==3){
					result.add(each);
				}
			}
		}
		return result;
	}
	/**
	 * 根据状态查找收款单
	 */
	public ArrayList<ReceiveBillVO> findReceiveBillsByState(int state){
		ArrayList<ReceiveBillVO> result=new ArrayList<ReceiveBillVO>();
		ArrayList<ReceiveBillPO> bills;
		try {
			bills = RemoteHelper.getInstance().getReceiveBillDataService().findReceiveBillbyState(state);
			if(bills==null){
				return null;
			}
			for(ReceiveBillPO po:bills){
				result.add(toReceiveBillVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	/**
	 * 根据时间区间，客户名，操作员名查找收款单
	 */
	public ArrayList<ReceiveBillVO> findReceiveBillsByField(Date begin, Date end, String memberName, String userName) {
		ArrayList<ReceiveBillVO> result=new ArrayList<ReceiveBillVO>();
		try {
			ArrayList<ReceiveBillPO> bills=RemoteHelper.getInstance().getReceiveBillDataService().findReceiveBillbyField(userName, memberName);
			if(bills==null){
				return null;
			}
			for(ReceiveBillPO po:bills){
				if(po.getTime().before(end)&&po.getTime().after(begin)){
					if(po.getState()==1||po.getState()==3){
						result.add(toReceiveBillVO(po));
					}
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 根据操作员id查找收款单
	 * @return
	 */
	public ArrayList<ReceiveBillVO> findReceiveBillsByUser(long userid){
		ArrayList<ReceiveBillVO> result=new ArrayList<ReceiveBillVO>();
		try {
			ArrayList<ReceiveBillPO> bills=RemoteHelper.getInstance().getReceiveBillDataService().findReceiveBillbyUser(userid);
			if(bills==null){
				return null;
			}
			for(ReceiveBillPO po:bills){
				result.add(toReceiveBillVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 从邮箱中删除收款单
	 */
	public boolean fakeDelete(String id){
		ReceiveBillVO vo=findReceiveBillByID(id);
		vo.setState(vo.getState()+2);
		try {
			return RemoteHelper.getInstance().getReceiveBillDataService().update(vo.toReceiveBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
}
