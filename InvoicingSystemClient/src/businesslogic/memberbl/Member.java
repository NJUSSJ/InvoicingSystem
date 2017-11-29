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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteMember(MemberVO a) {
		// TODO Auto-generated method stub
		MemberPO tmpUserPO=a.toPO();
		try {
			return RemoteHelper.getInstance().getMemberDataService().delete(tmpUserPO);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	public MemberVO findMember(String name) {
		// TODO Auto-generated method stub
		try {
			MemberPO tmpPO=RemoteHelper.getInstance().getMemberDataService().find(name);
			return new MemberVO();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateMember(MemberVO a) {
		// TODO Auto-generated method stub
		MemberPO tmpMemberPO=a.toPO();
		try {
			return RemoteHelper.getInstance().getMemberDataService().update(tmpMemberPO);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<MemberVO> findMembers(String field) {
		// TODO Auto-generated method stub
		return null;
	}

}
