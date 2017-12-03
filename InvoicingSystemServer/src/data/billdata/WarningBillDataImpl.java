package data.billdata;
/**
 * @author shisj
 */
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.omg.CORBA.COMM_FAILURE;

import data.datafactory.DataFactory;
import dataservice.billdataservice.WarningBillDataService;
import po.SaleBillPO;
import po.WarningBillPO;

public class WarningBillDataImpl implements WarningBillDataService {

	/**
	 * ����������
	 */
	@Override
	public boolean insert(WarningBillPO po) throws RemoteException {
		String sql="insert into warningbills (id,userid,commoditylist,time)"
				+ "values"
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
	 * ɾ��������
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
	 * ���±�����
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
	 * ����ID����
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
				
				warn
				return tmpPO;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ���ұ������б�
	 */
	@Override
	public ArrayList<WarningBillPO> findWarningBills() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ����ʱ�����
	 */
	@Override
	public ArrayList<WarningBillPO> findWarningBillbyTime(Date time) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ����״̬����
	 */
	@Override
	public ArrayList<WarningBillPO> findWarningBillbyState(int state) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
