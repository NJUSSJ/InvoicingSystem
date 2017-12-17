package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import po.GiftBillPO;
import rmi.RemoteHelper;
import vo.GiftBillVO;

public class GiftBill {

	public GiftBillVO toGiftBillVO(GiftBillPO giftBillPO) {
		// TODO 自动生成的方法存根
		CommodityList list=new CommodityList(giftBillPO.getGiftList());
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
	public ArrayList<GiftBillVO> findGiftBills(){
		ArrayList<GiftBillVO> temp=null;
		try {
			temp=new ArrayList<GiftBillVO>();
			ArrayList<GiftBillPO> bills= RemoteHelper.getInstance().getGiftBillDataService().findGiftBills();
			for(int i=0;i<bills.size();i++){
				temp.add(toGiftBillVO(bills.get(i)));
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return temp;
	}
	public ArrayList<GiftBillVO> findGiftBillByInterval(Date begin,Date end){
		ArrayList<GiftBillVO> bills=findGiftBills();
		ArrayList<GiftBillVO> result=new ArrayList<GiftBillVO>();
		for(GiftBillVO each:bills){
			if(each.getTime().after(begin)&&each.getTime().before(end)){
				result.add(each);
			}
		}
		return result;
	}
	public ArrayList<GiftBillVO> findGiftBillsByField(Date begin,Date end,String memberName,String userName){
		return null;
	}

}
