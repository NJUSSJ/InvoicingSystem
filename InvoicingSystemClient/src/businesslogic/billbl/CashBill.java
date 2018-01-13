package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import businesslogic.accountbl.AccountController;
import po.CashBillPO;
import rmi.RemoteHelper;
import vo.AccountVO;
import vo.CashBillVO;

public class CashBill{
	public CashBillVO toCashBillVO(CashBillPO po) {
		if(po==null){
			return null;
		}
		String[] items=po.getItems().split(" ");
		ArrayList<String> temp=new ArrayList<String>();
		for(int i=0;i<items.length;i++){
			temp.add(items[i]);
		}
		
		return new CashBillVO(po.getID(),po.getUserID(),po.getAccountID(),temp,po.getTime(),
				po.getState());
	}
	public boolean submitCashBill(CashBillVO cashBill) {
		try {
			
			return RemoteHelper.getInstance().getCashBillDataService().insert(cashBill.toCashBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean checkCashBill(boolean pass,String id) {
		try {
			CashBillVO cashBillVO=toCashBillVO(RemoteHelper.getInstance().
				getCashBillDataService().findCashBillbyID(id));
			if(pass){
			cashBillVO.setState(1);
			AccountController acon=new AccountController();
			AccountVO accountVO=acon.findAccountByID(cashBillVO.getAccountID());
			accountVO.setDeposit(accountVO.getDeposit()-cashBillVO.getSum());
			acon.updateAccount(accountVO);
			}else{
			cashBillVO.setState(2);
			}
			return RemoteHelper.getInstance().getCashBillDataService().update(cashBillVO.toCashBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteCashBill(CashBillVO cashBill) {
		try {
			return RemoteHelper.getInstance().getCashBillDataService().delete(cashBill.toCashBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * ����ʱ������ֽ���õ�
	 * @param time ʱ��
	 * @return ������ʱ����ֽ���õ�
	 */
	public ArrayList<CashBillVO> findCashBillByTime(Date time) {
		ArrayList<CashBillVO> temp=null;
		try {
			temp=new ArrayList<CashBillVO>();
			ArrayList<CashBillPO> cashBills;
			cashBills = RemoteHelper.getInstance().getCashBillDataService().findCashBillbyTime(time);
			for(int i=0;i<cashBills.size();i++){
				temp.add(toCashBillVO(cashBills.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return temp;
		
	}
	/**
	 * ���������ֽ���õ�
	 * @return ���������ֽ���õ���list
	 */
	public ArrayList<CashBillVO> findCashBills(){
		ArrayList<CashBillVO> temp=null;
		try {
			temp=new ArrayList<CashBillVO>();
			ArrayList<CashBillPO> cashbills=RemoteHelper.getInstance().getCashBillDataService().findCashBills();
			for(int i=0;i<cashbills.size();i++){
				temp.add(toCashBillVO(cashbills.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return temp;
	}
	/**
	 * ����ʱ����������ֽ���õ� ��Ӫ���̱�
	 * @return ʱ����begin��end֮����ֽ���õ�list
	 */
	public ArrayList<CashBillVO> findCashBillsByInterval(Date begin,Date end){
		ArrayList<CashBillVO> bills=findCashBills();
		if(bills==null)return null;
		ArrayList<CashBillVO> result=new ArrayList<CashBillVO>();
		for(CashBillVO each:bills){
			if(each.getTime().after(begin)&&each.getTime().before(end)){
				if(each.getState()==1||each.getState()==3){
					result.add(each);
				}
			}
		}
		return result;
	}
	/**
	 * ����ʱ������Ͳ���Ա�������ֽ���õ� ��Ӫ���̱�
	 * @return �����������ֽ���õ�
	 */
	public ArrayList<CashBillVO> findCashBillsByField(Date begin,Date end,String userName){
		ArrayList<CashBillVO> result=new ArrayList<CashBillVO>();
		if(userName==null||userName.length()<=0) {
			return findCashBillsByInterval(begin,end);
		}
		try {
			ArrayList<CashBillPO> bills=RemoteHelper.getInstance().getCashBillDataService().findCashBillbyField(userName);
			if(bills==null)return null;
			for(CashBillPO po:bills){
				if(po.getTime().before(end)&&po.getTime().after(begin)){
					if(po.getState()==1||po.getState()==3){
						result.add(toCashBillVO(po));
					}
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;	
	}
	/**
	 * ����״̬�����ֽ���õ�
	 */
	public ArrayList<CashBillVO> findCashBillsByState(int state){
		ArrayList<CashBillVO> result=new ArrayList<CashBillVO>();
		ArrayList<CashBillPO> bills;
		try {
			bills = RemoteHelper.getInstance().getCashBillDataService().findCashBillbyState(state);
			for(CashBillPO po:bills){
				result.add(toCashBillVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * ���ݲ���Աid�����ֽ���õ�
	 */
	public ArrayList<CashBillVO> findCashBillsByUser(long userid){
		ArrayList<CashBillVO> result=new ArrayList<CashBillVO>();
		try {
			ArrayList<CashBillPO> bills=RemoteHelper.getInstance().getCashBillDataService().findCashBillbyUser(userid);
			for(CashBillPO po:bills){
				result.add(toCashBillVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * ����id�����ֽ���õ�
	 */
	public CashBillVO findCashBillByID(String id){
		try {
			return toCashBillVO(RemoteHelper.getInstance().getCashBillDataService().findCashBillbyID(id));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * ��������ɾ���ֽ���õ�
	 */
	public boolean fakeDelete(String id){
		CashBillVO vo=findCashBillByID(id);
		vo.setState(vo.getState()+2);
		try {
			return RemoteHelper.getInstance().getCashBillDataService().update(vo.toCashBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
}
