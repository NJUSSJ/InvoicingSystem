package data.userdata;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.datafactory.DataFactory;
import dataservice.userdataservice.UserDataService;
import po.UserPO;

public class UserDataImpl implements UserDataService {
	/**
	 * 按员工id在数据库中查找
	 */
	@Override
	public UserPO findUserbyID(long id) throws RemoteException {
		
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
			e.printStackTrace();
		}
		
		
		return null;
	}
	/**
	 * 按照员工姓名在数据库中查找
	 */
	@Override
	public UserPO findUserbyName(String name) throws RemoteException {
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
			e.printStackTrace();
		}
		
		
		return null;
	}
	/**
	 * 插入一个员工持久化对象到数据库中
	 */
	@Override
	public boolean insert(UserPO po) throws RemoteException {
		
		String sql="INSERT INTO users(id,username,password,rank) VALUES ('"+po.getID()
		+"','"+po.getUserName()+"','"+po.getPassword()+"',"+po.getRank()+")";
		try {
			if(DataFactory.statement.executeUpdate(sql)>0){
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 从数据库中删除一个员工持久化对象
	 */
	@Override
	public boolean delete(UserPO po) throws RemoteException {
		String sql="DELETE FROM users WHERE id="+po.getID();
		try {
			if(DataFactory.statement.executeUpdate(sql)>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 在数据库中更新一个员工持久化对象,默认一个账号的id不会改变
	 *
	 */
	@Override
	public boolean update(UserPO po) throws RemoteException {
		String sql="UPDATE users SET username='"+po.getUserName()+"',password='"
				+po.getPassword()+"',rank='"+po.getRank()+"' WHERE id='"+po.getID()+"'";
		try {
			if(DataFactory.statement.executeUpdate(sql)>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public ArrayList<UserPO> findUsers() throws RemoteException {
		String sql="SELECT id, username,rank,password FROM users";
		ArrayList<UserPO> results=new ArrayList<>();
		//执行数据库sql语句
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			//展开结果数据
			while(result.next()) {
				long tmpid=result.getLong("id");
				String username=result.getString("username");
				int rank=result.getInt("rank");
				String password=result.getString("password");
				
				UserPO tmpUserPO=new UserPO(tmpid, password, rank, username);
				results.add(tmpUserPO);
				
			}
			
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return  null;
		
	}
	/*
	 * (non-Javadoc)模糊查询
	 * @see dataservice.userdataservice.UserDataService#findUserbyField(java.lang.String)
	 */
	@Override
	public ArrayList<UserPO> findUserbyField(String field) throws RemoteException {
		String sql="SELECT * FROM users where username like '%"+field+"%'";
		ArrayList<UserPO> results=new ArrayList<>();
		//执行数据库sql语句
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			//展开结果数据
			while(result.next()) {
				long tmpid=result.getLong("id");
				String username=result.getString("username");
				int rank=result.getInt("rank");
				String password=result.getString("password");
				
				UserPO tmpUserPO=new UserPO(tmpid, password, rank, username);
				
				results.add(tmpUserPO);
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return  results;
	}

	

}
