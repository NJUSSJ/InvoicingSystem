 package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import businesslogic.commoditybl.CommodityController;
import po.SaleBillPO;
import rmi.RemoteHelper;
import vo.CommodityVO;
import vo.SaleBillVO;

public class SaleBill{

	public SaleBillVO toSaleBillVO(SaleBillPO po) {
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
		return new SaleBillVO(po.getID(),po.getUserID(),po.getMemberID(),list,po.getSum(),po.getState(),
				po.getTime(),po.getRemark());
	}
	public boolean submitSaleBill(SaleBillVO saleBill) {
		// TODO 自动生成的方法存根
		try {
			return RemoteHelper.getInstance().getSaleBillDataService().insert(saleBill.toSaleBillPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	public boolean checkSaleBill(boolean pass, long id) {
		// TODO 自动生成的方法存根
		try {
			SaleBillVO vo=toSaleBillVO(RemoteHelper.getInstance().getSaleBillDataService().findSaleBillbyID(id));
			if(pass){
				vo.setState(1);
			}else{
				vo.setState(2);
			}
			return RemoteHelper.getInstance().getSaleBillDataService().update(vo.toSaleBillPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteSaleBill(SaleBillVO saleBill) {
		// TODO 自动生成的方法存根
		try {
			return RemoteHelper.getInstance().getSaleBillDataService().delete(saleBill.toSaleBillPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	public SaleBillVO findSaleBillByID(long id) {
		// TODO 自动生成的方法存根
		try {
			return toSaleBillVO(RemoteHelper.getInstance().getSaleBillDataService().findSaleBillbyID(id));
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<SaleBillVO> findSaleBillByTime(Date time) {
		// TODO 自动生成的方法存根
		ArrayList<SaleBillVO> temp=new ArrayList<SaleBillVO>();
		try {
			ArrayList<SaleBillPO> saleBills=RemoteHelper.getInstance().getSaleBillDataService().
					findSaleBillbyTime(time);
			for(int i=0;i<saleBills.size();i++){
				temp.add(toSaleBillVO(saleBills.get(i)));
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return temp;
	}

	
	
}
