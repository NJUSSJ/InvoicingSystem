package data.billdata;

import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.datafactory.DataFactory;
import dataservice.billdataservice.SaleBillDataService;
import dataservice.billdataservice.SaleReturnBillDataService;
import po.SaleBillPO;
import po.SaleReturnBillPO;

public class SaleReturnDataImpl implements SaleReturnBillDataService {

	/**
	 * 新增销售退货单
	 */
	@Override
	public boolean insert(SaleReturnBillPO po) throws RemoteException {
		String sql="insert into salereturnbills (id,userid,memberid,commoditylist,sum,time,state,num,remark)"
				+ "values"
				+ "('"+po.getID()+"','"+po.getUserID()+"','"+po.getMemberID()+"','"+po.getCommodityList()+"','"+po.getSum()
				+"','"+po.getTime()+"','"+po.getState()+"','"+po.getSum()+"','"+po.getNum()+"','"+po.getRemark()+"')";
		
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
	 * 删除销售退货单
	 */
	@Override
	public boolean delete(SaleReturnBillPO po) throws RemoteException {
String sql="delete from salereturnbills where id='"+po.getID()+"')";
		
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
	 * 维护销售退货单
	 */
	@Override
	public boolean update(SaleReturnBillPO po) throws RemoteException {
		String sql="update salereturnbills set state='"+po.getState()+"' where id=="+po.getID()+"'";
		
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
	public SaleReturnBillPO findSaleReturnBillbyID(String id) throws RemoteException {
		String sql="select * from salereturnbills where id='"+id+"'";
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
				
				SaleReturnBillPO tmpPO=new SaleReturnBillPO(id, userid, memberid, commoditylist, sum, state, time, num, remark);
				return tmpPO;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查找销售退货单列表
	 */
	@Override
	public ArrayList<SaleReturnBillPO> findSaleReturnBills() throws RemoteException {
		String sql="select * from salereturnbills ";
		ArrayList<SaleReturnBillPO> results=new ArrayList<>();
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
				
				SaleReturnBillPO tmpPO=new SaleReturnBillPO(id, userid, memberid, commoditylist, sum, state, time, num, remark);
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
	public ArrayList<SaleReturnBillPO> findSaleReturnBillbyTime(Date time) throws RemoteException {
		String sql="select * from salereturnbills where time='"+time+"'";
		ArrayList<SaleReturnBillPO> results=new ArrayList<>();
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
				
				SaleReturnBillPO tmpPO=new SaleReturnBillPO(id, userid, memberid, commoditylist, sum, state, time, num, remark);
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
	public ArrayList<SaleReturnBillPO> findSaleReturnBillbyState(int state) throws RemoteException {
		String sql="select * from salereturnbills where state='"+state+"'";
		ArrayList<SaleReturnBillPO> results=new ArrayList<>();
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
				
				SaleReturnBillPO tmpPO=new SaleReturnBillPO(id, userid, memberid, commoditylist, sum, state, time, num, remark);
				results.add(tmpPO);
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
