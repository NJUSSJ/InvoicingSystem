package businesslogic.memberbl;

import java.util.ArrayList;

import businesslogicservice.memberblservice.MemberBLService;
import vo.MemberVO;

public class MemberController implements MemberBLService{
	Member memberImpl=new Member();
	@Override
	public boolean addMember(MemberVO a) {
		// TODO �Զ����ɵķ������
		return memberImpl.addMember(a);
	}

	@Override
	public boolean deleteMember(MemberVO a) {
		// TODO �Զ����ɵķ������
		return memberImpl.deleteMember(a);
	}

	@Override
	public MemberVO findMember(String name) {
		// TODO �Զ����ɵķ������
		return memberImpl.findMember(name);
	}

	@Override
	public boolean updateMember(MemberVO a) {
		// TODO �Զ����ɵķ������
		return memberImpl.updateMember(a);
	}

	@Override
	public ArrayList<MemberVO> findMembers(String field) {
		// TODO �Զ����ɵķ������
		return memberImpl.findMembers(field);
	}
	
}
