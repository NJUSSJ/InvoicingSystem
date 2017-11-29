package businesslogic.billbl;

import java.sql.Date;

import businesslogicservice.billblservice.PayBillBLService;
import vo.MemberVO;
import vo.PayBillVO;

public class PayBill  implements PayBillBLService{

	@Override
	public PayBillVO toBillVO(String id, long userid, long memberid, int sum, Date time,int state) {
		// TODO Auto-generated method stub
		return new PayBillVO(id,userid,memberid,sum,time,state);
	}

	@Override
	public String conveyBill(PayBillVO paybill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PayBillVO checkBill() {
		// TODO Auto-generated method stub
		paybill.setState(true);
		updateMember();
		return paybill;
	}
	
	public void updateMember() {
		member=new MockMemberVO(paybill.getMemberID(), 1000);
		member.setShouldPay(1000-paybill.getSum());
	}
	public MemberVO getMember() {
		return member;
	}
	
	public void updateAccount() {
		
	}
}
