package businesslogic.billbl;

import businesslogicservice.billblservice.PayBillBLService;
import vo.PayBillVO;

public class PayBill  implements PayBillBLService{

	MockPayBillVO paybill;
	MockMemberVO mockmember;
	
	
	public PayBill(long id, String user, String member, int sum, int time) {
		// TODO Auto-generated constructor stub
		
		this.paybill=new MockPayBillVO(member, sum);
     	mockmember=new MockMemberVO(member, 1000);
	}

	@Override
	public MockPayBillVO toBillVO(long id, String user, String member, int sum, int time) {
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
		mockmember=new MockMemberVO(paybill.getMember(), 1000);
		mockmember.setShouldPay(1000-paybill.getSum());
	}
	public MockMemberVO getMember() {
		return mockmember;
	}
	
}
