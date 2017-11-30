package data.memberdata;


import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.datafactory.DataFactory;
import dataservice.memberdataservice.MemberDataService;
import po.LogPO;
import po.MemberPO;

public class MemberDataImpl implements MemberDataService{

	@Override
	public MemberPO find(String name) throws RemoteException {
		// TODO 自动生成的方法存根
		String sql="select id,rank, category,name,phonenumber,address,email,posecode,quota,shouldget,shouldpay,defaultoperatorid from "
				+ "members"
				+ "where name="+name;
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
				double shouldget=result.getDouble("shouleget");
				double shouldpay=result.getDouble("shouldpay");
				long defaultoperatorid=result.getLong("defaultoperatorid");
				
				return new MemberPO(id, rank, postcode, category, name_, phonenumber, address, email, shouldpay, shouldget, quota, defaultoperatorid);
			}
		} catch (SQLException e) {
			
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public boolean insert(MemberPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		String sql="insert into members (id, rank, postcode, category, name, phonenumber, address, email, shouldpay, shouldget, quota, defaultoperatorid)"
				+ "values"
				+ "('"+po.getID()+"','"+po.getRank()+"','"+po.getPostCode()+"','"+po.getCategory()+"','"+po.getName()+"','"+po.getPhoneNum()+"','"+po.getAddress()+"','+"
						+ po.getEmail()+"','"+po.getShouldPay()+"','"+po.getShouldGet()+"','"+po.getQuota()+"','"+po.getDefaultOperatorID()+"')";
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
	public boolean delete(MemberPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		String sql="delete from members where id="+po.getID();
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
	public boolean update(MemberPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		String sql="update giftbills set rank='"+po.getRank()+"',postcode='"+po.getPostCode()+"',category='"+po.getCategory()+"',name='"
				+ po.getName()+"'phonenumber='"+po.getPhoneNum()+"'address='"+po.getAddress()+"'email='"+po.getEmail()+"'shouldpay='"+po.getShouldPay()+"'shouldget='"+po.getShouldGet()+"'quota='"+po.getQuota()+"'defaultoperatorid='"+po.getDefaultOperatorID()
				+"'where id="+po.getID();
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
	public void init() throws RemoteException {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void finish() throws RemoteException {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public ArrayList<MemberPO> findMembers() throws RemoteException {
		// TODO Auto-generated method stub
		String sql="select id,rank, category,name,phonenumber,address,email,posecode,quota,shouldget,shouldpay,defaultoperatorid from "
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
				double shouldget=result.getDouble("shouleget");
				double shouldpay=result.getDouble("shouldpay");
				long defaultoperatorid=result.getLong("defaultoperatorid");
				
				MemberPO tmpMemberPO=new MemberPO(id, rank, postcode, category, name_, phonenumber, address, email, shouldpay, shouldget, quota, defaultoperatorid);
				
				results.add(tmpMemberPO);
			}
			
			return results;
		} catch (SQLException e) {
			
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public ArrayList<MemberPO> fings(String field) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
