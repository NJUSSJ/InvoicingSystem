package businesslogicservice.memberblservice;

import java.util.ArrayList;

import vo.MemberVO;

public interface MemberBLService {

	public boolean addMember(MemberVO a);
	public boolean deleteMember(MemberVO a);
	public MemberVO findMember(String name);
	public boolean updateMember(MemberVO a);//��Ʋ���add
	public ArrayList<MemberVO> findMembers(String field);//��Ʋ���find
	
}
