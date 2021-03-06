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
import data.memberdata.MemberDataImpl;
import data.userdata.UserDataImpl;
import dataservice.billdataservice.PayBillDataService;
import po.PayBillPO;

public class PayBillDataImpl implements PayBillDataService {

	/**
	 * 新增收款单
	 */
	@Override
	public boolean insert(PayBillPO po) throws RemoteException {
		String sql="insert into paybills (id,userid,memberid,accountlist,sum,time,state)"
				+ " values "
				+ "('"+po.getID()+"','"+po.getUserID()+"','"+po.getMemberID()+"','"+po.getAccountList()+"','"+po.getSum()+"','"+po.getTime()+"','"+po.getState()+"')";
		
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
	 * 删除收款单
	 */
	@Override
	public boolean delete(PayBillPO po) throws RemoteException {
		String sql="delete from paybills where id='"+po.getID()+"'";
		
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
	 * 维护收款单
	 *
	 */
	@Override
	public boolean update(PayBillPO po) throws RemoteException {
		String sql="update paybills set state='"+po.getState()+"' where id='"+po.getID()+"'";
		
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
	public PayBillPO findPayBillbyID(String id) throws RemoteException {
		String sql="select * from paybills where id='"+id+"'";
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				
				long userid=result.getLong("userid");
				long memberid=result.getLong("memberid");
				String accountlist=result.getString("accountlist");
				double sum=result.getDouble("sum");
				Date time=result.getDate("time");
				int state=result.getInt("state");
				
				PayBillPO tmpPO=new PayBillPO(id, userid, memberid, accountlist, sum, time, state);
				
				return tmpPO;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取收款单列表
	 */
	@Override
	public ArrayList<PayBillPO> findPayBills() throws RemoteException {
		String sql="select * from paybills";
		ArrayList<PayBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				String id=result.getString("id");
				long userid=result.getLong("userid");
				long memberid=result.getLong("memberid");
				String accountlist=result.getString("accountlist");
				double sum=result.getDouble("sum");
				Date time=result.getDate("time");
				int state=result.getInt("state");
				
				PayBillPO tmpPO=new PayBillPO(id, userid, memberid, accountlist, sum, time, state);
				
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
	public ArrayList<PayBillPO> findPayBillbyTime(Date time) throws RemoteException {
		String sql="select * from paybills where time='"+time+"'";
		ArrayList<PayBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				String id=result.getString("id");
				long userid=result.getLong("userid");
				long memberid=result.getLong("memberid");
				String accountlist=result.getString("accountlist");
				double sum=result.getDouble("sum");
				int state=result.getInt("state");
				
				PayBillPO tmpPO=new PayBillPO(id, userid, memberid, accountlist, sum, time, state);
				
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
	public ArrayList<PayBillPO> findPayBillbyState(int state) throws RemoteException {
		String sql="select * from paybills where state='"+state+"'";
		ArrayList<PayBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				String id=result.getString("id");
				long userid=result.getLong("userid");
				long memberid=result.getLong("memberid");
				String accountlist=result.getString("accountlist");
				double sum=result.getDouble("sum");
				Date time=result.getDate("time");
				
				PayBillPO tmpPO=new PayBillPO(id, userid, memberid, accountlist, sum, time, state);
				
				results.add(tmpPO);
				
				
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<PayBillPO> findPayBillbyField(String user,String member) throws RemoteException {
		boolean ue=true;
		boolean me=true;
		long userid=-1,memberid=-1;
		String sql="";
		if(user==null||user.length()<=0){
			ue=false;
		}else{
			userid=new UserDataImpl().findUserbyName(user).getID();
		}
		if(member==null||member.length()<=0){
			me=false;
		}else{
			memberid=new MemberDataImpl().findMemberbyName(member).getID();
		}
		if(ue&&me){
			sql="select * from paybills where userid='"+userid+"' and memberid='"+memberid+"'";
			
		}else if(!ue&&me){
			sql="select * from paybills where memberid='"+memberid+"'";
		}else if(ue&&!me){
			sql="select * from paybills where userid="+userid+"'";
		}else{
			sql="select * from paybills";
		}
		ArrayList<PayBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				String id=result.getString("id");
				
				String accountlist=result.getString("accountlist");
				double sum=result.getDouble("sum");
				Date time=result.getDate("time");
				int state=result.getInt("state");
				
				long usertmpid=result.getLong("userid");
				long membertmpid=result.getLong("memberid");
				
				PayBillPO tmpPO=new PayBillPO(id, usertmpid, membertmpid, accountlist, sum, time, state);
				
				if(state==1||state==3)
				results.add(tmpPO);
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<PayBillPO> findPayBillbyUser(long userid) throws RemoteException {
		String sql="select * from paybills where userid='"+userid+"'";
		ArrayList<PayBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				String id=result.getString("id");
				
				String accountlist=result.getString("accountlist");
				double sum=result.getDouble("sum");
				Date time=result.getDate("time");
				int state=result.getInt("state");
				long memberid=result.getLong("memberid");
				
				PayBillPO tmpPO=new PayBillPO(id, userid, memberid, accountlist, sum, time, state);
				
				if(state==1||state==2)
				results.add(tmpPO);
				
				
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
