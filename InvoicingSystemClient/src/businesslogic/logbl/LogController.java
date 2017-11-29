package businesslogic.logbl;

import vo.LogVO;

public class LogController {
	Log logImpl=new Log();
	public boolean addRecord(LogVO vo){
		return logImpl.addRecord(vo);
	}
	public String checkRecord(){
		return null;
	}
}
