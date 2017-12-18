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
import data.userdata.UserDataImpl;
import dataservice.billdataservice.OverBillDataService;
import po.OverBillPO;


public class OverBillDataImpl implements OverBillDataService {

	/**
	 * �������絥
	 */
	@Override
	public boolean insert(OverBillPO po) throws RemoteException {
		String sql="insert into overbills (id,userid,commodityname,time,state,num,sum)"
				+ " values "
				+ "('"+po.getID()+"','"+po.getUserID()+"','"+po.getCommodityName()+"','"+po.getTime()+"','"+po.getState()+"','"+po.getNum()+"','"+po.getSum()+"')";
		
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
	 * ɾ�����絥
	 */
	@Override
	public boolean delete(OverBillPO po) throws RemoteException {
		String sql="delete from overbills where id='"+po.getID()+"'";
		
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
	 * ά�����絥
	 */
	@Override
	public boolean update(OverBillPO po) throws RemoteException {
		String sql="update overbills set state='"+po.getState()+"' where id='"+po.getID()+"'";
		
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
	 * ���ݾ�ID����
	 */
	
	@Override
	public OverBillPO findOverBillbyID(long id) throws RemoteException {
		String sql="select * from overbills where id='"+id+"'";
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			while(result.next()) {
				long userid=result.getLong("userid");
				String commodityname=result.getString("commodityname");
				Date time=result.getDate("time");
				int state=result.getInt("state");
			
				int num=result.getInt("num");
				double sum=result.getDouble("sum");
				OverBillPO tmpPO=new OverBillPO(id, userid, commodityname, time, state,num,sum);
			
				return tmpPO;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ���ұ��絥�б�
	 */
	@Override
	public ArrayList<OverBillPO> findOverBills() throws RemoteException {
		String sql="select * from overbills";
		ArrayList<OverBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			while(result.next()) {
				
				long userid=result.getLong("userid");
				String commodityname=result.getString("commodityname");
				Date time=result.getDate("time");
				long id=result.getLong("id");
				int state=result.getInt("state");
				int num=result.getInt("num");
				double sum=result.getDouble("sum");
				OverBillPO tmpPO=new OverBillPO(id, userid, commodityname, time, state,num,sum);
							results.add(tmpPO);
			}
			return results;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * ����ʱ�����
	 */
	@Override
	public ArrayList<OverBillPO> findOverBillbyTime(Date time) throws RemoteException {
		String sql="select * from overbills where time='"+time+"'";
		ArrayList<OverBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			while(result.next()) {
				
				long userid=result.getLong("userid");
				String commodityname=result.getString("commodityname");
				int state=result.getInt("state");
				long id=result.getLong("id");
			
				int num=result.getInt("num");
				double sum=result.getDouble("sum");
				OverBillPO tmpPO=new OverBillPO(id, userid, commodityname, time, state,num,sum);
							results.add(tmpPO);
			}
			return results;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ����״̬����
	 */
	@Override
	public ArrayList<OverBillPO> findOverBillbyState(int state) throws RemoteException {
		String sql="select * from overbills where state='"+state+"'";
		ArrayList<OverBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			while(result.next()) {
				
				long userid=result.getLong("userid");
				String commodityname=result.getString("commodityname");
				Date time=result.getDate("time");
				long id=result.getLong("id");
			
				int num=result.getInt("num");
				double sum=result.getDouble("sum");
				OverBillPO tmpPO=new OverBillPO(id, userid, commodityname, time, state,num,sum);
							results.add(tmpPO);
			}
			return results;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<OverBillPO> findOverBillbyField(String user) throws RemoteException {
		long userid=new UserDataImpl().findUserbyName(user).getID();
		
		String sql="select * from overbills where userid='"+userid+"'";
		ArrayList<OverBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			while(result.next()) {
				
				
				String commodityname=result.getString("commodityname");
				Date time=result.getDate("time");
				long id=result.getLong("id");
				int state=result.getInt("state");
				int num=result.getInt("num");
				double sum=result.getDouble("sum");
				OverBillPO tmpPO=new OverBillPO(id, userid, commodityname, time, state,num,sum);
							
				if(state==1)
				results.add(tmpPO);
			}
			return results;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
