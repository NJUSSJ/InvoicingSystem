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
import dataservice.billdataservice.ImportBillDataService;
import po.ImportBillPO;

public class ImportBillDataImpl implements ImportBillDataService {

	/**
	 * 增加一条进货单记录
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public boolean insert(ImportBillPO po) throws RemoteException {
		
		String sql="insert into importbills (id,userid,memberid,sum,state,time,commoditylist,num,remark)"
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
	 * 删除一条进货单记录
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public boolean delete(ImportBillPO po) throws RemoteException {
		
		String sql="delete from importbills where id="+po.getID();
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
	 * 维护进货单记录
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public boolean update(ImportBillPO po) throws RemoteException {
		String sql="update importbills set state='"+po.getState()+"' where id= '"+po.getID()+"'";
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
	 * 根据状态查找进货单
	 * @param state
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<ImportBillPO> findImportBillbyState(int state) throws RemoteException {
		String sql="select * from importbills where state='"+state+"'";
		
		ArrayList<ImportBillPO> results=new ArrayList<>();
		
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
				ImportBillPO tmpPO=new ImportBillPO(id, userid, memberid, commoditylist, sum, time, state, num, remark);
				
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
	 * @param time
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<ImportBillPO> findImportBillbyTime(Date time) throws RemoteException {
		String sql="select * from importbills where time='"+time+"'";
		
		ArrayList<ImportBillPO> results=new ArrayList<>();
		
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
				ImportBillPO tmpPO=new ImportBillPO(id, userid, memberid, commoditylist, sum, time, state, num, remark);
				
				results.add(tmpPO);
				
			}
			
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ImportBillPO findImportBillbyID(String id) throws RemoteException {
		String sql="select * from importbills where id='"+id+"'";
		
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
				ImportBillPO tmpPO=new ImportBillPO(id, userid, memberid, commoditylist, sum, time, state, num, remark);
				
				return tmpPO;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<ImportBillPO> findImportBills() throws RemoteException {
		String sql="select * from importbills";
		
		ArrayList<ImportBillPO> results=new ArrayList<>();
		
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
				ImportBillPO tmpPO=new ImportBillPO(id, userid, memberid, commoditylist, sum, time, state, num, remark);
				
				results.add(tmpPO);
				
			}
			
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<ImportBillPO> findImportBillsByField(String user, String member) throws RemoteException {
		long userid=new UserDataImpl().findUserbyName(user).getID();
		long memberid=new MemberDataImpl().findMemberbyName(member).getID();

		String sql="select * from importbills where userid='"+userid+"' and memberid='"+memberid;
		
		ArrayList<ImportBillPO> results=new ArrayList<>();
		
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
				ImportBillPO tmpPO=new ImportBillPO(id, userid, memberid, commoditylist, sum, time, state, num, remark);
				
				if(state==1)
				results.add(tmpPO);
				
			}
			
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<ImportBillPO> findImportBillsByUser(long userid) throws RemoteException {
		String sql="select * from importbills where userid='"+userid+"'";
		
		ArrayList<ImportBillPO> results=new ArrayList<>();
		
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
				ImportBillPO tmpPO=new ImportBillPO(id, userid, memberid, commoditylist, sum, time, state, num, remark);
				
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
