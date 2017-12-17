package Utility;

import java.util.Date;

public class DateUtil {
	static Date date=new Date();
	
	public static java.sql.Date toSQL(String year,String month,String day) {
		date.setYear(Integer.parseInt(year)-1900);
		date.setMonth(Integer.parseInt(month)-1);
		date.setDate(Integer.parseInt(day));
		
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		return sqlDate;
	}
	
	public static java.sql.Date toSQL(Date date){
		return new java.sql.Date(date.getTime());
	}
}
