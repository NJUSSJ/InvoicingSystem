package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import businesslogic.memberbl.MemberController;
import po.ImportBillPO;
import rmi.RemoteHelper;
import vo.ImportBillVO;
import vo.MemberVO;

public class ImportBill{

	public ImportBillVO toImportBillVO(ImportBillPO po) {
		CommodityList list=new CommodityList(po.getCommodityList());
		return new ImportBillVO(po.getID(),po.getUserID(),po.getMemberID(),list,po.getSum(),po.getState(),
				po.getTime(),po.getRemark());
	}

	public boolean submitImportBill(ImportBillVO importBill) {
		try {
			return RemoteHelper.getInstance().getImportBillDataService().insert(importBill.toImportBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkImportBill(boolean pass, long id) {
		try {
			ImportBillVO vo=toImportBillVO(RemoteHelper.getInstance().getImportBillDataService().findImportBillbyID(id));
			if(pass){
				vo.setState(1);
				//修改进货单里供货商的应收和应收额度
				MemberController memberCon=new MemberController();
				MemberVO member=memberCon.findMemberByID(id);
				double money=vo.getSum()+member.getShouldGet();
				member.setShouldGet(money);
				double quota=Math.pow(10, (money+"").length()-1)*Integer.parseInt((money+"").substring(0, 1));
				member.setQuota(quota);
				memberCon.updateMember(member);
			}else{
				vo.setState(2);
			}
			return RemoteHelper.getInstance().getImportBillDataService().update(vo.toImportBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteImportBill(ImportBillVO importBill) {
		try {
			return RemoteHelper.getInstance().getImportBillDataService().delete(importBill.toImportBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ImportBillVO findImportBillByID(long id) {
		try {
			return toImportBillVO(RemoteHelper.getInstance().getImportBillDataService().findImportBillbyID(id));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<ImportBillVO> findImportBillByTime(Date time) {
		ArrayList<ImportBillVO> temp=new ArrayList<ImportBillVO>();
		try {
			ArrayList<ImportBillPO> importBills=RemoteHelper.getInstance().getImportBillDataService().
					findImportBillbyTime(time);
			for(int i=0;i<importBills.size();i++){
				temp.add(toImportBillVO(importBills.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return temp;
	}
	public ArrayList<ImportBillVO> findImportBills(){
		ArrayList<ImportBillVO> temp=null;
		try {
			temp=new ArrayList<ImportBillVO>();
			ArrayList<ImportBillPO> bills;
			bills = RemoteHelper.getInstance().getImportBillDataService().findImportBills();
			for(int i=0;i<bills.size();i++){
				temp.add(toImportBillVO(bills.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return temp;
	}
	public ArrayList<ImportBillVO> findImportBillsByInterval(Date begin,Date end){
		ArrayList<ImportBillVO> bills=findImportBills();
		ArrayList<ImportBillVO> result=new ArrayList<ImportBillVO>();
		for(ImportBillVO each:bills){
			if(each.getTime().after(begin)&&each.getTime().before(end)){
				result.add(each);
			}
		}
		return bills;
	}

}
