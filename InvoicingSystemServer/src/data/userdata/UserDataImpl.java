package data.userdata;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.datafactory.DataFactory;
import dataservice.userdataservice.UserDataService;
import po.UserPO;

public class UserDataImpl implements UserDataService {

	@Override
	public UserPO find(long id) throws RemoteException {
		// TODO Auto-generated method stub
	String sql="SELECT id, username,rank,password FROM users";
		
		//执行数据库sql语句
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			//展开结果数据
			while(result.next()) {
				long tmpid=result.getLong("id");
				String username=result.getString("username");
				int rank=result.getInt("rank");
				String password=result.getString("password");
				
				UserPO tmpUserPO=new UserPO(id, password, rank, username);
				
				if(id==tmpid) {
					return tmpUserPO;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public UserPO find(String name) throws RemoteException {
		// TODO Auto-generated method stub
		String sql="SELECT id, username,rank,password FROM users";
		
		//执行数据库sql语句
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			//展开结果数据
			while(result.next()) {
				long id=result.getLong("id");
				String username=result.getString("username");
				int rank=result.getInt("rank");
				String password=result.getString("password");
				
				UserPO tmpUserPO=new UserPO(id, password, rank, username);
				
				if(name.equals(username)) {
					return tmpUserPO;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public void insert(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
