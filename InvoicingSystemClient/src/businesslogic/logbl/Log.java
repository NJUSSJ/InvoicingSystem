package businesslogic.logbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.logblservice.LogBLService;
import po.LogPO;
import rmi.RemoteHelper;
import vo.LogVO;

public class Log{
	public boolean addLog(LogVO vo){
		return false;
	}
	public ArrayList<LogVO> findLog(){
		return null;
	}
}
