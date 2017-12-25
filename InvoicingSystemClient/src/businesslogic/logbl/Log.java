package businesslogic.logbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LogPO;
import rmi.RemoteHelper;
import vo.LogVO;

public class Log{
	public boolean addLog(LogVO vo) {
		try {
			return RemoteHelper.getInstance().getLogDataService().insert(vo.toLogPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	public ArrayList<LogVO> findLogs() {
		ArrayList<LogVO> temp=null;
		ArrayList<LogPO> logs;
		try {
			temp=new ArrayList<LogVO>();
			logs = RemoteHelper.getInstance().getLogDataService().findLogs();
			for(int i=0;i<logs.size();i++){
				temp.add(toLogVO(logs.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return temp;
	}
	public ArrayList<LogVO> findLogByUserID(long userid) {
		ArrayList<LogVO> temp=null;
		ArrayList<LogPO> logs;
		try {
			temp=new ArrayList<LogVO>();
			logs = RemoteHelper.getInstance().getLogDataService().findLogbyOperator(userid);
			for(int i=0;i<logs.size();i++){
				temp.add(toLogVO(logs.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return temp;
	}
	public ArrayList<LogVO> findLogByType(String field) {
		ArrayList<LogVO> temp=null;
		ArrayList<LogPO> logs;
		try {
			temp=new ArrayList<LogVO>();
			logs = RemoteHelper.getInstance().getLogDataService().findLogbyType(field);
			for(int i=0;i<logs.size();i++){
			temp.add(toLogVO(logs.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return temp;
	}
	public LogVO toLogVO(LogPO logPO){
		if(logPO==null){
			return null;
		}
		return new LogVO(logPO.getID(),logPO.getTime(),logPO.getType(),logPO.getUserID());
	}
	public long findLargestID(){
		try {
			return RemoteHelper.getInstance().getLogDataService().getLargestIDofLog();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
