package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import businesslogic.commoditybl.CommodityController;
import businesslogicservice.billblservice.GiftBillBLService;
import po.GiftBillPO;
import rmi.RemoteHelper;
import vo.CommodityVO;
import vo.GiftBillVO;

public class GiftBill {

	public GiftBillVO toGiftBillVO(GiftBillPO giftBillPO) {
		// TODO 自动生成的方法存根
		String[] commodityInfo=giftBillPO.getGiftList().split(" ");
		CommodityList list=new CommodityList();
		CommodityController comController=new CommodityController();
		for(int i=0;i<commodityInfo.length;i++){
			String[] details=commodityInfo[i].split(",");
			int num=Integer.parseInt(details[0]);
			long id=Long.parseLong(details[1]);
			CommodityVO vo=comController.findCommodityByID(id);
			list.addCommodity(new CommodityLineItem(vo,num));
			
		}
		return new GiftBillVO(giftBillPO.getID(),giftBillPO.getUserID(),giftBillPO.getMemberID(),
				list,giftBillPO.getTime(),giftBillPO.getState());
	}

	public boolean submitGiftBill(GiftBillVO giftBill) {
		// TODO 自动生成的方法存根
		try {
			return RemoteHelper.getInstance().getGiftBillDataService().insert(giftBill.toGiftBillPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkGiftBill(boolean pass, long id) {
		// TODO 自动生成的方法存根
		GiftBillVO vo=null;
		try {
			vo = toGiftBillVO(RemoteHelper.getInstance().getGiftBillDataService().findGiftBillbyID(id));
			if(pass){
				vo.setState(1);
			}else{
				vo.setState(2);
			}
			return RemoteHelper.getInstance().getGiftBillDataService().update(vo.toGiftBillPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return pass;
		
	}

	public boolean deleteGiftBill(GiftBillVO giftBill) {
		// TODO 自动生成的方法存根
		try {
			return RemoteHelper.getInstance().getGiftBillDataService().delete(giftBill.toGiftBillPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<GiftBillVO> findGiftBillByTime(Date time) {
		// TODO 自动生成的方法存根
		ArrayList<GiftBillVO> temp=new ArrayList<GiftBillVO>();
		ArrayList<GiftBillPO> giftBills;
		try {
			//temp=new ArrayList<GiftBillVO>();
			giftBills = RemoteHelper.getInstance().getGiftBillDataService().findGiftBillsbyTime(time);
			for(int i=0;i<giftBills.size();i++){
				temp.add(toGiftBillVO(giftBills.get(i)));
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return temp;
	}

	

}
