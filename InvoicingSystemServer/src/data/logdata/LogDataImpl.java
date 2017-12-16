package data.logdata;

import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.datafactory.DataFactory;
import dataservice.logdataservice.LogDataService;
import po.LogPO;

public class LogDataImpl implements LogDataService {

	/**
	 * TODO ������һ��������¼
	 */
	@Override
	public boolean insert(LogPO po) throws RemoteException {
		
		String sql="insert into logs (id,time,type,userid) "
				+ "values "
				+ "('"+po.getID()+"','"+po.getTime()+"','"+po.getType()+"','"+po.getUserID()+"')";
		try {
			if(DataFactory.statement.executeUpdate(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 *  TODO ��ȡ������¼��
	 */
	@Override
	public ArrayList<LogPO> findLogs() throws RemoteException {
		
		String sql="select * from logs";
		ArrayList<LogPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				long id=result.getLong("id");
				Date time=result.getDate("time");
				String type=result.getString("type");
				long userid=result.getLong("userid");
				
				LogPO tmpLog=new LogPO(id, time, type, userid);
				
				results.add(tmpLog);
			}
			
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	/**
	 *  TODO ���ݲ���Ա���Ҳ�����¼
	 */
	@Override
	public ArrayList<LogPO> findLogbyOperator(long operatorID) throws RemoteException {
		
		String sql="select * from logs where userid="+operatorID;
		ArrayList<LogPO> results=new ArrayList<>();
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			while(result.next()) {
				long id=result.getLong("id");
				Date time=result.getDate("time");
				String type=result.getString("type");
				long userid=result.getLong("userid");
				
				LogPO tmpLog=new LogPO(id, time, type, userid);
				
				results.add(tmpLog);
			}
			
			return results;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	

	@Override
	public boolean update(LogPO po) throws RemoteException {
		// TODO 
		return false;
	}

	/**
	 *  TODO ����ʱ��ɾ��������¼
	 */
	@Override
	public boolean delete(Date time) throws RemoteException {
		
		String sql="delete from logs where time="+time;
		
		try {
			if(DataFactory.statement.executeUpdate(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 *  TODO ���ݲ������Ͳ��Ҳ�����¼
	 */
	@Override
	public ArrayList<LogPO> findLogbyType(String type) throws RemoteException {
		
		String sql="select * from logs where type="+type;
		
		ArrayList<LogPO> results=new ArrayList<>();
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				long id=result.getLong("id");
				Date time=result.getDate("time");
				long userid=result.getLong("userid");
				
				LogPO tmpLog=new LogPO(id, time, type, userid);
				
				results.add(tmpLog);
			}
			
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ��ȡ������¼���м�¼����
	 */
	@Override
	public int getLogNum() throws RemoteException {
		 
		String sql="select * from logs";
		
		int num=0;
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			while(result.next()) {
				num++;
			}
			
			return num;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	

}
