package businesslogicservice.memberblservice;

import java.util.ArrayList;

import vo.MemberVO;

public interface MemberBLService {

	public MemberVO addmember(MemberVO a);
	public MemberVO deletemember(MemberVO a);
	public MemberVO findmember(String name);
	public MemberVO updatemember(MemberVO a);
	public ArrayList<MemberVO> findMembers(String field);
}
