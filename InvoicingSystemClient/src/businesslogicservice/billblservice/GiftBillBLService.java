package businesslogicservice.billblservice;

import java.sql.Date;
import java.util.ArrayList;

import businesslogic.billbl.CommodityLineItem;
import businesslogic.billbl.CommodityList;
import vo.GiftBillVO;

public interface GiftBillBLService {
	public GiftBillVO toBillVO(CommodityList list,long id,long userid,long memberid,Date time);
	public GiftBillVO updateGiftbill(GiftBillVO giftbill);
	public String conveyBill(GiftBillVO giftbill) ;
	public GiftBillVO checkBill(GiftBillVO giftbill);
	public ArrayList<CommodityLineItem> getCommoditys(String field);
	public void addCommodityItem(CommodityLineItem item);
	public void deleteCommodityItem(CommodityLineItem item);
}
