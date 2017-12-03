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
		// TODO �Զ����ɵķ������
		CommodityList list=new CommodityList(giftBillPO.getGiftList());
		return new GiftBillVO(giftBillPO.getID(),giftBillPO.getUserID(),giftBillPO.getMemberID(),
				list,giftBillPO.getTime(),giftBillPO.getState());
	}

	public boolean submitGiftBill(GiftBillVO giftBill) {
		// TODO �Զ����ɵķ������
		try {
			return RemoteHelper.getInstance().getGiftBillDataService().insert(giftBill.toGiftBillPO());
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkGiftBill(boolean pass, long id) {
		// TODO �Զ����ɵķ������
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return pass;
		
	}

	public boolean deleteGiftBill(GiftBillVO giftBill) {
		// TODO �Զ����ɵķ������
		try {
			return RemoteHelper.getInstance().getGiftBillDataService().delete(giftBill.toGiftBillPO());
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<GiftBillVO> findGiftBillByTime(Date time) {
		// TODO �Զ����ɵķ������
		ArrayList<GiftBillVO> temp=new ArrayList<GiftBillVO>();
		ArrayList<GiftBillPO> giftBills;
		try {
			//temp=new ArrayList<GiftBillVO>();
			giftBills = RemoteHelper.getInstance().getGiftBillDataService().findGiftBillsbyTime(time);
			for(int i=0;i<giftBills.size();i++){
				temp.add(toGiftBillVO(giftBills.get(i)));
			}
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return temp;
	}

	

}
