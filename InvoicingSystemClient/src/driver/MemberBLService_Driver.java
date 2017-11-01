package driver;

import stubs.MemberBLService_Stub;
import vo.MemberVO;

public class MemberBLService_Driver {
	public void drive(MemberBLService_Stub memberblservice) {
		memberblservice.deleteMember(new MemberVO());
		memberblservice.addMember(new MemberVO());
		memberblservice.findMember("123");
		memberblservice.updateMember(new MemberVO());
		memberblservice.findMembers("123");
	}
	
		
	
}
