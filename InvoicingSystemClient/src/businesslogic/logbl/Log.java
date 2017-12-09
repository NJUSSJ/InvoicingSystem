package businesslogic.logbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LogPO;
import rmi.RemoteHelper;
import vo.LogVO;

public class Log{
	public boolean addLog(LogVO vo) {
		// TODO �Զ����ɵķ������
		try {
			return RemoteHelper.getInstance().getLogDataService().insert(vo.toLogPO());
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}
	public ArrayList<LogVO> findLogs() {
		// TODO �Զ����ɵķ������
		ArrayList<LogVO> temp=null;
		ArrayList<LogPO> logs;
		try {
			temp=new ArrayList<LogVO>();
			logs = RemoteHelper.getInstance().getLogDataService().findLogs();
			for(int i=0;i<logs.size();i++){
				temp.add(toLogVO(logs.get(i)));
			}
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return temp;
	}
	public ArrayList<LogVO> findLogByUserID(long userid) {
		// TODO �Զ����ɵķ������
		ArrayList<LogVO> temp=null;
		ArrayList<LogPO> logs;
		try {
			temp=new ArrayList<LogVO>();
			logs = RemoteHelper.getInstance().getLogDataService().findLogbyOperator(userid);
			for(int i=0;i<logs.size();i++){
				temp.add(toLogVO(logs.get(i)));
			}
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return temp;
	}
	public ArrayList<LogVO> findLogByType(String type) {
		// TODO �Զ����ɵķ������
		ArrayList<LogVO> temp=null;
		ArrayList<LogPO> logs;
		try {
			temp=new ArrayList<LogVO>();
			logs = RemoteHelper.getInstance().getLogDataService().findLogbyType(type);
			for(int i=0;i<logs.size();i++){
			temp.add(toLogVO(logs.get(i)));
			}
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return temp;
	}
	public LogVO toLogVO(LogPO logPO){
		return new LogVO(logPO.getID(),logPO.getTime(),logPO.getType(),logPO.getUserID());
	}
}
