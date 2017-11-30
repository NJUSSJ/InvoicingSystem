package data.userdata;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.datafactory.DataFactory;
import dataservice.userdataservice.UserDataService;
import po.UserPO;

public class UserDataImpl implements UserDataService {
	/**
	 * 按员工id在数据库中查找
	 */
	@Override
	public UserPO findUserbyID(long id) throws RemoteException {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	/**
	 * 插入一个员工持久化对象到数据库中
	 */
	@Override
	public boolean insert(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String sql="INSERT INTO users(id,username,password,rank) VALUES("+po.getID()
		+",'"+po.getUserName()+"','"+po.getPassword()+"','"+po.getPassword()+"',"+po.getRank()+")";
		try {
			if(DataFactory.statement.execute(sql)){
				return true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 从数据库中删除一个员工持久化对象
	 */
	@Override
	public boolean delete(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String sql="DELETE FROM users WHERE id="+po.getID();
		try {
			if(DataFactory.statement.execute(sql)){
				return true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
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
		// TODO Auto-generated method stub
		String sql="UPDATE users SET username='"+po.getUserName()+"',password='"
				+po.getPassword()+"',rank="+po.getRank()+" WHERE id="+po.getID();
		try {
			if(DataFactory.statement.execute(sql)){
				return true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	

}
