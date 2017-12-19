package businesslogicservice.billblservice;

import java.sql.Date;
import java.util.ArrayList;

import po.GiftBillPO;
import vo.GiftBillVO;

public interface GiftBillBLService {
	public GiftBillVO toGiftBillVO (GiftBillPO giftBillPO);
	public boolean submitGiftBill(GiftBillVO giftBill);
	public boolean checkGiftBill(boolean pass,long id);
	public boolean deleteGiftBill(GiftBillVO giftBill);
	public ArrayList<GiftBillVO> findGiftBillByTime(Date time);
	public ArrayList<GiftBillVO> findGiftBills();
	public ArrayList<GiftBillVO> findGiftBillsByInterval(Date begin,Date end);
	public ArrayList<GiftBillVO> findGiftBillsByField(Date begin,Date end,String memberName,String userName);
	public ArrayList<GiftBillVO> findGiftBillsByState(int state);
	public ArrayList<GiftBillVO> findGiftBillsByUser(long userid);
}
