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
import dataservice.billdataservice.WarningBillDataService;
import po.WarningBillPO;

public class WarningBillDataImpl implements WarningBillDataService {

	/**
	 * 新增报警单
	 */
	@Override
	public boolean insert(WarningBillPO po) throws RemoteException {
		String sql="insert into warningbills (id,userid,commoditylist,time)"
				+ " values "
				+ "('"+po.getID()+"','"+po.getUserID()+"','"+po.getCommodityList()+"','"+po.getTime()+"')";
		
		try {
			if(DataFactory.statement.executeUpdate(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return false;
	}

	/**
	 * 删除报警单
	 */
	@Override
	public boolean delete(WarningBillPO po) throws RemoteException {
		String sql="delete from warningbills where id='"+po.getID()+"'";
		
		try {
			if(DataFactory.statement.executeUpdate(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return false;
	}

	/**
	 * 更新报警单
	 */
	@Override
	public boolean update(WarningBillPO po) throws RemoteException {
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
	 * 根据ID查找
	 */
	@Override
	public WarningBillPO findWarningBillbyID(long id) throws RemoteException {
		String sql="select * from warningbills where id='"+id+"'";
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				long userid=result.getLong("userid");
				Date time=result.getDate("time");
				String commoditylist=result.getString("commoditylist");
				int state=result.getInt("state");
				WarningBillPO tmpPO=new WarningBillPO(id, userid, commoditylist, time, state);
				return tmpPO;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查找报警单列表
	 */
	@Override
	public ArrayList<WarningBillPO> findWarningBills() throws RemoteException {
		String sql="select * from warningbills";
		ArrayList<WarningBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				long id=result.getLong("id");
				long userid=result.getLong("userid");
				Date time=result.getDate("time");
				String commoditylist=result.getString("commoditylist");
				int state=result.getInt("state");
				WarningBillPO tmpPO=new WarningBillPO(id, userid, commoditylist, time, state);
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
	public ArrayList<WarningBillPO> findWarningBillbyTime(Date time) throws RemoteException {
		String sql="select * from warningbills where time='"+time+"'";
		ArrayList<WarningBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				long id=result.getLong("id");
				long userid=result.getLong("userid");
				String commoditylist=result.getString("commoditylist");
				int state=result.getInt("state");
				WarningBillPO tmpPO=new WarningBillPO(id, userid, commoditylist, time, state);
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
	public ArrayList<WarningBillPO> findWarningBillbyState(int state) throws RemoteException {
		String sql="select * from warningbills where state='"+state+"'";
		ArrayList<WarningBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				long id=result.getLong("id");
				long userid=result.getLong("userid");
				String commoditylist=result.getString("commoditylist");
				Date time=result.getDate("time");
				WarningBillPO tmpPO=new WarningBillPO(id, userid, commoditylist, time, state);
				results.add(tmpPO);
			}
			
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<WarningBillPO> findWarningBillbyField(String user) throws RemoteException {
		long userid=new UserDataImpl().findUserbyName(user).getID();
		
		String sql="select * from warningbills";
		ArrayList<WarningBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				long id=result.getLong("id");
				Date time=result.getDate("time");
				String commoditylist=result.getString("commoditylist");
				int state=result.getInt("state");
				WarningBillPO tmpPO=new WarningBillPO(id, userid, commoditylist, time, state);
				results.add(tmpPO);
			}
			
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
