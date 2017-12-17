package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import businesslogic.memberbl.MemberController;
import po.CashBillPO;
import po.ImportReturnBillPO;
import rmi.RemoteHelper;
import vo.CashBillVO;
import vo.ImportReturnBillVO;
import vo.MemberVO;

public class ImportReturnBill {

	public ImportReturnBillVO toImportReturnBillVO(ImportReturnBillPO po) {
		CommodityList list=new CommodityList(po.getCommodityList());
		return new ImportReturnBillVO(po.getID(),po.getUserID(),po.getMemberID(),list,po.getSum(),po.getState(),
				po.getTime(),po.getRemark());
	}

	public boolean submitImportReturnBill(ImportReturnBillVO importReturnBill) {
		try {
			return RemoteHelper.getInstance().getImportReturnBillDataService().
					insert(importReturnBill.toImportReturnBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkImportReturnBill(boolean pass, long id) {
		try {
			ImportReturnBillVO vo=toImportReturnBillVO(RemoteHelper.getInstance().
					getImportReturnBillDataService().findImportReturnBillbyID(id));
			if(pass){
				vo.setState(1);
				//修改进货退货单里供货商的应付
				MemberController memberCon=new MemberController();
				MemberVO member=memberCon.findMemberByID(id);
				double money=vo.getSum()+member.getShouldPay();
				member.setShouldPay(money);
				memberCon.updateMember(member);
			}else{
				vo.setState(2);
			}
			return RemoteHelper.getInstance().getImportReturnBillDataService().update(vo.toImportReturnBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteImportReturnBill(ImportReturnBillVO importReturnBill) {
		try {
			return RemoteHelper.getInstance().getImportReturnBillDataService().delete(importReturnBill.toImportReturnBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ImportReturnBillVO findImportReturnBillByID(long id) {
		try {
			return toImportReturnBillVO(RemoteHelper.getInstance().getImportReturnBillDataService().findImportReturnBillbyID(id));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<ImportReturnBillVO> findImportReturnBillByTime(Date time) {
		ArrayList<ImportReturnBillVO> temp=new ArrayList<ImportReturnBillVO>();
		try {
			ArrayList<ImportReturnBillPO> importReturnBills=RemoteHelper.getInstance().getImportReturnBillDataService().
					findImportReturnBillbyTime(time);
			for(int i=0;i<importReturnBills.size();i++){
				temp.add(toImportReturnBillVO(importReturnBills.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return temp;
	}
	public ArrayList<ImportReturnBillVO> findImportReturnBills(){
		ArrayList<ImportReturnBillVO> temp=null;
		try {
			temp=new ArrayList<ImportReturnBillVO>();
			ArrayList<ImportReturnBillPO> bills= RemoteHelper.getInstance().getImportReturnBillDataService().findImportReturnBills();
			for(int i=0;i<bills.size();i++){
				temp.add(toImportReturnBillVO(bills.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return temp;
	}
	public ArrayList<ImportReturnBillVO> findImportReturnBillsByInterval(Date begin,Date end){
		ArrayList<ImportReturnBillVO> bills=findImportReturnBills();
		ArrayList<ImportReturnBillVO> result=new ArrayList<ImportReturnBillVO>();
		for(ImportReturnBillVO each:bills){
			if(each.getTime().after(begin)&&each.getTime().before(end)){
				result.add(each);
			}
		}
		return bills;
	}
	public ArrayList<ImportReturnBillVO> findImportReturnBillsByField(Date begin,Date end,String memberName,String userName){
		return null;	
	}
	public ArrayList<ImportReturnBillVO> findImportReturnBillsByState(int state){
		ArrayList<ImportReturnBillVO> result=new ArrayList<ImportReturnBillVO>();
		ArrayList<ImportReturnBillPO> bills;
		try {
			bills = RemoteHelper.getInstance().getImportReturnBillDataService().findImportReturnBillbyState(state);
			for(ImportReturnBillPO po:bills){
				result.add(toImportReturnBillVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
