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
	double quota;//”¶ ’∂Ó∂»
	
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
	
	public MemberVO() {
		// TODO Auto-generated constructor stub
	}
	public MemberPO toPO(){
		return new MemberPO(id, rank, postCode, category, name, phoneNum,
				address, eMail, shouldPay,shouldGet, quota, defaultOperatorID);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	public double getShouldPay() {
		return shouldPay;
	}
	
	public void setShouldPay(double shouldPay) {
		this.shouldPay=shouldPay;
	}
}
