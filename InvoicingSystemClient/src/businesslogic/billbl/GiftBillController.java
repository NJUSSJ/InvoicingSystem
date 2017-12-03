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
		// TODO 自动生成的方法存根
		return giftBillImpl.toGiftBillVO(giftBillPO);
	}

	@Override
	public boolean submitGiftBill(GiftBillVO giftBill) {
		// TODO 自动生成的方法存根
		return giftBillImpl.submitGiftBill(giftBill);
	}

	@Override
	public boolean checkGiftBill(boolean pass, long id) {
		// TODO 自动生成的方法存根
		return giftBillImpl.checkGiftBill(pass, id);
	}

	@Override
	public boolean deleteGiftBill(GiftBillVO giftBill) {
		// TODO 自动生成的方法存根
		return giftBillImpl.deleteGiftBill(giftBill);
	}

	@Override
	public ArrayList<GiftBillVO> findGiftBillByTime(Date time) {
		// TODO 自动生成的方法存根
		return giftBillImpl.findGiftBillByTime(time);
	}

}
