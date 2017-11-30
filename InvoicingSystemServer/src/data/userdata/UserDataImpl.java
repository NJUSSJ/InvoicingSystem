package data.userdata;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.datafactory.DataFactory;
import dataservice.userdataservice.UserDataService;
import po.UserPO;

public class UserDataImpl implements UserDataService {
	/**
	 * ��Ա��id�����ݿ��в���
	 */
	@Override
	public UserPO findUserbyID(long id) throws RemoteException {
		// TODO Auto-generated method stub
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	/**
	 * ����һ��Ա���־û��������ݿ���
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * �����ݿ���ɾ��һ��Ա���־û�����
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
			// TODO �Զ����ɵ� catch ��
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
		// TODO Auto-generated method stub
		String sql="UPDATE users SET username='"+po.getUserName()+"',password='"
				+po.getPassword()+"',rank="+po.getRank()+" WHERE id="+po.getID();
		try {
			if(DataFactory.statement.execute(sql)){
				return true;
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}

	

}
