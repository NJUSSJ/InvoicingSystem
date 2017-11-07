package businesslogic.billbl;

import java.util.ArrayList;

import businesslogicservice.billblservice.GiftBillBLService;
import vo.GiftBillVO;

public class GiftBill  implements GiftBillBLService {
	
	CommodityList list;
	GiftBillVO giftbill;

	@Override
	public GiftBillVO updateGiftbill(GiftBillVO giftbill) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String conveyBill(GiftBillVO giftbill) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public GiftBillVO checkBill(GiftBillVO giftbill) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public GiftBillVO toBillVO(CommodityList list, long id, String user, String member, int time) {
		// TODO Auto-generated method stub
		giftbill=new GiftBillVO(id, user, list, time);
		return giftbill;
	}


	@Override
	public ArrayList<CommodityLineItem> getCommoditys(String field) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addCommodityItem(CommodityLineItem item) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteCommodityItem(CommodityLineItem item) {
		// TODO Auto-generated method stub
		
	}
	
}
