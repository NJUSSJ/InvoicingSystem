package data.billdata;

import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.datafactory.DataFactory;
import dataservice.billdataservice.OverBillDataService;
import po.LossBillPO;
import po.OverBillPO;

public class OverBillDataImpl implements OverBillDataService {

	/**
	 * �������絥
	 */
	@Override
	public boolean insert(OverBillPO po) throws RemoteException {
		String sql="insert into overbills (id,userid,commoditylist,time)"
				+ "values"
				+ "('"+po.getID()+"','"+po.getUserID()+"','"+po.getCommodityList()+"','"+po.getTime();
		
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
		String sql="update overbills set state='"+po.getState()+"'";
		
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
				String commoditylist=result.getString("commoditylist");
				Date time=result.getDate("time");
				int state=result.getInt("state");
			
				OverBillPO tmpPO=new OverBillPO(id, userid, commoditylist, time, state);
			
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
				String commoditylist=result.getString("commoditylist");
				Date time=result.getDate("time");
				long id=result.getLong("id");
				int state=result.getInt("state");
				OverBillPO tmpPO=new OverBillPO(id, userid, commoditylist, time, state);
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
				String commoditylist=result.getString("commoditylist");
				int state=result.getInt("state");
				long id=result.getLong("id");
			
				OverBillPO tmpPO=new OverBillPO(id, userid, commoditylist, time, state);
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
				String commoditylist=result.getString("commoditylist");
				Date time=result.getDate("time");
				long id=result.getLong("id");
			
				OverBillPO tmpPO=new OverBillPO(id, userid, commoditylist, time, state);
				results.add(tmpPO);
			}
			return results;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
