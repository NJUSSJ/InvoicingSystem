package businesslogicservice.billblservice;

import java.sql.Date;
import java.util.ArrayList;

import businesslogic.billbl.CommodityLineItem;
import businesslogic.billbl.CommodityList;
import po.GiftBillPO;
import vo.GiftBillVO;

public interface GiftBillBLService {
	public GiftBillVO toBillVO(GiftBillPO po);
	public String conveyBill(GiftBillVO giftbill) ;
	public GiftBillVO checkBill(GiftBillVO giftbill);
}
