package Client.businesslogicservice.memberblservice;

import Client.vo.MemberVO;

public interface MemberBLService {

	public MemberVO addmember(MemberVO a);
	public MemberVO deletemember(MemberVO a);
	public MemberVO findmember(MemberVO a);
	public MemberVO updatemember(MemberVO a);
	
}
