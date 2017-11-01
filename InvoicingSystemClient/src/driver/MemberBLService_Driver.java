package driver;

import stubs.MemberBLService_Stub;
import vo.MemberVO;

public class MemberBLService_Driver {
	public void drive(MemberBLService_Stub memberblservice) {
		memberblservice.deletemember(new MemberVO());
		memberblservice.addmember(new MemberVO());
		memberblservice.findmember("123");
		memberblservice.updatemember(new MemberVO());
		memberblservice.findMembers("123");
	}
	
		
	
}
