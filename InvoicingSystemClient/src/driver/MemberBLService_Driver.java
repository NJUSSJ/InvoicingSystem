package driver;

import stubs.MemberBLService_Stub;
import vo.MemberVO;

public class MemberBLService_Driver {
	public void drive(MemberBLService_Stub memberblservice) {
		memberblservice.deleteMember(new MemberVO(0, 0, 0, 0, null, 0, null, null, 0, 0, 0, 0));
		memberblservice.addMember(new MemberVO(0, 0, 0, 0, null, 0, null, null, 0, 0, 0, 0));
		memberblservice.findMember("123");
		memberblservice.updateMember(new MemberVO(0, 0, 0, 0, null, 0, null, null, 0, 0, 0, 0));
		memberblservice.findMembers("123");
	}
	
		
	
}
