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
		// TODO �Զ����ɵķ������
		return giftBillImpl.toGiftBillVO(giftBillPO);
	}

	@Override
	public boolean submitGiftBill(GiftBillVO giftBill) {
		// TODO �Զ����ɵķ������
		return giftBillImpl.submitGiftBill(giftBill);
	}

	@Override
	public boolean checkGiftBill(boolean pass, long id) {
		// TODO �Զ����ɵķ������
		return giftBillImpl.checkGiftBill(pass, id);
	}

	@Override
	public boolean deleteGiftBill(GiftBillVO giftBill) {
		// TODO �Զ����ɵķ������
		return giftBillImpl.deleteGiftBill(giftBill);
	}

	@Override
	public ArrayList<GiftBillVO> findGiftBillByTime(Date time) {
		// TODO �Զ����ɵķ������
		return giftBillImpl.findGiftBillByTime(time);
	}

}
