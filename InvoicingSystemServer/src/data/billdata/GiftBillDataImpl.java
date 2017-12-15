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

	/**
	 * 新增赠送单
	 */
	@Override
	public boolean insert(GiftBillPO po) throws RemoteException {
		String sql="insert into giftbills (id,userid,memberid,giftlist,time,state)"
				+ " values "
				+ "('"+po.getID()+"','"+po.getUserID()+"','"+po.getMemberID()+"','"+po.getGiftList()+"','"+po.getTime()+"','"+po.getState()+"')";
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
	 * 删除赠送单
	 */
	@Override
	public boolean delete(GiftBillPO po) throws RemoteException {
		String sql="delete from giftbills where id="+po.getID();
		
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
	 * 更新赠送单
	 */
	@Override
	public boolean update(GiftBillPO po) throws RemoteException {
		String sql="update giftbills set id='"+po.getID()+"',userid='"+po.getUserID()+"',memberid='"+po.getMemberID()+"',giftlist='"
				+po.getGiftList()+"',time='"+po.getTime()+"',state='"+po.getState()+"' where id='"+po.getID()+"'";
		
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
	 * 根据状态查找赠送单
	 */
	@Override
	public ArrayList<GiftBillPO> findGiftBillbyState(int state) throws RemoteException {
		String sql="select * from giftbills where state='"+state+"'";
		ArrayList<GiftBillPO> results=new ArrayList<>();
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				long id=result.getLong("id");
				long userid=result.getLong("userid");
				long memberid=result.getLong("memberid");
				String giftlist=result.getString("giftlist");
				Date time=result.getDate("time");
				
				GiftBillPO tmpPO=new GiftBillPO(id, userid, memberid, giftlist, time, state);
				
				results.add(tmpPO);
			}
			
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取赠送单列表
	 */
	@Override
	public ArrayList<GiftBillPO> findGiftBills() throws RemoteException {

		String sql="select * from giftbills";
		ArrayList<GiftBillPO> results=new ArrayList<>();
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				long id=result.getLong("id");
				long userid=result.getLong("userid");
				long memberid=result.getLong("memberid");
				String giftlist=result.getString("giftlist");
				Date time=result.getDate("time");
				int state=result.getInt("state");
				GiftBillPO tmpPO=new GiftBillPO(id, userid, memberid, giftlist, time, state);
				
				results.add(tmpPO);
			}
			
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据ID查找赠送单
	 */
	@Override
	public GiftBillPO findGiftBillbyID(long id) throws RemoteException {
		String sql="select * from giftbills where id='"+id+"'";
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				
				long userid=result.getLong("userid");
				long memberid=result.getLong("memberid");
				String giftlist=result.getString("giftlist");
				Date time=result.getDate("time");
				int state=result.getInt("state");
				GiftBillPO tmpPO=new GiftBillPO(id, userid, memberid, giftlist, time, state);
				
				return tmpPO;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据时间查找赠送单
	 */
	@Override
	public ArrayList<GiftBillPO> findGiftBillsbyTime(Date time) throws RemoteException {
		String sql="select * from giftbills where time='"+time+"'";
		
		ArrayList<GiftBillPO> results=new ArrayList<>();
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				long id=result.getLong("id");
				long userid=result.getLong("userid");
				long memberid=result.getLong("memberid");
				String giftlist=result.getString("giftlist");
				int state=result.getInt("state");
				GiftBillPO tmpPO=new GiftBillPO(id, userid, memberid, giftlist, time, state);
				
				results.add(tmpPO);
			}
			
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	

	
	
}
