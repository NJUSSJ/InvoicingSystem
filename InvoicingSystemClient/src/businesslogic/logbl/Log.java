package businesslogic.logbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LogPO;
import rmi.RemoteHelper;
import vo.LogVO;

public class Log{
	public boolean addLog(LogVO vo) {
		// TODO 自动生成的方法存根
		try {
			return RemoteHelper.getInstance().getLogDataService().insert(vo.toLogPO());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	public ArrayList<LogVO> findLogs() {
		// TODO 自动生成的方法存根
		ArrayList<LogVO> temp=null;
		ArrayList<LogPO> logs;
		try {
			temp=new ArrayList<LogVO>();
			logs = RemoteHelper.getInstance().getLogDataService().findLogs();
			for(int i=0;i<logs.size();i++){
				temp.add(toLogVO(logs.get(i)));
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return temp;
	}
	public ArrayList<LogVO> findLogByUserID(long userid) {
		// TODO 自动生成的方法存根
		ArrayList<LogVO> temp=null;
		ArrayList<LogPO> logs;
		try {
			temp=new ArrayList<LogVO>();
			logs = RemoteHelper.getInstance().getLogDataService().findLogbyOperator(userid);
			for(int i=0;i<logs.size();i++){
				temp.add(toLogVO(logs.get(i)));
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return temp;
	}
	public ArrayList<LogVO> findLogByType(String type) {
		// TODO 自动生成的方法存根
		ArrayList<LogVO> temp=null;
		ArrayList<LogPO> logs;
		try {
			temp=new ArrayList<LogVO>();
			logs = RemoteHelper.getInstance().getLogDataService().findLogbyType(type);
			for(int i=0;i<logs.size();i++){
			temp.add(toLogVO(logs.get(i)));
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return temp;
	}
	public LogVO toLogVO(LogPO logPO){
		return new LogVO(logPO.getID(),logPO.getTime(),logPO.getType(),logPO.getUserID());
	}
}
