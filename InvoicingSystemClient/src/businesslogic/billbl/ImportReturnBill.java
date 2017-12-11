package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import businesslogic.commoditybl.CommodityController;
import po.GiftBillPO;
import po.ImportReturnBillPO;
import rmi.RemoteHelper;
import vo.CommodityVO;
import vo.GiftBillVO;
import vo.ImportReturnBillVO;

public class ImportReturnBill {

	public ImportReturnBillVO toImportReturnBillVO(ImportReturnBillPO po) {
		// TODO 自动生成的方法存根
		CommodityList list=new CommodityList(po.getCommodityList());
		return new ImportReturnBillVO(po.getID(),po.getUserID(),po.getMemberID(),list,po.getSum(),po.getState(),
				po.getTime(),po.getRemark());
	}

	public boolean submitImportReturnBill(ImportReturnBillVO importReturnBill) {
		// TODO 自动生成的方法存根
		try {
			return RemoteHelper.getInstance().getImportReturnBillDataService().
					insert(importReturnBill.toImportReturnBillPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkImportReturnBill(boolean pass, long id) {
		// TODO 自动生成的方法存根

		try {
			ImportReturnBillVO vo=toImportReturnBillVO(RemoteHelper.getInstance().
					getImportReturnBillDataService().findImportReturnBillbyID(id));
			if(pass){
				vo.setState(1);
			}else{
				vo.setState(2);
			}
			return RemoteHelper.getInstance().getImportReturnBillDataService().update(vo.toImportReturnBillPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteImportReturnBill(ImportReturnBillVO importReturnBill) {
		// TODO 自动生成的方法存根
		try {
			return RemoteHelper.getInstance().getImportReturnBillDataService().delete(importReturnBill.toImportReturnBillPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	public ImportReturnBillVO findImportReturnBillByID(long id) {
		// TODO 自动生成的方法存根
		try {
			return toImportReturnBillVO(RemoteHelper.getInstance().getImportReturnBillDataService().findImportReturnBillbyID(id));
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<ImportReturnBillVO> findImportReturnBillByTime(Date time) {
		// TODO 自动生成的方法存根
		ArrayList<ImportReturnBillVO> temp=new ArrayList<ImportReturnBillVO>();
		try {
			ArrayList<ImportReturnBillPO> importReturnBills=RemoteHelper.getInstance().getImportReturnBillDataService().
					findImportReturnBillbyTime(time);
			for(int i=0;i<importReturnBills.size();i++){
				temp.add(toImportReturnBillVO(importReturnBills.get(i)));
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return temp;
	}
	
}
