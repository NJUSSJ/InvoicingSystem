package Client.vo;

import java.sql.Time;

public class table_saleDetails {
	Time t;
	commodityVO commodity;
	String memberName;
	String userName;
	String warehouseName;
	int total_num;
	
	public table_saleDetails(Time t,commodityVO commodity,String memberName,String userName,String warehouseName,int total_num) {
		this.commodity=commodity;
		this.t=t;
		this.memberName=memberName;
		this.userName=userName;
		this.warehouseName=warehouseName;
		this.total_num=total_num;
	}
}
