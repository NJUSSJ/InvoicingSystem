package po;

import java.io.Serializable;
import java.sql.Date;





public class ImportBillPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	long userid;
	long memberid;
	String commodityList;
	double sum;
	int state;
	Date time;
	int num;
	String remark;
	
	public ImportBillPO(String id,long userid,long memberid,String commodityList,
			double sum,Date time,int state,int num,String remark) {
		// TODO Auto-generated constructor stub
		this.commodityList=commodityList;
		this.id=id;
		this.memberid=memberid;
		this.userid=userid;
		this.sum=sum;	
		this.state=state;
		this.time=time;
		this.num=num;
		this.remark=remark;
	}
	public String getID() {
		return id;
	}
	public long getUserID() {
		return userid;
	}
	public long getMemberID() {
		return memberid;
	}
	public String getCommodityList(){
		return commodityList;
	}
	public double getSum() {
		return sum;
	}
	public int getState() {
		return state;
	}
	public Date getTime() {
		return time;
	}
	public int getNum(){
		return num;
	}
	public String getRemark(){
		return remark;
	}
	
}
