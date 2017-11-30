package data.logdata;

import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.fabric.xmlrpc.base.Data;

import data.datafactory.DataFactory;
import dataservice.logdataservice.LogDataService;
import po.LogPO;

public class LogDataImpl implements LogDataService {

	@Override
	public boolean insert(LogPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String sql="insert into logs (id,time,type,userid)"
				+ "values"
				+ "('"+po.getID()+"','"+po.getTime()+"','"+po.getType()+"','"+po.getUserID()+",)";
		try {
			if(DataFactory.statement.execute(sql)) {
				return true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public ArrayList<LogPO> findLogs() throws RemoteException {
		// TODO Auto-generated method stub
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public ArrayList<LogPO> findLogbyOperator(long operatorID) throws RemoteException {
		// TODO Auto-generated method stub
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
			// TODO: handle exception
		}
		return null;
	}

	

	@Override
	public boolean update(LogPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete(Data time) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<LogPO> findLogbyType(String type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLogNum() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
