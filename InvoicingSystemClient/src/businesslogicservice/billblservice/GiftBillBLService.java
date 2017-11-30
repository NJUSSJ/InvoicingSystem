package businesslogicservice.billblservice;

import po.GiftBillPO;
import vo.GiftBillVO;

public interface GiftBillBLService {
	public GiftBillVO toBillVO(GiftBillPO po);
	public String conveyBill(GiftBillVO giftbill) ;
	public GiftBillVO checkBill(GiftBillVO giftbill);
}
