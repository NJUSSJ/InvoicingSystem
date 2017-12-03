package data.billdata;

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
	 * 新增报损单
	 */
	@Override
	public boolean insert(LossBillPO po) throws RemoteException {
		String sql="insert into lossbills (id,userid,commoditylist,time)"
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
	 * 删除报损单
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
	 * 维护报损单
	 */
	@Override
	public boolean update(LossBillPO po) throws RemoteException {
		String sql="update set state='"+po.getState()+"'";
		
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
	 * 根据ＩＤ查找报损单
	 */
	@Override
	public LossBillPO findLossBillbyID(long id) throws RemoteException {
		String sql="select * from lossbills where id='"+id+"'";
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			long userid=result.getLong("userid");
			String commoditylist=result.getString("commoditylist");
			Date time=result.getDate("time");
			int state=result.getInt("state");
			
			LossBillPO tmpPO=
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * 根据状态查找报损单
	 */
	@Override
	public ArrayList<LossBillPO> findLossBillbyState(int state) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 查找报损单列表
	 */
	@Override
	public ArrayList<LossBillPO> findLossBills() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 根据时间查找报损单
	 */
	@Override
	public ArrayList<LossBillPO> findLossBillbyTime(Date time) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
