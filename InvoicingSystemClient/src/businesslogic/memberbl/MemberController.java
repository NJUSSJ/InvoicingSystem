package businesslogic.memberbl;

import java.util.ArrayList;

import businesslogicservice.memberblservice.MemberBLService;
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
	public MemberVO findMember(String name) {
		// TODO 自动生成的方法存根
		return memberImpl.findMember(name);
	}

	@Override
	public boolean updateMember(MemberVO a) {
		// TODO 自动生成的方法存根
		return memberImpl.updateMember(a);
	}

	@Override
	public ArrayList<MemberVO> findMembers(String field) {
		// TODO 自动生成的方法存根
		return memberImpl.findMembers(field);
	}
	
}
