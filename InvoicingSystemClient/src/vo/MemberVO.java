package vo;

import po.MemberPO;

public class MemberVO {
	long id;
	int rank;
	int postCode;
	int category;
	long defaultOperatorID;
	String name;
	int phoneNum;
	String address;
	String eMail;
	double shouldPay;
	double shouldGet;
	double quota;//Ӧ�ն��
	
	public MemberVO(long id,int rank,int postCode,int category,String name,int phoneNum,
	String address,String eMail,double shouldPay,double shouldGet,double quota,long defaultOperatorID){
		this.id=id;
		this.rank=rank;
		this.postCode=postCode;
		this.category=category;
		this.name=name;
		this.phoneNum=phoneNum;
		this.address=address;
		this.eMail=eMail;
		this.shouldPay=shouldPay;
		this.shouldGet=shouldGet;
		this.quota=quota;
		this.defaultOperatorID=defaultOperatorID;
	}
	
	public MemberPO toPO(){
		return new MemberPO(id, rank, postCode, category, name, phoneNum,
				address, eMail, shouldPay,shouldGet, quota, defaultOperatorID);
	}
	
	public String getName() {
		return name;
	}
	public int getPhoneNum(){
		return phoneNum;
	}
	public String getAddress(){
		return address;
	}
	public String getEmail(){
		return eMail;
	}
	public double getShouldPay() {
		return shouldPay;
	}
	public double getShouldGet(){
		return shouldGet;
	}
	public double getQuota(){
		return quota;
	}
	public long getID(){
		return id;
	}
	public int getRank(){
		return rank;
	}
	public int getPostCode(){
		return postCode;
	}
	public int getCategory(){
		return category;
	}
	public long getDefaultOperatorID(){
		return defaultOperatorID;
	}
}
