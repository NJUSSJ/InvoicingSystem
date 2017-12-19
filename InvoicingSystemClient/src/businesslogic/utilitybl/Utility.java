package businesslogic.utilitybl;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {
	public static long creatID(){
		Date now=getNow();
		long id=Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmss").format(now));
		return id;
	}
	public static Date getNow(){
		return new Date();
	}
	private Utility(){
	}
}
