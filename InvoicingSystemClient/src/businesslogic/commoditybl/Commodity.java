package businesslogic.commoditybl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import businesslogic.billbl.CommodityLineItem;
import businesslogic.billbl.CommodityList;
import businesslogic.billbl.GiftBillController;
import businesslogic.billbl.ImportBillController;
import businesslogic.billbl.ImportReturnBillController;
import businesslogic.billbl.LossBillController;
import businesslogic.billbl.OverBillController;
import businesslogic.billbl.SaleBillController;
import businesslogic.billbl.SaleReturnBillController;
import businesslogic.promotionbl.PromotionController;
import po.CommodityPO;
import rmi.RemoteHelper;
import vo.CommodityVO;
import vo.GiftBillVO;
import vo.ImportBillVO;
import vo.ImportReturnBillVO;
import vo.LossBillVO;
import vo.OverBillVO;
import vo.PackagePromotionVO;
import vo.PricePromotionVO;
import vo.SaleBillVO;
import vo.SaleReturnBillVO;
import vo.StockCheckInfoVO;
import vo.StockInventoryInfoVO;

public class Commodity{
	/**
	 * 增加商品
	 * @param commodityVO 商品vo
	 * @return 添加商品结果
	 */
	public boolean addCommodity(CommodityVO commodityVO){
		try {
			return RemoteHelper.getInstance().getCommodityDataService().insert(commodityVO.toCommodityPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	/**
	 * 删除商品
	 * @param commodityVO 商品vo
	 * @return 删除结果，如果商品仍有相关业务未处理则返回false
	 */
	public boolean deleteCommodity(CommodityVO commodityVO){
		try {
			long id=commodityVO.getID();
			String name=commodityVO.getName();
			ArrayList<SaleBillVO> saleBills=new SaleBillController().findSaleBillsByState(0);
			if(saleBills!=null&&saleBills.size()>0) {
				for(SaleBillVO vo:saleBills) {
					if(vo.getList().hasCommodity(id)) {
						return false;
					}
				}
			}
			ArrayList<SaleReturnBillVO> saleReturnBills=new SaleReturnBillController().findSaleReturnBillsByState(0);
			if(saleReturnBills!=null&&saleReturnBills.size()>0) {
				for(SaleReturnBillVO vo:saleReturnBills) {
					if(vo.getList().hasCommodity(id)) {
						return false;
					}
				}
			}
			ArrayList<ImportBillVO> importBills=new ImportBillController().findImportBillsByState(0);
			if(importBills!=null&&importBills.size()>0) {
				for(ImportBillVO vo:importBills) {
					if(vo.getCommodityList().hasCommodity(id)) {
						return false;
					}
				}
			}
			
			ArrayList<ImportReturnBillVO> importReturnBills=new ImportReturnBillController().findImportReturnBillsByState(0);
			if(importReturnBills!=null&&importReturnBills.size()>0) {
				for(ImportReturnBillVO vo:importReturnBills) {
					if(vo.getList().hasCommodity(id)) {
						return false;
					}
				}
			}
			
			ArrayList<OverBillVO> overBills=new OverBillController().findOverBillsByState(0);
			if(overBills!=null&&overBills.size()>0) {
				for(OverBillVO vo:overBills) {
					if(vo.getCommodityName().equals(name)) {
						return false;
					}
				}
			}
			
			ArrayList<LossBillVO> lossBills=new LossBillController().findLossBillsByState(0);
			if(lossBills!=null&&lossBills.size()>0) {
				for(LossBillVO vo:lossBills) {
					if(vo.getCommodityName().equals(name)) {
						return false;
					}
				}
			}
			
			ArrayList<GiftBillVO> giftBills=new GiftBillController().findGiftBillsByState(0);
			if(giftBills!=null&&giftBills.size()>0) {
				for(GiftBillVO vo:giftBills) {
					if(vo.getCommodityList().hasCommodity(id)) {
						return false;
					}
				}
			}
			
			ArrayList<PricePromotionVO> pricePromotions=new PromotionController().findPricePromotions();
			if(pricePromotions!=null&&pricePromotions.size()>0) {
				for(PricePromotionVO vo:pricePromotions) {
					if(vo.getGifts().hasCommodity(id)) {
						return false;
					}
				}
			}
			
			ArrayList<PackagePromotionVO> packagePromotions=new PromotionController().findPackagePromotions();
			if(packagePromotions!=null&&packagePromotions.size()>0) {
				for(PackagePromotionVO vo:packagePromotions) {
					if(vo.getList().hasCommodity(id)) {
						return false;
					}
				}
			}
			return RemoteHelper.getInstance().getCommodityDataService().delete(commodityVO.toCommodityPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	/**
	 * 更新商品
	 * @param commodityVO 商品vo
	 * @return 更新结果
	 */
	public boolean updateCommodity(CommodityVO commodityVO){
		try {
			return RemoteHelper.getInstance().getCommodityDataService().update(commodityVO.toCommodityPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 根据商品名称查找单个商品
	 * @param name 商品名称
	 * @return 查找到的商品vo，如果为空则返回null
	 */
	public CommodityVO findCommodityByName(String name){
		try {
			return toCommodityVO(RemoteHelper.getInstance().getCommodityDataService().findCommoditybyName(name));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	/**
	 * 根据商品id查找单个商品
	 * @param id 商品id
	 * @return 查找到的商品vo，如果为空则返回null
	 */
	public CommodityVO findCommodityByID(long id){
		try {
			return toCommodityVO(RemoteHelper.getInstance().getCommodityDataService().findCommoditybyID(id));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据关键字模糊查找多个商品
	 * @param field 关键字
	 * @return 查找结果，如果为空,返回空list
	 */
	public ArrayList<CommodityVO> findCommodityByField(String field) {
		ArrayList<CommodityVO> temp = new ArrayList<CommodityVO>();
		try {
			ArrayList<CommodityPO> commodity=RemoteHelper.getInstance().getCommodityDataService().findCommoditiesbyField(field);
			if(commodity==null){
				return null;
			}
			for(int i=0;i<commodity.size();i++){
				temp.add(toCommodityVO(commodity.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return temp;
	}
	/**
	 * 
	 * @param commodityPO 商品po
	 * @return 该po转换为vo的结果，如果是null则返回null
	 */
	public CommodityVO toCommodityVO(CommodityPO commodityPO){
		if(commodityPO==null){
			return null;
		}
		return new CommodityVO(commodityPO.getName(),commodityPO.getID(),commodityPO.getModel(),
		commodityPO.getStockNum(),commodityPO.getImportPrice(),commodityPO.getSalePrice(),
		commodityPO.getLateImportPrice(),commodityPO.getLateSalePrice(),commodityPO.getParentID(),commodityPO.getLimit());
	}
	/**
	 * 库存查看
	 */
	public ArrayList<StockCheckInfoVO> getStockInfo(Date start, Date end){
		ArrayList<SaleBillVO> saleBills=new SaleBillController().findSaleBillsByInterval(start, end);
		ArrayList<ImportBillVO> importBills=new ImportBillController().findImportBillsByInterval(start, end);
		ArrayList<SaleReturnBillVO> saleReturnBills=new SaleReturnBillController().findSaleReturnBillsByInterval(start, end);
		ArrayList<ImportReturnBillVO> importReturnBills=new ImportReturnBillController().findImportReturnBillsByInterval(start, end);
		ArrayList<StockCheckInfoVO> result=new ArrayList<StockCheckInfoVO>();
		CommodityController ccon=new CommodityController();
		CommodityList list;
		if(saleBills!=null&&!saleBills.isEmpty()){
			for(SaleBillVO bill:saleBills){
				list=bill.getList();
				for(int i=0;i<list.getListSize();i++){
					CommodityLineItem item=list.get(i);
					CommodityVO cvo=ccon.findCommodityByID(item.getCommodityID());
					boolean existed=false;
					for(StockCheckInfoVO vo:result){
						if(vo.getName().equals(cvo.getName())){
							existed=true;
							vo.setOutStockNum(vo.getOutStockNum()+item.getNum());
							vo.setOutSum(vo.getOutSum()+item.getNum()*item.getSalePrice());
							vo.setSaleNum(vo.getSaleNum()+item.getNum());
							vo.setSaleSum(vo.getSaleSum()+item.getNum()*item.getSalePrice());
							break;
						}
					}
					if(!existed){
						StockCheckInfoVO vo=new StockCheckInfoVO(item.getCommodityID(),cvo.getName(),cvo.getModel(),
							item.getNum(),0,item.getNum()*item.getSalePrice(),0,item.getNum(),0,item.getNum()*item.getSalePrice(),0); 
						result.add(vo);
					}
				}
			}
		}
		if(importBills!=null&&!importBills.isEmpty()){
			for(ImportBillVO bill:importBills){
				list=bill.getCommodityList();
				for(int i=0;i<list.getListSize();i++){
					CommodityLineItem item=list.get(i);
					CommodityVO cvo=ccon.findCommodityByID(item.getCommodityID());
					boolean existed=false;
					for(StockCheckInfoVO vo:result){
						if(vo.getName().equals(cvo.getName())){
							existed=true;
							vo.setInStockNum(vo.getInStockNum()+item.getNum());
							vo.setInSum(vo.getInSum()+item.getNum()*item.getImportPrice());
							vo.setImportNum(vo.getImportNum()+item.getNum());
							vo.setImportSum(vo.getImportSum()+item.getNum()*item.getImportPrice());
						}
					}
					if(!existed){
						StockCheckInfoVO vo=new StockCheckInfoVO(item.getCommodityID(),cvo.getName(),cvo.getModel(),
							0,item.getNum(),0,item.getNum()*item.getImportPrice(),0,item.getNum(),0,item.getNum()*item.getImportPrice());
						result.add(vo);
						}
				}
			}
		}
		if(importReturnBills!=null&&!importReturnBills.isEmpty()){
			for(ImportReturnBillVO bill:importReturnBills){
				list=bill.getList();
				for(int i=0;i<list.getListSize();i++){
					CommodityLineItem item=list.get(i);
					CommodityVO cvo=ccon.findCommodityByID(item.getCommodityID());
					boolean existed=false;
					for(StockCheckInfoVO vo:result){
						if(vo.getName().equals(cvo.getName())){
							existed=true;
							vo.setOutStockNum(vo.getOutStockNum()+item.getNum());
							vo.setOutSum(vo.getOutSum()+item.getNum()*item.getSalePrice());
							break;
						}
					}if(!existed){
						StockCheckInfoVO vo=new StockCheckInfoVO(item.getCommodityID(),cvo.getName(),cvo.getModel(),
							item.getNum(),0,item.getNum()*item.getSalePrice(),0,0,0,0,0); 
						result.add(vo);
					}
				}
			}
		}
		if(saleReturnBills!=null&&!saleReturnBills.isEmpty()){
			for(SaleReturnBillVO bill:saleReturnBills){
				list=bill.getList();
				for(int i=0;i<list.getListSize();i++){
					CommodityLineItem item=list.get(i);
					CommodityVO cvo=ccon.findCommodityByID(item.getCommodityID());
					boolean existed=false;
					for(StockCheckInfoVO vo:result){
						if(vo.getName().equals(cvo.getName())){
							existed=true;
							vo.setInStockNum(vo.getInStockNum()+item.getNum());
							vo.setInSum(vo.getInSum()+item.getNum()*item.getImportPrice());
						}
					}
					if(!existed){
						StockCheckInfoVO vo=new StockCheckInfoVO(item.getCommodityID(),cvo.getName(),cvo.getModel(),
							0,item.getNum(),0,item.getNum()*item.getImportPrice(),0,0,0,0);
						result.add(vo);
					}
				}
			}
		}
		return result;
	}
	/**
	 * 库存盘点
	 */
	public ArrayList<StockInventoryInfoVO> getInventoryInfo() {
		ArrayList<StockInventoryInfoVO> result=new ArrayList<StockInventoryInfoVO>();
		ArrayList<CommodityVO> comVOs=findCommodities();
		int line=0;
		if(comVOs!=null&&!comVOs.isEmpty()){
			for(CommodityVO com:comVOs){
				line++;
				StockInventoryInfoVO vo=new StockInventoryInfoVO(line,com.getName(),com.getModel(),
						com.getStockNum(),com.getSalePrice());
				result.add(vo);
			}
		}
		return result;
	}
	/**
	 * 
	 * @return 所有商品集合的list，如果为空则返回null
	 */
	public ArrayList<CommodityVO> findCommodities(){
		ArrayList<CommodityVO> result=new ArrayList<CommodityVO>();
		try {
			ArrayList<CommodityPO> pos=RemoteHelper.getInstance().getCommodityDataService().findCommodities();
			if(pos==null){
				return null;
			}
			for(CommodityPO po:pos){
				result.add(toCommodityVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 
	 * @return 返回数据库中商品id的最大值,出错时返回-2
	 */
	public long findLargestIDofCommodity(){
		try {
			return RemoteHelper.getInstance().getCommodityDataService().getLargestIDofCommodity();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return -2;
	}
}
