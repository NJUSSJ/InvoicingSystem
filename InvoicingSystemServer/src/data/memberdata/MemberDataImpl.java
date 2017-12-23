package data.memberdata;


import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.datafactory.DataFactory;
import dataservice.memberdataservice.MemberDataService;
import po.MemberPO;

public class MemberDataImpl implements MemberDataService{

	/*
	 * 根据姓名查找客户
	 */
	@Override
	public MemberPO findMemberbyName(String name) throws RemoteException {
		String sql="select * from "
				+ " members "
				+ "where name='"+name+"'";
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				long id=result.getLong("id");
				int rank=result.getInt("rank");
				int category=result.getInt("category");
				String name_=result.getString("name");
				int phonenumber=result.getInt("phonenumber");
				String address=result.getString("address");
				String email=result.getString("email");
				int postcode=result.getInt("postcode");
				double quota=result.getDouble("quota");
				double shouldget=result.getDouble("shouldget");
				double shouldpay=result.getDouble("shouldpay");
				long defaultoperatorid=result.getLong("defaultoperatorid");
				
				return new MemberPO(id, rank, postcode, category, name_, phonenumber, address, email, shouldpay, shouldget, quota, defaultoperatorid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}

	/*
	 * 新增新的客户信息
	 */
	@Override
	public boolean insert(MemberPO po) throws RemoteException {
		
		String sql="insert into members (id, rank, postcode, category, name, phonenumber, address, email, shouldpay, shouldget, quota, defaultoperatorid) "
				+ "values "
				+ "('"+po.getID()+"','"+po.getRank()+"','"+po.getPostCode()+"','"+po.getCategory()+"','"+po.getName()+"','"+po.getPhoneNum()+"','"+po.getAddress()+"','+"
						+ po.getEmail()+"','"+po.getShouldPay()+"','"+po.getShouldGet()+"','"+po.getQuota()+"','"+po.getDefaultOperatorID()+"')";
		try {
			if(DataFactory.statement.executeUpdate(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	/*
	 * 删除一条客户记录
	 */
	@Override
	public boolean delete(MemberPO po) throws RemoteException {
		
		String sql="delete from members where id="+po.getID();
		try {
			if(DataFactory.statement.executeUpdate(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * 维护一条客户记录
	 */
	@Override
	public boolean update(MemberPO po) throws RemoteException {
		
		String sql="update members set rank='"+po.getRank()+"',postcode='"+po.getPostCode()+"',category='"+po.getCategory()+"',name='"
				+ po.getName()+"',phonenumber='"+po.getPhoneNum()+"',address='"+po.getAddress()+"',email='"+po.getEmail()+"',shouldpay='"+po.getShouldPay()+"',shouldget='"+po.getShouldGet()+"',quota='"+po.getQuota()+"',defaultoperatorid='"+po.getDefaultOperatorID()
				+"'where id='"+po.getID()+"'";
		try {
			if(DataFactory.statement.executeUpdate(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	/*
	 * 获取客户列表
	 */
	@Override
	public ArrayList<MemberPO> findMembers() throws RemoteException {
		
		String sql="select * from "
				+ "members";
		
		ArrayList<MemberPO> results=new ArrayList<>();
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				long id=result.getLong("id");
				int rank=result.getInt("rank");
				int category=result.getInt("category");
				String name_=result.getString("name");
				int phonenumber=result.getInt("phonenumber");
				String address=result.getString("address");
				String email=result.getString("email");
				int postcode=result.getInt("postcode");
				double quota=result.getDouble("quota");
				double shouldget=result.getDouble("shouldget");
				double shouldpay=result.getDouble("shouldpay");
				long defaultoperatorid=result.getLong("defaultoperatorid");
				
				MemberPO tmpMemberPO=new MemberPO(id, rank, postcode, category, name_, phonenumber, address, email, shouldpay, shouldget, quota, defaultoperatorid);
				
				results.add(tmpMemberPO);
			}
			
			return results;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 模糊查找客户
	 */
	@Override
	public ArrayList<MemberPO> findMembersbyField(String field) throws RemoteException {

		String sql="select * from "
				+ "members where name like '%"+field+"%'";
		
		ArrayList<MemberPO> results=new ArrayList<>();
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				long id=result.getLong("id");
				int rank=result.getInt("rank");
				int category=result.getInt("category");
				String name_=result.getString("name");
				int phonenumber=result.getInt("phonenumber");
				String address=result.getString("address");
				String email=result.getString("email");
				int postcode=result.getInt("postcode");
				double quota=result.getDouble("quota");
				double shouldget=result.getDouble("shouldget");
				double shouldpay=result.getDouble("shouldpay");
				long defaultoperatorid=result.getLong("defaultoperatorid");
				
				MemberPO tmpMemberPO=new MemberPO(id, rank, postcode, category, name_, phonenumber, address, email, shouldpay, shouldget, quota, defaultoperatorid);
				
				results.add(tmpMemberPO);
			}
			
			return results;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MemberPO findMemberbyID(long id) throws RemoteException {
		String sql="select * from "
				+ "members where id='"+id+"'";
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				int rank=result.getInt("rank");
				int category=result.getInt("category");
				String name_=result.getString("name");
				int phonenumber=result.getInt("phonenumber");
				String address=result.getString("address");
				String email=result.getString("email");
				int postcode=result.getInt("postcode");
				double quota=result.getDouble("quota");
				double shouldget=result.getDouble("shouldget");
				double shouldpay=result.getDouble("shouldpay");
				long defaultoperatorid=result.getLong("defaultoperatorid");
				
				MemberPO tmpMemberPO=new MemberPO(id, rank, postcode, category, name_, phonenumber, address, email, shouldpay, shouldget, quota, defaultoperatorid);
				
				return tmpMemberPO;
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	

}
