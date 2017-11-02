package businesslogicservice.memberblservice;

import java.util.ArrayList;

import vo.MemberVO;

public interface MemberBLService {

	public MemberVO addMember(MemberVO a);
	public MemberVO deleteMember(MemberVO a);
	public MemberVO findMember(String name);
	public MemberVO updateMember(MemberVO a);//设计参照add
	public ArrayList<MemberVO> findMembers(String field);//设计参照find
	
}
