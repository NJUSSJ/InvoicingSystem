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
import dataservice.billdataservice.PayBillDataService;
import po.PayBillPO;

public class PayBillDataImpl implements PayBillDataService {

	/**
	 * 新增收款单
	 */
	@Override
	public boolean insert(PayBillPO po) throws RemoteException {
		String sql="insert into paybills (id,userid,memberid,accountlist,sum,time,state)"
				+ "values"
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
	 * 删除收款单
	 */
	@Override
	public boolean delete(PayBillPO po) throws RemoteException {
		String sql="delete from paybills where id='"+po.getID()+"'";
		
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
	 * 维护收款单
	 *
	 */
	@Override
	public boolean update(PayBillPO po) throws RemoteException {
		String sql="update paybills set state='"+po.getState()+"'";
		
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
	 * 根据ID查找
	 */
	@Override
	public PayBillPO findPayBillbyID(String id) throws RemoteException {
		String sql="select * from paybills where id='"+id+"'";
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				
				long userid=result.getLong("userid");
				long memberid=result.getLong("memberid");
				String accountlist=result.getString("commoditylist");
				double sum=result.getDouble("sum");
				Date time=result.getDate("time");
				int state=result.getInt("state");
				
				PayBillPO tmpPO=new PayBillPO(id, userid, memberid, accountlist, sum, time, state);
				
				return tmpPO;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取收款单列表
	 */
	@Override
	public ArrayList<PayBillPO> findPayBills() throws RemoteException {
		String sql="select * from paybills";
		ArrayList<PayBillPO> results=new ArrayList<>();
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
				
				PayBillPO tmpPO=new PayBillPO(id, userid, memberid, accountlist, sum, time, state);
				
				results.add(tmpPO);
				
				
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 根据时间查找
	 */
	@Override
	public ArrayList<PayBillPO> findPayBillbyTime(Date time) throws RemoteException {
		String sql="select * from paybills where time='"+time+"'";
		ArrayList<PayBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				String id=result.getString("id");
				long userid=result.getLong("userid");
				long memberid=result.getLong("memberid");
				String accountlist=result.getString("commoditylist");
				double sum=result.getDouble("sum");
				int state=result.getInt("state");
				
				PayBillPO tmpPO=new PayBillPO(id, userid, memberid, accountlist, sum, time, state);
				
				results.add(tmpPO);
				
				
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 根据状态查找
	 */
	@Override
	public ArrayList<PayBillPO> findPayBillbyState(int state) throws RemoteException {
		String sql="select * from paybills where state='"+state+"'";
		ArrayList<PayBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				String id=result.getString("id");
				long userid=result.getLong("userid");
				long memberid=result.getLong("memberid");
				String accountlist=result.getString("commoditylist");
				double sum=result.getDouble("sum");
				Date time=result.getDate("time");
				
				PayBillPO tmpPO=new PayBillPO(id, userid, memberid, accountlist, sum, time, state);
				
				results.add(tmpPO);
				
				
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
