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
import data.memberdata.MemberDataImpl;
import data.userdata.UserDataImpl;
import dataservice.billdataservice.SaleBillDataService;
import po.SaleBillPO;

public class SaleBillDataImpl implements SaleBillDataService{

	/**
	 * 新增销售单
	 */
	@Override
	public boolean insert(SaleBillPO po) throws RemoteException {
		String sql="insert into salebills (id,userid,memberid,commoditylist,sum,time,state,num,remark,coupon,discount,ultimate)"
				+ " values "
				+ "('"+po.getID()+"','"+po.getUserID()+"','"+po.getMemberID()+"','"+po.getCommodityList()+"','"+po.getSum()
				+"','"+po.getTime()+"','"+po.getState()+"','"+po.getNum()+"','"+po.getRemark()+"','"+po.getCoupon()+
				"','"+po.getDiscount()+"','"+po.getUltimate()+"')";
		
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
	 * 删除销售单
	 */
	@Override
	public boolean delete(SaleBillPO po) throws RemoteException {
		String sql="delete from salebills where id='"+po.getID()+"'";
		
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
	 * 维护销售单
	 */
	@Override
	public boolean update(SaleBillPO po) throws RemoteException {
		String sql="update salebills set state='"+po.getState()+"' where id='"+po.getID()+"'";
		
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
	 * 根据ID查找销售单
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
				int coupon=result.getInt("coupon");
				double discount=result.getDouble("discount");
				double ultimate=result.getDouble("ultimate");
				
				
				SaleBillPO tmpPO=new SaleBillPO(id, userid, memberid, commoditylist, sum, state, time, num, remark, coupon, discount, ultimate);
				
				return tmpPO;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查找销售单列表
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
				
				int coupon=result.getInt("coupon");
				double discount=result.getDouble("discount");
				double ultimate=result.getDouble("ultimate");
				
				
				SaleBillPO tmpPO=new SaleBillPO(id, userid, memberid, commoditylist, sum, state, time, num, remark, coupon, discount, ultimate);				
				results.add(tmpPO);
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据时间查找销售单
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
				
				int coupon=result.getInt("coupon");
				double discount=result.getDouble("discount");
				double ultimate=result.getDouble("ultimate");
				
				
				SaleBillPO tmpPO=new SaleBillPO(id, userid, memberid, commoditylist, sum, state, time, num, remark, coupon, discount, ultimate);				results.add(tmpPO);
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据状态查找销售单
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
				
				int coupon=result.getInt("coupon");
				double discount=result.getDouble("discount");
				double ultimate=result.getDouble("ultimate");
				SaleBillPO tmpPO=new SaleBillPO(id, userid, memberid, commoditylist, sum, state, time, num, remark, coupon, discount, ultimate);
				results.add(tmpPO);
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<SaleBillPO> findSaleBillbyField(String commodity, String user, String member)
			throws RemoteException {
		boolean ce=true;
		boolean ue=true;
		boolean me=true;
		long userid=-1,memberid=-1;
		String sql="";
		if(commodity==null||commodity.length()<=0){
			ce=false;
		}
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
		if(ue&&me&&ce){
			sql="select * from salebills where userid='"+userid+"' and memberid='"+memberid+"' and commoditylist like '%,"+commodity+",%'";
		}else if(!ue&&me&&ce){
			sql="select * from salebills where memberid='"+memberid+"' and commoditylist like '%,"+commodity+",%'";
		}else if(ue&&!me&&ce){
			sql="select * from salebills where userid='"+userid+"' and commoditylist like '%,"+commodity+",%'";
		}else if(ue&&me&&!ce){
			sql="select * from salebills where userid='"+userid+"' and memberid='"+memberid+"'";
		}else if(!ue&&!me&&ce){
			sql="select * from salebills where commoditylist like '%,"+commodity+",%'";
		}else if(!ue&&me&&!ce){
			sql="select * from salebills where memberid='"+memberid+"'";
		}else if(ue&&!me&&!ce){
			sql="select * from salebills where userid='"+userid+"'";
		}else{
			sql="select * from salebills";
		}
		ArrayList<SaleBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				String id=result.getString("id");
				String commoditylist=result.getString("commoditylist");
				double sum=result.getDouble("sum");
				Date time=result.getDate("time");
				int state =result.getInt("state");
				int num=result.getInt("num");
				String remark=result.getString("remark");
				
				long usertmpid=result.getLong("userid");
				long membertmpid=result.getLong("memberid");
				
				int coupon=result.getInt("coupon");
				double discount=result.getDouble("discount");
				double ultimate=result.getDouble("ultimate");
				SaleBillPO tmpPO=new SaleBillPO(id, usertmpid, membertmpid, commoditylist, sum, state, time, num, remark, coupon, discount, ultimate);				
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
	public ArrayList<SaleBillPO> findSaleBillbyUser(long userid) throws RemoteException {
		String sql="select * from salebills where userid='"+userid+"'";
		
		ArrayList<SaleBillPO> results=new ArrayList<>();
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				String id=result.getString("id");
				String commoditylist=result.getString("commoditylist");
				double sum=result.getDouble("sum");
				Date time=result.getDate("time");
				int state =result.getInt("state");
				int num=result.getInt("num");
				String remark=result.getString("remark");
				
				int coupon=result.getInt("coupon");
				double discount=result.getDouble("discount");
				double ultimate=result.getDouble("ultimate");
				
				long memberid=result.getLong("memberid");
				SaleBillPO tmpPO=new SaleBillPO(id, userid, memberid, commoditylist, sum, state, time, num, remark, coupon, discount, ultimate);				
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
