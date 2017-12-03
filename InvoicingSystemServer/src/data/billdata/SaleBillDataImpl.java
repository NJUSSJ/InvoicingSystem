package data.billdata;

/**
 * @author shisj
 * 
 */
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.datafactory.DataFactory;
import dataservice.billdataservice.SaleBillDataService;
import po.SaleBillPO;

public class SaleBillDataImpl implements SaleBillDataService{

	/**
	 * �������۵�
	 */
	@Override
	public boolean insert(SaleBillPO po) throws RemoteException {
		String sql="insert into salebills (id,userid,memberid,commoditylist,sum,time,state,num,remark)"
				+ "values"
				+ "('"+po.getID()+"','"+po.getUserID()+"','"+po.getMemberID()+"','"+po.getCommodityList()+"','"+po.getSum()
				+"','"+po.getTime()+"','"+po.getState()+"','"+po.getSum()+"','"+po.getNum()+"','"+po.getRemark()+"')";
		
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
	 * ɾ�����۵�
	 */
	@Override
	public boolean delete(SaleBillPO po) throws RemoteException {
		String sql="delete from salebills where id='"+po.getID()+"')";
		
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
	 * ά�����۵�
	 */
	@Override
	public boolean update(SaleBillPO po) throws RemoteException {
		String sql="update salebills set state='"+po.getState()+"' where id=="+po.getID()+"'";
		
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
	 * ����ID�������۵�
	 */
	@Override
	public SaleBillPO findSaleBillbyID(String id) throws RemoteException {
		String sql="select * from salebills where id='"+id+"'";
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				long userid=result.getLong("userid");
				long memberid=result.getLong("memberid");
				String commoditylist=result.getString("commoditylist");
				double sum=result.getDouble("sum");
				Date time=result.getDate("time");
				int state =result.getInt("state");
				int num=result.getInt("num");
				String remark=result.getString("remark");
				
				SaleBillPO tmpPO=new SaleBillPO(id, userid, memberid, commoditylist, sum, state, time, num, remark);
				return tmpPO;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * �������۵��б�
	 */
	@Override
	public ArrayList<SaleBillPO> findSaleBills() throws RemoteException {
		String sql="select * from salebills ";
		ArrayList<SaleBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				String id=result.getString("id");
				long userid=result.getLong("userid");
				long memberid=result.getLong("memberid");
				String commoditylist=result.getString("commoditylist");
				double sum=result.getDouble("sum");
				Date time=result.getDate("time");
				int state =result.getInt("state");
				int num=result.getInt("num");
				String remark=result.getString("remark");
				
				SaleBillPO tmpPO=new SaleBillPO(id, userid, memberid, commoditylist, sum, state, time, num, remark);
				results.add(tmpPO);
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ����ʱ��������۵�
	 */
	@Override
	public ArrayList<SaleBillPO> findSaleBillbyTime(Date time) throws RemoteException {
		String sql="select * from salebills where time='"+time+"'";
		ArrayList<SaleBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				String id=result.getString("id");
				long userid=result.getLong("userid");
				long memberid=result.getLong("memberid");
				String commoditylist=result.getString("commoditylist");
				double sum=result.getDouble("sum");
				int state =result.getInt("state");
				int num=result.getInt("num");
				String remark=result.getString("remark");
				
				SaleBillPO tmpPO=new SaleBillPO(id, userid, memberid, commoditylist, sum, state, time, num, remark);
				results.add(tmpPO);
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ����״̬�������۵�
	 */
	@Override
	public ArrayList<SaleBillPO> findSaleBillbyState(int state) throws RemoteException {
		
		String sql="select * from salebills where state='"+state+"'";
		ArrayList<SaleBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				String id=result.getString("id");
				long userid=result.getLong("userid");
				long memberid=result.getLong("memberid");
				String commoditylist=result.getString("commoditylist");
				double sum=result.getDouble("sum");
				Date time=result.getDate("time");
				int num=result.getInt("num");
				String remark=result.getString("remark");
				
				SaleBillPO tmpPO=new SaleBillPO(id, userid, memberid, commoditylist, sum, state, time, num, remark);
				results.add(tmpPO);
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}