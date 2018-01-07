package businesslogic.billbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import businesslogic.commoditybl.CommodityController;
import po.GiftBillPO;
import rmi.RemoteHelper;
import vo.CommodityVO;
import vo.GiftBillVO;

public class GiftBill {

	public GiftBillVO toGiftBillVO(GiftBillPO giftBillPO) {
		if(giftBillPO==null){
			return null;
		}
		CommodityList list=new CommodityList(giftBillPO.getGiftList());
		return new GiftBillVO(giftBillPO.getID(),giftBillPO.getUserID(),giftBillPO.getMemberID(),
				list,giftBillPO.getTime(),giftBillPO.getState());
	}

	public boolean submitGiftBill(GiftBillVO giftBill) {
		try {
			return RemoteHelper.getInstance().getGiftBillDataService().insert(giftBill.toGiftBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkGiftBill(boolean pass, long id) {
		GiftBillVO vo=null;
		try {
			vo = toGiftBillVO(RemoteHelper.getInstance().getGiftBillDataService().findGiftBillbyID(id));
			if(pass){
				vo.setState(1);
				CommodityController ccon=new CommodityController();
				CommodityVO commodityVO=ccon.findCommodityByID(vo.getCommodityList().get(0).getCommodityID());
				commodityVO.setStockNum(commodityVO.getStockNum()-vo.getCommodityList().get(0).getNum());
				ccon.updateCommodity(commodityVO);
			}else{
				vo.setState(2);
			}
			return RemoteHelper.getInstance().getGiftBillDataService().update(vo.toGiftBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return pass;
		
	}

	public boolean deleteGiftBill(GiftBillVO giftBill) {
		try {
			return RemoteHelper.getInstance().getGiftBillDataService().delete(giftBill.toGiftBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<GiftBillVO> findGiftBillByTime(Date time) {
		ArrayList<GiftBillVO> temp=new ArrayList<GiftBillVO>();
		ArrayList<GiftBillPO> giftBills;
		try {
			giftBills = RemoteHelper.getInstance().getGiftBillDataService().findGiftBillsbyTime(time);
			for(int i=0;i<giftBills.size();i++){
				temp.add(toGiftBillVO(giftBills.get(i)));
			}
		} catch (RemoteException e) {
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
			e.printStackTrace();
		}
		return temp;
	}
	public ArrayList<GiftBillVO> findGiftBillByInterval(Date begin,Date end){
		ArrayList<GiftBillVO> bills=findGiftBills();
		if(bills==null)return null;
		ArrayList<GiftBillVO> result=new ArrayList<GiftBillVO>();
		for(GiftBillVO each:bills){
			if(each.getTime().after(begin)&&each.getTime().before(end)){
				if(each.getState()==1||each.getState()==3){
					result.add(each);
				}
			}
		}
		return result;
	}
	public ArrayList<GiftBillVO> findGiftBillsByField(Date begin,Date end,String memberName,String userName){
		ArrayList<GiftBillVO> result=new ArrayList<GiftBillVO>();
		try {
			ArrayList<GiftBillPO> bills=RemoteHelper.getInstance().getGiftBillDataService().
					findGiftBillsByField(userName, memberName);
			if(bills==null)return null;
			for(GiftBillPO po:bills){
				if(po.getTime().before(end)&&po.getTime().after(begin)){
					if(po.getState()==1||po.getState()==3){
						result.add(toGiftBillVO(po));
					}
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<GiftBillVO> findGiftBillsByState(int state){
		ArrayList<GiftBillVO> result=new ArrayList<GiftBillVO>();
		ArrayList<GiftBillPO> bills;
		try {
			bills = RemoteHelper.getInstance().getGiftBillDataService().findGiftBillbyState(state);
			for(GiftBillPO po:bills){
				result.add(toGiftBillVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<GiftBillVO> findGiftBillsByUser(long userid){
		ArrayList<GiftBillVO> result=new ArrayList<GiftBillVO>();
		try {
			ArrayList<GiftBillPO> bills=RemoteHelper.getInstance().getGiftBillDataService().findGiftBillbyUser(userid);
			for(GiftBillPO po:bills){
				result.add(toGiftBillVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	public GiftBillVO findGiftBillByID(long id){
		try {
			return toGiftBillVO(RemoteHelper.getInstance().getGiftBillDataService().findGiftBillbyID(id));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean fakeDelete(long id){
		GiftBillVO vo=findGiftBillByID(id);
		vo.setState(vo.getState()+2);
		try {
			return RemoteHelper.getInstance().getGiftBillDataService().update(vo.toGiftBillPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

}
