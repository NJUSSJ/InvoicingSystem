package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import businesslogic.commoditybl.CommodityController;
import businesslogicservice.billblservice.SaleReturnBillBLService;
import po.SaleBillPO;
import po.SaleReturnBillPO;
import rmi.RemoteHelper;
import vo.CommodityVO;
import vo.SaleBillVO;
import vo.SaleReturnBillVO;

public class SaleReturnBill{
	public SaleReturnBillVO toSaleReturnBillVO(SaleReturnBillPO po) {
		// TODO 自动生成的方法存根
		CommodityList list=new CommodityList(po.getCommodityList());
		return new SaleReturnBillVO(po.getID(),po.getUserID(),po.getMemberID(),list,po.getSum(),po.getState(),
				po.getTime(),po.getRemark());
	}
	public boolean submitSaleReturnBill(SaleReturnBillVO saleReturnBill) {
		// TODO 自动生成的方法存根
		try {
			return RemoteHelper.getInstance().getSaleReturnBillDataService().insert(saleReturnBill.toSaleReturnBillPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	public boolean checkSaleReturnBill(boolean pass, long id) {
		// TODO 自动生成的方法存根
		try {
			SaleReturnBillVO vo=toSaleReturnBillVO(RemoteHelper.getInstance().getSaleReturnBillDataService().findSaleReturnBillbyID(id));
			if(pass){
				vo.setState(1);
			}else{
				vo.setState(2);
			}
			return RemoteHelper.getInstance().getSaleReturnBillDataService().update(vo.toSaleReturnBillPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteSaleReturnBill(SaleReturnBillVO saleReturnBill) {
		// TODO 自动生成的方法存根
		try {
			return RemoteHelper.getInstance().getSaleReturnBillDataService().delete(saleReturnBill.toSaleReturnBillPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	public SaleReturnBillVO findSaleReturnBillByID(long id) {
		// TODO 自动生成的方法存根
		try {
			return toSaleReturnBillVO(RemoteHelper.getInstance().getSaleReturnBillDataService().findSaleReturnBillbyID(id));
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<SaleReturnBillVO> findSaleReturnBillByTime(Date time) {
		// TODO 自动生成的方法存根
		ArrayList<SaleReturnBillVO> temp=new ArrayList<SaleReturnBillVO>();
		try {
			ArrayList<SaleReturnBillPO> saleReturnBills=RemoteHelper.getInstance().getSaleReturnBillDataService().
					findSaleReturnBillbyTime(time);
			for(int i=0;i<saleReturnBills.size();i++){
				temp.add(toSaleReturnBillVO(saleReturnBills.get(i)));
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return temp;
	}
	
	
}
