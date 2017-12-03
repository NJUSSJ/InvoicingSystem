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
	public long getID(){
		return id;
	}
	public String getPassword() {
		return password;
	}
	public int getRank() {
		return rank;
	}
	public String getUsername() {
		return username;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public void setRank(int rank){
		this.rank=rank;
	}
	public void setUsername(String username){
		this.username=username;
	}

}