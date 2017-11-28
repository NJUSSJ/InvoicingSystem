package businesslogic.billbl;

import java.sql.Date;
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


	@Override
	public GiftBillVO toBillVO(CommodityList list, long id, long userid, long memberid, Date time) {
		// TODO Auto-generated method stub
		GiftBillVO giftbill=new GiftBillVO(id, userid, memberid, list, time);
		return giftbill;
	}


	
	
}
