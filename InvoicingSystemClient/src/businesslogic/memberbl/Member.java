package businesslogic.memberbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.MemberPO;
import rmi.RemoteHelper;
import vo.MemberVO;

public class Member{

	public boolean addMember(MemberVO a) {
		MemberPO tmpUserPO=a.toPO();
		try {
			return RemoteHelper.getInstance().getMemberDataService().insert(tmpUserPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteMember(MemberVO a) {
		MemberPO tmpUserPO=a.toPO();
		try {
			return RemoteHelper.getInstance().getMemberDataService().delete(tmpUserPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public MemberVO findMemberByName(String name) {
		try {
			MemberPO tmpPO=RemoteHelper.getInstance().getMemberDataService().findMemberbyName(name);
			return toMemberVO(tmpPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateMember(MemberVO a) {
		MemberPO tmpMemberPO=a.toPO();
		try {
			return RemoteHelper.getInstance().getMemberDataService().update(tmpMemberPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<MemberVO> findMembersByField(String field) {
		ArrayList<MemberVO> temp=null;
		try {
			temp=new ArrayList<MemberVO>();
		ArrayList<MemberPO> members= RemoteHelper.getInstance().getMemberDataService().
					findMembersbyField(field);
			for(int i=0;i<members.size();i++){
			temp.add(toMemberVO(members.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return temp;
	}
	public MemberVO toMemberVO(MemberPO memberPO){
<<<<<<< HEAD
		if(memberPO==null){
			return null;
		}
=======
		if(memberPO==null) return null;
>>>>>>> 7d9e26ce1beddb10fc60803f5c7f1ffd2e98c59b
		return new MemberVO(memberPO.getID(),memberPO.getRank(),memberPO.getPostCode(),
				memberPO.getCategory(),memberPO.getName(),memberPO.getPhoneNum(),
				memberPO.getAddress(),memberPO.getEmail(),memberPO.getShouldPay(),
				memberPO.getShouldGet(),memberPO.getQuota(),memberPO.getDefaultOperatorID());
	}
	public ArrayList<MemberVO> findMembers(){
		ArrayList<MemberVO> temp=null;
		try {
			temp=new ArrayList<MemberVO>();
			ArrayList<MemberPO> members=RemoteHelper.getInstance().getMemberDataService().findMembers();
			for(int i=0;i<members.size();i++){
				temp.add(toMemberVO(members.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} 
		return temp;
	}
	public MemberVO findMemberByID(long id){
		try {
			return toMemberVO(RemoteHelper.getInstance().getMemberDataService().findMemberbyID(id));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}


}
