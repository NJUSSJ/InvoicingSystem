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

	public MemberVO findMemberByName(String name) {
		// TODO Auto-generated method stub
		try {
			MemberPO tmpPO=RemoteHelper.getInstance().getMemberDataService().findMemberbyName(name);
			return toMemberVO(tmpPO);
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

	public ArrayList<MemberVO> findMembersByField(String field) {
		// TODO Auto-generated method stub
		ArrayList<MemberVO> temp=null;
		
		try {
			temp=new ArrayList<MemberVO>();
		ArrayList<MemberPO> members= RemoteHelper.getInstance().getMemberDataService().
					findMembersbyField(field);
			for(int i=0;i<members.size();i++){
			temp.add(toMemberVO(members.get(i)));
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return temp;
	}
	public MemberVO toMemberVO(MemberPO memberPO){
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} 
		return temp;
	}

}
