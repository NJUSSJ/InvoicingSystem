package po;

import java.io.Serializable;

public class UserPO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long id;
	String password;
	int  rank;
	String username;
	
	public UserPO(long id,String password,int  rank,String username ) {
		this.id=id;
		this.password=password;
		this.rank=rank;
		this.username=username;
	}

	public UserPO() {
		// TODO 自动生成的构造函数存根
	}
	
	public long getID() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public int getRank() {
		return rank;
	}
	
	public String getName() {
		return username;
	}
	
	
	
}
