package po;

import java.io.Serializable;

public class MemberPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3733425838145157672L;
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
	
	public MemberPO(long id,int rank,int postCode,int category,String name,int phoneNum,
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
	
	public MemberPO() {
		// TODO Auto-generated constructor stub
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
	
	public long getID() {
		return id;
	}
	
	public int getRank() {
		return rank;
	}
	
	public int getPostcode() {
		return postCode;
	}
	
	public int getCategory() {
		return category;
	}
	
	public int getPhone() {
		return phoneNum;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getEmail() {
		return eMail;
	}
	
	public double getShoubleGet() {
		return shouldGet;
	}
	
	public void setShouldGet(double get) {
		this.shouldGet=get;
	}
			
	public double getQuota() {
		return quota;
	}
	
	public long getOperator() {
		return defaultOperatorID;
	}
	
	
	
}
