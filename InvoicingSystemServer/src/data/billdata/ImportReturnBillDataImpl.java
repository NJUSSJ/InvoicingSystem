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
import dataservice.billdataservice.ImportReturnBillDataService;
import po.ImportReturnBillPO;

public class ImportReturnBillDataImpl implements ImportReturnBillDataService {

	/**
	 * 新增进货退货单
	 */
	@Override
	public boolean insert(ImportReturnBillPO po) throws RemoteException {
		String sql="insert into importreturnbills (id,userid,memberid,sum,state,time,commoditylist,num,remark)"
				+ " VALUES "
				+ "('"+po.getID()+"','"+po.getUserID()+"','"+po.getMemberID()+"','"+po.getSum()+"','"+po.getState()+"','"+po.getTime()+"','"+po.getCommodityList()+"','"+po.getNum()+"','"+po.getRemark()+"')";
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
	 * 删除进货退货单
	 */
	@Override
	public boolean delete(ImportReturnBillPO po) throws RemoteException {
		String sql="delete from importreturnbills where id="+po.getID();
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
	 * 更新进货退货单
	 */
	@Override
	public boolean update(ImportReturnBillPO po) throws RemoteException {
		String sql="update importreturnbills set state='"+po.getState()+"'where id="+po.getID();
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
	 * 根据ID查找进货退货单
	 */
	@Override
	public ImportReturnBillPO findImportReturnBillbyID(String id) throws RemoteException {
String sql="select * from importreturnbills where id='"+id+"'";
		
		
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				int state=result.getInt("state");
				long userid=result.getLong("userid");
				long memberid=result.getLong("memberid");
				double sum=result.getDouble("sum");
				Date time=result.getDate("time");
				String commoditylist=result.getString("commoditylist");
				int num=result.getInt("num");
				String remark=result.getString("remark");
				ImportReturnBillPO tmpPO=new ImportReturnBillPO(id, userid, memberid, commoditylist, sum, time, state, num, remark);
				
				return tmpPO;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据状态查找
	 */
	@Override
	public ArrayList<ImportReturnBillPO> findImportReturnBillbyState(int state) throws RemoteException {
		String sql="select * from importreturnbills where state='"+state+"'";
		
		ArrayList<ImportReturnBillPO> results=new ArrayList<>();
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				String id=result.getString("id");
				long userid=result.getLong("userid");
				long memberid=result.getLong("memberid");
				double sum=result.getDouble("sum");
				Date time=result.getDate("time");
				String commoditylist=result.getString("commoditylist");
				int num=result.getInt("num");
				String remark=result.getString("remark");
				ImportReturnBillPO tmpPO=new ImportReturnBillPO(id, userid, memberid, commoditylist, sum, time, state, num, remark);
				
				results.add(tmpPO);
				
			}
			
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查找进货退货单列表
	 */
	@Override
	public ArrayList<ImportReturnBillPO> findImportReturnBills() throws RemoteException {
		String sql="select * from importreturnbills";
		
		ArrayList<ImportReturnBillPO> results=new ArrayList<>();
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				String id=result.getString("id");
				long userid=result.getLong("userid");
				long memberid=result.getLong("memberid");
				double sum=result.getDouble("sum");
				Date time=result.getDate("time");
				String commoditylist=result.getString("commoditylist");
				int num=result.getInt("num");
				String remark=result.getString("remark");
				int state=result.getInt("state");
				ImportReturnBillPO tmpPO=new ImportReturnBillPO(id, userid, memberid, commoditylist, sum, time, state, num, remark);
				
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
	public ArrayList<ImportReturnBillPO> findImportReturnBillbyTime(Date time) throws RemoteException {
		String sql="select * from importreturnbills where time='"+time+"'";
		
		ArrayList<ImportReturnBillPO> results=new ArrayList<>();
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				String id=result.getString("id");
				long userid=result.getLong("userid");
				long memberid=result.getLong("memberid");
				double sum=result.getDouble("sum");
				int state=result.getInt("state");
				String commoditylist=result.getString("commoditylist");
				int num=result.getInt("num");
				String remark=result.getString("remark");
				ImportReturnBillPO tmpPO=new ImportReturnBillPO(id, userid, memberid, commoditylist, sum, time, state, num, remark);
				
				results.add(tmpPO);
				
			}
			
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<ImportReturnBillPO> findImportReturnBillbyField(String user, String member)
			throws RemoteException {
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
			sql="select * from importreturnbills where userid='"+userid+", and memberid='"+memberid+"'";
		}else if(!ue&&me){
			sql="select * from importreturnbills where memberid='"+memberid+"'";
		}else if(ue&&!me){
			sql="select * from importreturnbills where userid='"+userid+"'";
		}else{
			sql="select * from importreturnbills";
		}
		
		ArrayList<ImportReturnBillPO> results=new ArrayList<>();
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				String id=result.getString("id");
				
				double sum=result.getDouble("sum");
				Date time=result.getDate("time");
				String commoditylist=result.getString("commoditylist");
				int num=result.getInt("num");
				String remark=result.getString("remark");
				int state=result.getInt("state");
				
				long usertmpid=result.getLong("userid");
				long membertmpid=result.getLong("memberid");
				
				ImportReturnBillPO tmpPO=new ImportReturnBillPO(id, usertmpid, membertmpid, commoditylist, sum, time, state, num, remark);
				
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
	public ArrayList<ImportReturnBillPO> findImportReturnBillbyUser(long userid) throws RemoteException {
	String sql="select * from importreturnbills where userid='"+userid+"'";
		
		ArrayList<ImportReturnBillPO> results=new ArrayList<>();
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				String id=result.getString("id");
				
				double sum=result.getDouble("sum");
				Date time=result.getDate("time");
				String commoditylist=result.getString("commoditylist");
				int num=result.getInt("num");
				String remark=result.getString("remark");
				int state=result.getInt("state");
				long memberid=result.getLong("memberid");
				ImportReturnBillPO tmpPO=new ImportReturnBillPO(id, userid, memberid, commoditylist, sum, time, state, num, remark);
				
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
