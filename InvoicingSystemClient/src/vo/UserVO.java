package vo;

public class UserVO {
	long id;
	String password;
	int  rank;
	String username;
	
	public UserVO(long id,String password,int rank,String username ) {
		this.id=id;
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
	
	public long getID(){
		return id;
	}
}