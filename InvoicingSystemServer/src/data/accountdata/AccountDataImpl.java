package data.accountdata;
/**
 * @author shisj
 */
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.commoditydata.CategoryDataImpl;
import data.commoditydata.CommodityDataImpl;
import data.datafactory.DataFactory;
import data.memberdata.MemberDataImpl;
import dataservice.accountdataservice.AccountDataService;
import po.AccountPO;
import po.BookPO;
import po.CommodityPO;
import po.MemberPO;

public class AccountDataImpl implements AccountDataService {

	/**
	 * 根据id查找账户
	 */
	@Override
	public AccountPO findAccountbyID(long id) throws RemoteException {
		// TODO Auto-generated method stub
		String sql="SELECT id, name, deposit FROM accounts";
		
		//执行数据库sql语句
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			//展开结果数据
			while(result.next()) {
				long tmpid=result.getLong("id");
				String bank=result.getString("name");
				double deposit=result.getDouble("deposit");
				
				AccountPO tmpAccount=new AccountPO(tmpid, deposit, bank);
				if(tmpid==id) {
					return tmpAccount;
				}
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 插入新的账户对象
	 */
	@Override
	public boolean insert(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String sql="INSERT INTO accounts(id,name,deposit) VALUES ("+po.getID()
		+",'"+po.getName()+"','"+po.getDeposit()+"')";
		try {
			if(DataFactory.statement.executeUpdate(sql)>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	
	/**
	 * 删除账户对象
	 */
	@Override
	public boolean delete(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String sql="DELETE FROM accounts WHERE id='"+po.getID()+"'";
		try {
			if(DataFactory.statement.executeUpdate(sql)>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 维护账户对象
	 */
	@Override
	public boolean update(AccountPO po) throws RemoteException {
		
		String sql="UPDATE accounts SET deposit='"+po.getDeposit()+"' WHERE id='"+po.getID()+"'";
		try {
			if(DataFactory.statement.executeUpdate(sql)>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}


	@Override
	public ArrayList<AccountPO> findAccounts() throws RemoteException {
		
		
		String sql="SELECT id, name, deposit FROM accounts";
		ArrayList<AccountPO> results=new ArrayList<>();
		//执行数据库sql语句
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			//展开结果数据
			while(result.next()) {
				long tmpid=result.getLong("id");
				String bank=result.getString("name");
				double deposit=result.getDouble("deposit");
				
				AccountPO tmpAccount=new AccountPO(tmpid, deposit, bank);
				results.add(tmpAccount);
				
				
			}
			return results;
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<AccountPO> findAcountbyField(String field) throws RemoteException {
		String sql="SELECT id, name, deposit FROM accounts where name like '%"+field+"%'";
		ArrayList<AccountPO> results=new ArrayList<>();
		//执行数据库sql语句
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			//展开结果数据
			while(result.next()) {
				long tmpid=result.getLong("id");
				String bank=result.getString("name");
				double deposit=result.getDouble("deposit");
				
				AccountPO tmpAccount=new AccountPO(tmpid, deposit, bank);
				results.add(tmpAccount);
				
				
			}
			return results;
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean backUpDataBase(Date time) throws RemoteException {
		ArrayList<CommodityPO> commodities=new CommodityDataImpl().findCommodities();
		ArrayList<AccountPO> accounts=new AccountDataImpl().findAccounts();
		ArrayList<MemberPO> members=new MemberDataImpl().findMembers();
		
		String commodityList="";
		for(int i=0;i<commodities.size();i++) {
			//顺序：id,name,importPrice,salePrice,model,parent
			long id=commodities.get(i).getID();
			commodityList+=(Long.toString(id)+",");
			String name=commodities.get(i).getName();
			commodityList+=(name+",");
			double importprice=commodities.get(i).getImportPrice();
			commodityList+=(Double.toString(importprice)+",");
			double saleprice=commodities.get(i).getSalePrice();
			commodityList+=(Double.toString(saleprice)+",");
			String model=commodities.get(i).getModel();
			commodityList+=(model+",");
			long parentid=commodities.get(i).getParentID();
			String parent=new CategoryDataImpl().findCategorybyID(parentid).getName();
			commodityList+=parent+" ";
			
		}
		commodityList=commodityList.substring(0, commodityList.length());
		
		String accountList="";
		for(int i=0;i<accounts.size();i++) {
			//顺序：id,deposit
			long id=accounts.get(i).getID();
			accountList+=(Long.toString(id)+",");
			double deposit=accounts.get(i).getDeposit();
			accountList+=(Double.toString(deposit)+" ");
		}
		accountList=accountList.substring(0,accountList.length());
		
		String memberList="";
		for(int i=0;i<members.size();i++) {
			//顺序：分类, name, tel, shouldget,shoulepay
			int cate=members.get(i).getCategory();
			String category="";
			if(cate==0) {
				category="供应商";
			}else {
				category="客户";
			}
			memberList+=category+",";
			
			String name=members.get(i).getName();
			memberList+=name+",";
			
			int tel=members.get(i).getPhoneNum();
			memberList+=(Integer.toString(tel)+",");
			
			double shouldget=members.get(i).getShouldGet();
			memberList+=(Double.toString(shouldget)+",");
			
			double shouldpay=members.get(i).getShouldPay();
			memberList+=(Double.toString(shouldpay)+" ");
		}
		memberList=memberList.substring(0,memberList.length());
		
		String sql="insert into books (date,commodityList,memberList,accountList) values ('"+time+"','"+commodityList+"','"+memberList+"','"+accountList+"')";
		try {
			if(DataFactory.statement.executeUpdate(sql)>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<BookPO> restore() throws RemoteException {
		String sql= "select * from books";
		
		ArrayList<BookPO> results=new ArrayList<>();
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				Date date=result.getDate("date");
				String commodityList=result.getString("commodityList");
				String accountList=result.getString("accountList");
				String memberList=result.getString("memberList");
				
				BookPO tmpPO=new BookPO(date, commodityList, memberList, accountList);
				
				results.add(tmpPO);
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
