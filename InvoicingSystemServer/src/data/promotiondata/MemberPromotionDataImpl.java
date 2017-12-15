package data.promotiondata;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.datafactory.DataFactory;
import dataservice.promotiondataservice.MemberPromotionDataService;
import po.MemberPromotionPO;
/**
 * 
 * @author shisj
 *
 */
public class MemberPromotionDataImpl implements MemberPromotionDataService{

	@Override
	public boolean insert(MemberPromotionPO po) throws RemoteException {
		String sql="insert into memberpromotions (id,rank,giftlist,coupon) "
				+ "values "
				+ "('"+po.getID()+"','"+po.getRank()+"','"+po.getGiftlist()+"','"+po.getCoupon()+"')";
		
		try {
			if(DataFactory.statement.executeUpdate(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(MemberPromotionPO po) throws RemoteException {
		String sql="delete from memberpromotions where id='"+po.getID()+"'";
		
		try {
			if(DataFactory.statement.executeUpdate(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(MemberPromotionPO po) throws RemoteException {
		String sql="update memberpromotions set id='"+po.getID()+"',rank='"+po.getRank()+"',giftlist='"+po.getGiftlist()+"',coupon='"+po.getCoupon()+"'";
		try {
			if(DataFactory.statement.executeUpdate(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<MemberPromotionPO> findMemberPromotions() throws RemoteException {
		String sql="select * from memberpromotions";
		
		ArrayList<MemberPromotionPO> results=new ArrayList<>();
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				long id=result.getLong("id");
				int rank=result.getInt("rank");
				String giftid=result.getString("giftlist");
				int coupon=result.getInt("coupon");
				double discount=result.getDouble("discount");
				
				MemberPromotionPO tmpPO=new MemberPromotionPO(id, rank, discount, giftid, coupon);
				
				results.add(tmpPO);
			}
			
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<MemberPromotionPO> findMemberPromotionsbyRank(int rank) throws RemoteException {
		String sql="select * from memberpromotions where rank='"+rank+"'";
		
		ArrayList<MemberPromotionPO> results=new ArrayList<>();
		
		try {
			ResultSet result=DataFactory.statement.executeQuery(sql);
			
			while(result.next()) {
				long id=result.getLong("id");
				
				String giftid=result.getString("giftlist");
				int coupon=result.getInt("coupon");
				double discount=result.getDouble("discount");
				
				MemberPromotionPO tmpPO=new MemberPromotionPO(id, rank, discount, giftid, coupon);
				
				results.add(tmpPO);
			}
			
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
