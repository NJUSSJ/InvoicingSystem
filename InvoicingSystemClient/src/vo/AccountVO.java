package vo;

public class AccountVO {
	long ID;
	double deposit;
	String Bank;
	
	public AccountVO(long ID,
	double deposit,
	String Bank
	) {
		// TODO Auto-generated constructor stub
		this.ID=ID;
		this.Bank=Bank;
		this.deposit=deposit;
	}

	public AccountVO() {
		// TODO �Զ����ɵĹ��캯�����
	}
}
