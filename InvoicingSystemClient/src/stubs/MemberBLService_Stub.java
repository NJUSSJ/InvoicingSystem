package stubs;

import java.util.ArrayList;

import businesslogicservice.memberblservice.MemberBLService;
import vo.MemberVO;
import vo.UserVO;

public class MemberBLService_Stub implements MemberBLService{
	MemberVO mv;
	String number;
	String name;
	String category;
	String phoneNum;
	int rank;
	String address;
	int postCode;
	String e_mail;
	int should_pay;
	int should_get;
	UserVO default_operator;
	
	public MemberBLService_Stub(String number,String name,String category,String phoneNum,int rank,String address,int postCode,String e_mail,int should_pay,int should_get){
		this.number=number;
		this.name=name;
		this.category=category;
		this.phoneNum=phoneNum;
		this.rank=rank;
		this.address=address;
		this.postCode=postCode;
		this.e_mail=e_mail;
		this.should_pay=should_pay;
		this.should_get=should_get;
	}
	
	
	@Override
	public boolean addMember(MemberVO a) {
		// TODO Auto-generated method stub
		System.out.println("add member");
		return false;
	}

	@Override
	public boolean deleteMember(MemberVO a) {
		// TODO Auto-generated method stub
		System.out.println("delete member");
		return false;
	}

	@Override
	public MemberVO findMember(String name) {
		// TODO Auto-generated method stub
		System.out.println("find member");
		return null;
	}

	@Override
	public boolean updateMember(MemberVO a) {
		// TODO Auto-generated method stub
		System.out.println("update member");
		return false;
	}

	@Override
	public ArrayList<MemberVO> findMembers(String field) {
		// TODO Auto-generated method stub
		System.out.println("find members");
		return null;
	}

	
}
