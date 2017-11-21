package po;

import java.io.Serializable;

public class UserPO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long ID;
	String password;
	int  rank;
	String username;
	
	public UserPO(long ID,String password,int  rank,String username ) {
		this.ID=ID;
		this.password=password;
		this.rank=rank;
		this.username=username;
	}

	public UserPO() {
		// TODO �Զ����ɵĹ��캯�����
	}
	
	public long getID() {
		return ID;
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