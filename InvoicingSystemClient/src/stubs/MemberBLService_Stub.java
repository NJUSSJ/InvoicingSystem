package stubs;

import java.util.ArrayList;

import vo.CategoryVO;
import vo.MemberVO;
import vo.UserVO;

public class MemberBLService_Stub {
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
	
	public void addmember(MemberVO a){
		System.out.println("Add successfully");
	}
	
	public void deletemember(MemberVO a){
		System.out.println("Delete successfully");
	}
	
	public void modifymember(MemberVO a){
		System.out.println("Modify successfully");
	}
	
	public MemberVO getMember(String number){
		return null;
	}
	
	public ArrayList<MemberVO> getMemberList(String category) {
		return null;
	}

	public String modifyCategory(CategoryVO c) {
		return null;
	}

	
}
