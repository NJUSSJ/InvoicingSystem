package dataservice.billdataservice;

import java.util.ArrayList;

import po.GiftBillPO;

public interface giftbilldataservice {
	public GiftBillPO findGiftBillbyState(int state);
	public ArrayList<GiftBillPO> findGiftBills();
	public boolean insert(GiftBillPO giftbill);
}
