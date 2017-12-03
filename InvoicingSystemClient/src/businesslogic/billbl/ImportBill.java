package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import businesslogic.commoditybl.CommodityController;
import businesslogicservice.billblservice.ImportBillBLService;
import po.ImportBillPO;
import rmi.RemoteHelper;
import vo.CommodityVO;
import vo.ImportBillVO;

public class ImportBill{

	public ImportBillVO toImportBillVO(ImportBillPO po) {
		// TODO 自动生成的方法存根
		CommodityList list=new CommodityList();
		String[] commodityInfo=po.getCommodityList().split(" ");
		CommodityController comController=new CommodityController();
		for(int i=0;i<commodityInfo.length;i++){
			String[] details=commodityInfo[i].split(",");
			int num=Integer.parseInt(details[0]);
			long id=Long.parseLong(details[1]);
			CommodityVO vo=comController.findCommodityByID(id);
			list.addCommodity(new CommodityLineItem(vo,num));
		}
		return new ImportBillVO(po.getID(),po.getUserID(),po.getMemberID(),list,po.getSum(),po.getState(),
				po.getTime(),po.getRemark());
	}

	public boolean submitImportBill(ImportBillVO importBill) {
		// TODO 自动生成的方法存根
		try {
			return RemoteHelper.getInstance().getImportBillDataService().insert(importBill.toImportBillPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkImportBill(boolean pass, long id) {
		// TODO 自动生成的方法存根
		
		try {
			ImportBillVO vo=toImportBillVO(RemoteHelper.getInstance().getImportBillDataService().findImportBillbyID(id));
			if(pass){
				vo.setState(1);
			}else{
				vo.setState(2);
			}
			return RemoteHelper.getInstance().getImportBillDataService().update(vo.toImportBillPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return pass;
	}

	public boolean deleteImportBill(ImportBillVO importBill) {
		// TODO 自动生成的方法存根
		try {
			return RemoteHelper.getInstance().getImportBillDataService().delete(importBill.toImportBillPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	public ImportBillVO findImportBillByID(long id) {
		// TODO 自动生成的方法存根
		try {
			return toImportBillVO(RemoteHelper.getInstance().getImportBillDataService().findImportBillbyID(id));
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<ImportBillVO> findImportBillByTime(Date time) {
		// TODO 自动生成的方法存根
		ArrayList<ImportBillVO> temp=new ArrayList<ImportBillVO>();
		try {
			ArrayList<ImportBillPO> importBills=RemoteHelper.getInstance().getImportBillDataService().
					findImportBillbyTime(time);
			for(int i=0;i<importBills.size();i++){
				temp.add(toImportBillVO(importBills.get(i)));
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return temp;
	}

}
