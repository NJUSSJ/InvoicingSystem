package businesslogic.memberbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.MemberPO;
import rmi.RemoteHelper;
import vo.MemberVO;

public class Member{

	public boolean addMember(MemberVO a) {
		// TODO Auto-generated method stub
		MemberPO tmpUserPO=a.toPO();
		try {
			return RemoteHelper.getInstance().getMemberDataService().insert(tmpUserPO);
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteMember(MemberVO a) {
		// TODO Auto-generated method stub
		return false;
	}

	public MemberVO findMember(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateMember(MemberVO a) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<MemberVO> findMembers(String field) {
		// TODO Auto-generated method stub
		return null;
	}

}
