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
	 * ��������
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
	 * ���ݣɣĲ��ұ���
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
	 * ����״̬���ұ���
	 */
	@Override
	public ArrayList<LossBillPO> findLossBillbyState(int state) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ���ұ����б�
	 */
	@Override
	public ArrayList<LossBillPO> findLossBills() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ����ʱ����ұ���
	 */
	@Override
	public ArrayList<LossBillPO> findLossBillbyTime(Date time) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
