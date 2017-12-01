package data.billdata;

import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.datafactory.DataFactory;
import dataservice.billdataservice.CashBillDataService;
import po.CashBillPO;

public class CashBillDataImpl implements CashBillDataService{

	/**
	 * 插入新的现金费用单
	 */
	@Override
	public boolean insert(CashBillPO po) throws RemoteException {
		String sql="insert into cashbills (id, userid, accountid, items, state, time, sum)"
				+ "values"
				+ "('"+po.getID()+"','"+po.getUserID()+"','"+po.getAccountID()+"','"+po.getItems()+"','"+po.getState()+"','"+po.getTime()+"','"+po.getSum();
		
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

	
	@Override
	public boolean update(CashBillPO po) throws RemoteException {
		// TODO Auto-generated method stub
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
				
				CashBillPO tmpPO=new CashBillPO(id,userid, accountid, items, state, time, sum);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public ArrayList<CashBillPO> findCashBills() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CashBillPO> findCashBillbyTime(Date time) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CashBillPO> findCashBillbyState(int state) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
