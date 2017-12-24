package po;

import java.io.Serializable;
import java.sql.Date;

public class BookPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Date time;
	String commodityList;
	String memberList;
	String accountList;
	
	public BookPO(Date time,String commodityList,String memberList,String accountList) {
		this.accountList=accountList;
		this.memberList=memberList;
		this.commodityList=commodityList;
		this.time=time;
	}
	
	public Date getDate() {
		return time;
	}
	
	public String getCommodity() {
		return commodityList;
	}
	
	public String getMember() {
		return memberList;
	}
	
	public String getAccount() {
		return accountList;
	}

}