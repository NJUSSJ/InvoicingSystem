package po;

import java.io.Serializable;

public class UserPO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long id;
	String password;
	int rank;
	String username;
	
	public UserPO(long id,String password,int rank,String username ) {
		this.id=id;
		this.password=password;
		this.rank=rank;
		this.username=username;
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
	public String getUserName() {
		return username;
	}
	
	
	
}