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
		// TODO 自动生成的构造函数存根
	}
}