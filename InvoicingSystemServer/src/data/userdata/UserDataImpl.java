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
	 * ��Ա��id�����ݿ��в���
	 */
	@Override
	public UserPO findUserbyID(long id) throws RemoteException {
		
	String sql="SELECT id, username,rank,password FROM users";
		
		//ִ�����ݿ�sql���
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			//չ���������
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
	 * ����Ա�����������ݿ��в���
	 */
	@Override
	public UserPO findUserbyName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		String sql="SELECT id, username,rank,password FROM users";
		
		//ִ�����ݿ�sql���
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			//չ���������
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
	 * ����һ��Ա���־û��������ݿ���
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
	 * �����ݿ���ɾ��һ��Ա���־û�����
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
	 * �����ݿ��и���һ��Ա���־û�����,Ĭ��һ���˺ŵ�id����ı�
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
		//ִ�����ݿ�sql���
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			//չ���������
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
	 * (non-Javadoc)ģ����ѯ
	 * @see dataservice.userdataservice.UserDataService#findUserbyField(java.lang.String)
	 */
	@Override
	public ArrayList<UserPO> findUserbyField(String field) throws RemoteException {
		String sql="SELECT * FROM users where username like '%"+field+"%'";
		ArrayList<UserPO> results=new ArrayList<>();
		//ִ�����ݿ�sql���
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			//չ���������
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
