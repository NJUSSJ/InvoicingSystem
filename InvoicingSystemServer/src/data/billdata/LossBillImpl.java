package data.billdata;
/**
 * @author shisj
 */
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.datafactory.DataFactory;
import dataservice.billdataservice.LossBillDataService;
import po.LossBillPO;

public class LossBillImpl implements LossBillDataService {

	/**
	 * ��������
	 */
	@Override
	public boolean insert(LossBillPO po) throws RemoteException {
		String sql="insert into lossbills (id,userid,commoditylist,time)"
				+ " values "
				+ "('"+po.getID()+"','"+po.getUserID()+"','"+po.getName()+"','"+po.getTime();
		
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
	 * ɾ������
	 */
	@Override
	public boolean delete(LossBillPO po) throws RemoteException {
		String sql="delete from lossbills where id='"+po.getID()+"'";
		
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
	 * ά������
	 */
	@Override
	public boolean update(LossBillPO po) throws RemoteException {
		String sql="update lossbills set state='"+po.getState()+"' where id='"+po.getID()+"'";
		
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
	 * ���ݣɣĲ��ұ���
	 */
	@Override
	public LossBillPO findLossBillbyID(long id) throws RemoteException {
		String sql="select * from lossbills where id='"+id+"'";
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			while(result.next()) {
				long userid=result.getLong("userid");
				String commodityname=result.getString("commoditylist");
				Date time=result.getDate("time");
				int state=result.getInt("state");
				int num=result.getInt("");
				double sum=result.getDouble("");
			
				LossBillPO tmpPO=new LossBillPO(id, userid, commodityname, time, state, num,sum);
			
				return tmpPO;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ����״̬���ұ���
	 */
	@Override
	public ArrayList<LossBillPO> findLossBillbyState(int state) throws RemoteException {
		String sql="select * from lossbills where state='"+state+"'";
		ArrayList<LossBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			while(result.next()) {
				
				long userid=result.getLong("userid");
				String commodityname=result.getString("commoditylist");
				Date time=result.getDate("time");
				long id=result.getLong("id");
			
				int num=result.getInt("");
				double sum=result.getDouble("");
			
				LossBillPO tmpPO=new LossBillPO(id, userid, commodityname, time, state, num,sum);
				results.add(tmpPO);
			}
			return results;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ���ұ����б�
	 */
	@Override
	public ArrayList<LossBillPO> findLossBills() throws RemoteException {
		String sql="select * from lossbills";
		ArrayList<LossBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			while(result.next()) {
				
				long userid=result.getLong("userid");
				String commodityname=result.getString("commoditylist");
				Date time=result.getDate("time");
				long id=result.getLong("id");
				int state=result.getInt("state");
				int num=result.getInt("");
				double sum=result.getDouble("");
			
				LossBillPO tmpPO=new LossBillPO(id, userid, commodityname, time, state, num,sum);
				
				results.add(tmpPO);
			}
			return results;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * ����ʱ����ұ���
	 */
	@Override
	public ArrayList<LossBillPO> findLossBillbyTime(Date time) throws RemoteException {
		String sql="select * from lossbills where time='"+time+"'";
		ArrayList<LossBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			while(result.next()) {
				
				long userid=result.getLong("userid");
				String commodityname=result.getString("commoditylist");
				int state=result.getInt("state");
				long id=result.getLong("id");
			
				int num=result.getInt("");
				double sum=result.getDouble("");
			
				LossBillPO tmpPO=new LossBillPO(id, userid, commodityname, time, state, num,sum);
				results.add(tmpPO);
			}
			return results;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
