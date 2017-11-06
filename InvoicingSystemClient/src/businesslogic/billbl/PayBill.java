package businesslogic.billbl;

import businesslogic.memberbl.Member;
import businesslogicservice.billblservice.PayBillBLService;
import po.PayBillPO;
import vo.PayBillVO;

public class PayBill extends Bill implements PayBillBLService{
	Member m;
	
	
	public PayBillPO makePaybill(PayBillVO vo){
		return null;
	}
	
	
}
