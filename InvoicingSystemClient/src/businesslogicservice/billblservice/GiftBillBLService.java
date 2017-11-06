package businesslogicservice.billblservice;

import vo.BillVO;
import vo.GiftBillVO;

public interface GiftBillBLService {
	public BillVO makeGiftbill(BillVO bill);
	public GiftBillVO updateGiftbill(GiftBillVO giftbill);
}
