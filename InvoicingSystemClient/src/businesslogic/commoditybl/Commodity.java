package businesslogic.commoditybl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import businesslogic.billbl.CommodityLineItem;
import businesslogic.billbl.CommodityList;
import businesslogic.billbl.ImportBillController;
import businesslogic.billbl.ImportReturnBillController;
import businesslogic.billbl.SaleBillController;
import businesslogic.billbl.SaleReturnBillController;
import businesslogicservice.commodityblservice.CommodityBLService;
import po.CategoryPO;
import po.CommodityPO;
import rmi.RemoteHelper;
import vo.CategoryVO;
import vo.CommodityVO;
import vo.ImportBillVO;
import vo.ImportReturnBillVO;
import vo.SaleBillVO;
import vo.SaleReturnBillVO;
import vo.StockCheckInfoVO;
import vo.StockInventoryInfoVO;

public class Commodity{
	public boolean addCommodity(CommodityVO commodityVO){
		try {
			return RemoteHelper.getInstance().getCommodityDataService().insert(commodityVO.toCommodityPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean deleteCommodity(CommodityVO commodityVO){
		try {
			return RemoteHelper.getInstance().getCommodityDataService().delete(commodityVO.toCommodityPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean updateCommodity(CommodityVO commodityVO){
		try {
			return RemoteHelper.getInstance().getCommodityDataService().update(commodityVO.toCommodityPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	public CommodityVO findCommodityByName(String name){
		try {
			return toCommodityVO(RemoteHelper.getInstance().getCommodityDataService().findCommoditybyName(name));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public CommodityVO findCommodityByID(long id){
		try {
			return toCommodityVO(RemoteHelper.getInstance().getCommodityDataService().findCommoditybyID(id));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<CommodityVO> findCommodityByField(String field) {
		ArrayList<CommodityVO> temp = new ArrayList<CommodityVO>();
		try {
			ArrayList<CommodityPO> commodity=RemoteHelper.getInstance().getCommodityDataService().findCommoditiesbyField();
			for(int i=0;i<commodity.size();i++){
				temp.add(toCommodityVO(commodity.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return temp;
	}
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
		for(SaleBillVO bill:saleBills){
			list=bill.getList();
			for(int i=0;i<list.getListSize();i++){
				CommodityLineItem item=list.get(i);
				CommodityVO cvo=ccon.findCommodityByID(item.getCommodityID());
				StockCheckInfoVO vo=new StockCheckInfoVO(item.getCommodityID(),cvo.getName(),cvo.getModel(),
			item.getNum(),0,item.getNum()*item.getSalePrice(),0,item.getNum(),0,item.getNum()*item.getSalePrice(),0); 
				result.add(vo);
			}
		}
		for(ImportBillVO bill:importBills){
			list=bill.getCommodityList();
			for(int i=0;i<list.getListSize();i++){
				CommodityLineItem item=list.get(i);
				CommodityVO cvo=ccon.findCommodityByID(item.getCommodityID());
				StockCheckInfoVO vo=new StockCheckInfoVO(item.getCommodityID(),cvo.getName(),cvo.getModel(),
			0,list.getNum(),0,item.getNum()*item.getImportPrice(),0,list.getNum(),0,item.getNum()*item.getImportPrice());
				result.add(vo);
			}
		}
		for(ImportReturnBillVO bill:importReturnBills){
			list=bill.getList();
			for(int i=0;i<list.getListSize();i++){
				CommodityLineItem item=list.get(i);
				CommodityVO cvo=ccon.findCommodityByID(item.getCommodityID());
				StockCheckInfoVO vo=new StockCheckInfoVO(item.getCommodityID(),cvo.getName(),cvo.getModel(),
			item.getNum(),0,item.getNum()*item.getSalePrice(),0,0,0,0,0); 
				result.add(vo);
			}
		}
		for(SaleReturnBillVO bill:saleReturnBills){
			list=bill.getList();
			for(int i=0;i<list.getListSize();i++){
				CommodityLineItem item=list.get(i);
				CommodityVO cvo=ccon.findCommodityByID(item.getCommodityID());
				StockCheckInfoVO vo=new StockCheckInfoVO(item.getCommodityID(),cvo.getName(),cvo.getModel(),
			0,list.getNum(),0,item.getNum()*item.getImportPrice(),0,0,0,0);
				result.add(vo);
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
		for(CommodityVO com:comVOs){
			line++;
			StockInventoryInfoVO vo=new StockInventoryInfoVO(line,com.getName(),com.getModel(),
					com.getStockNum(),com.getSalePrice());
			result.add(vo);
 		}
		return result;
	}
	/**
	 * 返回所有商品
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
	public long findLargestIDofCommodity(){
		try {
			return RemoteHelper.getInstance().getCommodityDataService().getLargestIDofCommodity();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return -2;
	}
}
