package businesslogic.billbl;

import businesslogicservice.billblservice.PayBillBLService;
import vo.MemberVO;
import vo.PayBillVO;

public class PayBill  implements PayBillBLService{

	PayBillVO paybill;
	MemberVO member;
	
	
	public PayBill(long id, String user, String member, int sum, int time) {
		// TODO Auto-generated constructor stub
		
		this.paybill=new MockPayBillVO(member, sum);
     	this.member=new MockMemberVO(member, 1000);
	}

	@Override
	public PayBillVO toBillVO(long id, String user, String member, int sum, int time) {
		// TODO Auto-generated method stub
		return paybill;
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
		member=new MockMemberVO(paybill.getMember(), 1000);
		member.setShouldPay(1000-paybill.getSum());
	}
	public MemberVO getMember() {
		return member;
	}
	
	public void updateAccount() {
		
	}
}
