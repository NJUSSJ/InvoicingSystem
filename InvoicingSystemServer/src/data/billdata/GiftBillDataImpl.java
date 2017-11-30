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
import dataservice.billdataservice.GiftBillDataService;
import po.GiftBillPO;

public class GiftBillDataImpl implements GiftBillDataService {

	@Override
	public boolean insert(GiftBillPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String sql="INSERT INTO giftbills (id,userid,memberid,time,state,commoditylist) VALUES"+
		"('"+po.getID()+"','"+po.getUser()+"','"+po.getMember()+"','"+po.getDate()+"','"+po.getState()+"','"+po.getList()+"')";
		try {
			if(DataFactory.statement.execute(sql)) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(GiftBillPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String sql="delete from giftbills where id="+po.getID();
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
	public boolean update(GiftBillPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String sql="update giftbills set state='"+po.getState()+"'where id="+po.getID();
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
	public ArrayList<GiftBillPO> findGiftBillbyState(int state) throws RemoteException {
		// TODO Auto-generated method stub
		String sql="SELECT id,userid,memberid,time,state,commoditylist FROM giftbills WHERE state= "+state;
		ArrayList<GiftBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			while(result.next()) {
				long id=result.getLong("id");
				long userid=result.getLong("userid");
				long memberid=result.getLong("memberid");
				Date time=result.getDate("time");
				String commoditylist=result.getString("commoditylist");
				int state_=result.getInt("state");
				results.add(new GiftBillPO(id, userid, memberid, commoditylist, time,state_));
				return results;
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public ArrayList<GiftBillPO> finds(String field) throws RemoteException {
		// TODO Auto-generated method stub
		String sql="SELECT id,userid,memberid,time,state,commoditylist FROM giftbills";
		ArrayList<GiftBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			while(result.next()) {
				long id=result.getLong("id");
				long userid=result.getLong("userid");
				long memberid=result.getLong("memberid");
				Date time=result.getDate("time");
				String commoditylist=result.getString("commoditylist");
				int state=result.getInt("state");
				results.add(new GiftBillPO(id, userid, memberid, commoditylist, time,state));
				return results;
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return null;
	}

	
	
}
