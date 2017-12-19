package data.billdata;

import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.datafactory.DataFactory;
import data.memberdata.MemberDataImpl;
import data.userdata.UserDataImpl;
import dataservice.billdataservice.ReceiveBillDataService;
import po.ReceiveBillPO;

/**
 * 
 * @author shisj
 *
 */
public class ReceiveBillDataImpl implements ReceiveBillDataService{

	/**
	 * �����տ
	 */
	@Override
	public boolean insert(ReceiveBillPO po) throws RemoteException {
		String sql="insert into receivebills (id,userid,memberid,accountlist,sum,time,state)"
				+ " values "
				+ "('"+po.getID()+"','"+po.getUserID()+"','"+po.getMemberID()+"','"+po.getAccountList()+"','"+po.getSum()+"','"+po.getTime()+"','"+po.getState()+"')";
		
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
	 * ɾ���տ
	 */
	@Override
	public boolean delete(ReceiveBillPO po) throws RemoteException {
		String sql="delete from receivebills where id='"+po.getID()+"'";
		
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
	 * ά���տ
	 */
	@Override
	public boolean update(ReceiveBillPO po) throws RemoteException {
		String sql="update receivebills set state='"+po.getState()+"'";
		
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
	 * ����ID�����տ
	 */
	@Override
	public ReceiveBillPO findReceiveBillbyID(String id) throws RemoteException {
		String sql="select * from receivebills where id='"+id+"'";
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				
				long userid=result.getLong("userid");
				long memberid=result.getLong("memberid");
				String accountlist=result.getString("commoditylist");
				double sum=result.getDouble("sum");
				Date time=result.getDate("time");
				int state=result.getInt("state");
				
				ReceiveBillPO tmpPO=new ReceiveBillPO(id, userid, memberid, accountlist, sum, time, state);
				
				return tmpPO;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * �����տ�б�
	 */
	@Override
	public ArrayList<ReceiveBillPO> findReceiveBills() throws RemoteException {
		String sql="select * from receivebills";
		ArrayList<ReceiveBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				String id=result.getString("id");
				long userid=result.getLong("userid");
				long memberid=result.getLong("memberid");
				String accountlist=result.getString("commoditylist");
				double sum=result.getDouble("sum");
				Date time=result.getDate("time");
				int state=result.getInt("state");
				
				ReceiveBillPO tmpPO=new ReceiveBillPO(id, userid, memberid, accountlist, sum, time, state);
				
				results.add(tmpPO);
				
				
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * ����ʱ������տ
	 */
	@Override
	public ArrayList<ReceiveBillPO> findReceiveBillbyTime(Date time) throws RemoteException {
		String sql="select * from rececivebills where time='"+time+"'";
		ArrayList<ReceiveBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				String id=result.getString("id");
				long userid=result.getLong("userid");
				long memberid=result.getLong("memberid");
				String accountlist=result.getString("commoditylist");
				double sum=result.getDouble("sum");
				int state=result.getInt("state");
				
				ReceiveBillPO tmpPO=new ReceiveBillPO(id, userid, memberid, accountlist, sum, time, state);
				
				results.add(tmpPO);
				
				
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * ����״̬�����տ
	 */
	@Override
	public ArrayList<ReceiveBillPO> findReceiveBillbyState(int state) throws RemoteException {
		String sql="select * from receivebills where state='"+state+"'";
		ArrayList<ReceiveBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				String id=result.getString("id");
				long userid=result.getLong("userid");
				long memberid=result.getLong("memberid");
				String accountlist=result.getString("commoditylist");
				double sum=result.getDouble("sum");
				Date time=result.getDate("time");
				
				ReceiveBillPO tmpPO=new ReceiveBillPO(id, userid, memberid, accountlist, sum, time, state);
				
				results.add(tmpPO);
				
				
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<ReceiveBillPO> findReceiveBillbyField(String user,String member) throws RemoteException {
		long userid=new UserDataImpl().findUserbyName(user).getID();
		long memberid=new MemberDataImpl().findMemberbyName(member).getID();
		String sql="select * from receivebills where userid='"+userid+"' and memberid='"+memberid+"'";
		ArrayList<ReceiveBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				String id=result.getString("id");
				
				
				String accountlist=result.getString("commoditylist");
				double sum=result.getDouble("sum");
				Date time=result.getDate("time");
				int state=result.getInt("state");
				
				ReceiveBillPO tmpPO=new ReceiveBillPO(id, userid, memberid, accountlist, sum, time, state);
				
				if(state==1)
				results.add(tmpPO);
				
				
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<ReceiveBillPO> findReceiveBillbyUser(long userid) throws RemoteException {
		String sql="select * from receivebills where userid='"+userid+"'";
		ArrayList<ReceiveBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				String id=result.getString("id");
				
				
				String accountlist=result.getString("commoditylist");
				double sum=result.getDouble("sum");
				Date time=result.getDate("time");
				int state=result.getInt("state");
				long memberid=result.getLong("memberid");
				
				ReceiveBillPO tmpPO=new ReceiveBillPO(id, userid, memberid, accountlist, sum, time, state);
				
				if(state==1)
				results.add(tmpPO);
				
				
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}		return null;
	}

}
