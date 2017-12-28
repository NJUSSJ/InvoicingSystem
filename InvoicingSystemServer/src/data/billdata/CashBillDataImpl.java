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
import dataservice.billdataservice.CashBillDataService;
import po.CashBillPO;

public class CashBillDataImpl implements CashBillDataService{

	/**
	 * 插入新的现金费用单
	 */
	@Override
	public boolean insert(CashBillPO po) throws RemoteException {
		String sql="insert into cashbills (id, userid, accountid, items, state, time, sum) "
				+ "values "
				+ "('"+po.getID()+"','"+po.getUserID()+"','"+po.getAccountID()+"','"+po.getItems()+"','"+po.getState()+"','"+po.getTime()+"','"+po.getSum()+"')";
		
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
	 * 删除现金费用单
	 */
	@Override
	public boolean delete(CashBillPO po) throws RemoteException {
		String sql="delete from cashbills where id='"+po.getID()+"'";
		
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
	 * 维护现金费用单
	 */
	@Override
	public boolean update(CashBillPO po) throws RemoteException {
		String sql="update cashbills set state='"+po.getState()+"' where id= '"+po.getID()+"'";
		try {
			if(DataFactory.statement.executeUpdate(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public CashBillPO findCashBillbyID(String id) throws RemoteException {
		String sql="select * from cashbills where id='"+id+"'";
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				long userid=result.getLong("userid");
				long accountid=result.getLong("accountid");
				String items=result.getString("items");
				int state=result.getInt("state");
				Date time=result.getDate("time");
				double sum=result.getDouble("sum");
				
				CashBillPO tmpPO=new CashBillPO(id, userid, accountid, items, state, time, sum);
				return tmpPO;			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取现金费用单列表
	 */
	@Override
	public ArrayList<CashBillPO> findCashBills() throws RemoteException {
		String sql="select * from cashbills";
		
		ArrayList<CashBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				String id=result.getString("id");
				long userid=result.getLong("userid");
				String items=result.getString("items");
				int state=result.getInt("state");
				Date time=result.getDate("time");
				double sum=result.getDouble("sum");
				long accountid=result.getLong("accountid");
				CashBillPO tmpPO=new CashBillPO(id, userid, accountid, items, state, time, sum);
				
				results.add(tmpPO);
			}
			
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据时间获取现金费用单
	 */
	@Override
	public ArrayList<CashBillPO> findCashBillbyTime(Date time) throws RemoteException {
		String sql="select * from cashbills where time='"+time+"'";
		
		ArrayList<CashBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				String id=result.getString("id");
				long userid=result.getLong("userid");
				String items=result.getString("items");
				int state=result.getInt("state");
				double sum=result.getDouble("sum");
				long accountid=result.getLong("accountid");
				CashBillPO tmpPO=new CashBillPO(id, userid, accountid, items, state, time, sum);
				
				results.add(tmpPO);
			}
			
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据状态查找现金费单
	 */
	@Override
	public ArrayList<CashBillPO> findCashBillbyState(int state) throws RemoteException {
		String sql="select * from cashbills where state='"+state+"'";
		
		ArrayList<CashBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				String id=result.getString("id");
				long userid=result.getLong("userid");
				String items=result.getString("items");
				Date time=result.getDate("time");
				double sum=result.getDouble("sum");
				long accountid=result.getLong("accountid");
				CashBillPO tmpPO=new CashBillPO(id, userid, accountid, items, state, time, sum);
				
				results.add(tmpPO);
			}
			
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<CashBillPO> findCashBillbyField(String  user) throws RemoteException {
		if(user==null||user.length()<=0)return findCashBills();
		long userid=new UserDataImpl().findUserbyName(user).getID();
		String sql="select * from cashbills where userid='"+userid+"'";
		
		ArrayList<CashBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				String id=result.getString("id");
				int state=result.getInt("state");
				String items=result.getString("items");
				Date time=result.getDate("time");
				double sum=result.getDouble("sum");
				long accountid=result.getLong("accountid");
				CashBillPO tmpPO=new CashBillPO(id, userid, accountid, items, state, time, sum);
				
				if(state==1||state==3)
				results.add(tmpPO);
			}
			
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<CashBillPO> findCashBillbyUser(long userid) throws RemoteException {
		
		String sql="select * from cashbills where userid='"+userid+"'";
		
		ArrayList<CashBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				String id=result.getString("id");
				int state=result.getInt("state");
				String items=result.getString("items");
				Date time=result.getDate("time");
				double sum=result.getDouble("sum");
				long accountid=result.getLong("accountid");
				CashBillPO tmpPO=new CashBillPO(id, userid, accountid, items, state, time, sum);
				
				if(state==1||state==2)
				results.add(tmpPO);
			}
			
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
