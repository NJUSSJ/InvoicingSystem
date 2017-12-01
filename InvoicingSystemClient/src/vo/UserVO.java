package vo;

import po.UserPO;

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

	public UserPO toUserPO(){
		return new UserPO(id,password,rank,username);
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