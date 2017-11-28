package data.billdata;

import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import data.datafactory.DataFactory;
import dataservice.billdataservice.importbilldataservice;
import po.ImportBillPO;

public class ImportBillDataImpl implements importbilldataservice {

	@Override
	public boolean insert(ImportBillPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String sql="insert into importbills (id,userid,memberid,sum,state,time,commoditylist,num)"
				+ "VALUES"
				+ "('"+po.getID()+"','"+po.getUser()+"','"+po.getMember()+"','"+po.getsum()+"','"+po.getState()+"','"+po.getTime()+"','"+po.getList()+"','"+po.getnum()+"')";
		try {
			if(DataFactory.statement.execute(sql)) {
			return true;
		}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		
		return false;
	}

	@Override
	public boolean delete(ImportBillPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String sql="delete from importbills where id="+po.getID();
		try {
			if(DataFactory.statement.execute(sql)) {
				return true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean update(ImportBillPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String sql="update importbills set state='"+po.getState()+"'where id="+po.getID();
		try {
			if(DataFactory.statement.execute(sql)) {
				return true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public ArrayList<ImportBillPO> findImportBillbyState(int state) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ImportBillPO> findImportBillbyTime(Date time) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
