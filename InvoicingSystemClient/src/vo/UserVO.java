package vo;

public class UserVO {
	long ID;
	String password;
	String rank;
	
	public UserVO(long ID,String password,String rank) {
		this.ID=ID;
		this.password=password;
		this.rank=rank;
	}

	public UserVO() {
		// TODO �Զ����ɵĹ��캯�����
	}
}