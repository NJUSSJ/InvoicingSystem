package businesslogic.billbl;

import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.billblservice.GiftBillBLService;
import po.GiftBillPO;
import vo.GiftBillVO;

public class GiftBillController implements GiftBillBLService{
	GiftBill giftBillImpl=new GiftBill();
	@Override
	public GiftBillVO toGiftBillVO(GiftBillPO giftBillPO) {
		return giftBillImpl.toGiftBillVO(giftBillPO);
	}

	@Override
	public boolean submitGiftBill(GiftBillVO giftBill) {
		return giftBillImpl.submitGiftBill(giftBill);
	}

	@Override
	public boolean checkGiftBill(boolean pass, long id) {
		return giftBillImpl.checkGiftBill(pass, id);
	}

	@Override
	public boolean deleteGiftBill(GiftBillVO giftBill) {
		return giftBillImpl.deleteGiftBill(giftBill);
	}

	@Override
	public ArrayList<GiftBillVO> findGiftBillByTime(Date time) {
		return giftBillImpl.findGiftBillByTime(time);
	}

	@Override
	public ArrayList<GiftBillVO> findGiftBills() {
		return giftBillImpl.findGiftBills();
	}

	@Override
	public ArrayList<GiftBillVO> findGiftBillsByInterval(Date begin, Date end) {
		return giftBillImpl.findGiftBillByInterval(begin, end);
	}

}
