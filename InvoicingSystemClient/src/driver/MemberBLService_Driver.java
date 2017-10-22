package driver;

import stubs.MemberBLService_Stub;
import vo.CategoryVO;
import vo.MemberVO;

public class MemberBLService_Driver {
	public void drive(MemberBLService_Stub memberblservice) {
		memberblservice.deletemember(new MemberVO());
		memberblservice.addmember(new MemberVO());
		memberblservice.getMember("1234");
		memberblservice.getMemberList("1234");
		memberblservice.modifyCategory(new CategoryVO());
		memberblservice.modifymember(new MemberVO());
		
	}
	
		
	
}
