package vo;

public class UserVO {
	long ID;
	String password;
	int  rank;
	String username;
	
	public UserVO(long ID,String password,int  rank,String username ) {
		this.ID=ID;
		this.password=password;
		this.rank=rank;
		this.username=username;
	}

	public UserVO() {
		// TODO �Զ����ɵĹ��캯�����
	}
	
	public String getUsername() {
		return username;
	}
	
	public int getRank() {
		return rank;
	}
	
	public String getPassword() {
		return password;
	}
}