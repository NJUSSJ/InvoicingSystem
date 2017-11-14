package vo;

public class MemberVO {
	String name;
	String category;
	String phoneNum;
	int rank;
	String address;
	int postCode;
	String e_mail;
	double should_pay;
	double should_get;
	UserVO default_operator;
	
	public MemberVO(String name,String category,String phoneNum,int rank,String address,int postCode,String e_mail,
			int should_pay,int should_get,
	UserVO default_operator) {
		this.address=address;
		this.category=category;
		this.default_operator=default_operator;
		this.e_mail=e_mail;
		this.name=name;
		this.phoneNum=phoneNum;
		this.postCode=postCode;
		this.rank=rank;
		this.should_get=should_get;
		this.should_pay=should_pay;
	}
	public MemberVO() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	public double getShouldPay() {
		return should_pay;
	}
	
	public void setShouldPay(double shouldPay) {
		this.should_pay=shouldPay;
	}
}
