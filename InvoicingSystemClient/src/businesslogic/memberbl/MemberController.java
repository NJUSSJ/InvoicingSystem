package businesslogic.memberbl;

import java.util.ArrayList;

import businesslogicservice.memberblservice.MemberBLService;
import po.MemberPO;
import vo.MemberVO;

public class MemberController implements MemberBLService{
	Member memberImpl=new Member();
	@Override
	public boolean addMember(MemberVO a) {
		// TODO 自动生成的方法存根
		return memberImpl.addMember(a);
	}

	@Override
	public boolean deleteMember(MemberVO a) {
		// TODO 自动生成的方法存根
		return memberImpl.deleteMember(a);
	}

	@Override
	public MemberVO findMemberByName(String name) {
		// TODO 自动生成的方法存根
		return memberImpl.findMemberByName(name);
	}

	@Override
	public boolean updateMember(MemberVO a) {
		// TODO 自动生成的方法存根
		return memberImpl.updateMember(a);
	}

	@Override
	public ArrayList<MemberVO> findMembersByField(String field) {
		return memberImpl.findMembersByField(field);
	}

	@Override
	public MemberVO toMemberVO(MemberPO memberPO) {
		// TODO 自动生成的方法存根
		return memberImpl.toMemberVO(memberPO);
	}

	@Override
	public ArrayList<MemberVO> findMembers() {
		// TODO 自动生成的方法存根
		return memberImpl.findMembers();
	}

	@Override
	public MemberVO findMemberByID(long id) {
		// TODO 自动生成的方法存根
		return memberImpl.findMemberByID(id);
	}
	
}
