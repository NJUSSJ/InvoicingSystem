package businesslogicservice.memberblservice;

import java.util.ArrayList;

import po.MemberPO;
import vo.MemberVO;

public interface MemberBLService {

	public boolean addMember(MemberVO a);
	public boolean deleteMember(MemberVO a);
	public MemberVO findMemberByName(String name);
	public boolean updateMember(MemberVO a);//设计参照add
	public ArrayList<MemberVO> findMembersByField(String field);//设计参照find
	public MemberVO toMemberVO(MemberPO memberPO);
	public ArrayList<MemberVO> findMembers();
}
