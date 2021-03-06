package businesslogic.billbl;

import java.util.ArrayList;

import businesslogic.commoditybl.CommodityController;
import vo.CommodityVO;

public class CommodityList {
	
	public ArrayList<CommodityLineItem> list;
	
	public CommodityList() {
		list=new ArrayList<>();
	}
	/**
	 * 
	 * @param info:形式为"num,id,salePrice,importPrice,remark num,id,salePrice,importPrice,remark..."的字符串
	 */
	public CommodityList(String info){
			list=new ArrayList<>();
			String[] commodityInfo=info.split(" ");
			for(int i=0;i<commodityInfo.length;i++){
				if(commodityInfo[i]!=null&&commodityInfo[i].length()>0){
				String[] details=commodityInfo[i].split(",");
				int num=Integer.parseInt(details[0]);
				long id=Long.parseLong(details[1]);
				double salePrice=Double.parseDouble(details[2]);
				double importPrice=Double.parseDouble(details[3]);
				String remark="";
				if(details.length>=4){
					remark=details[4];
				}
				list.add(new CommodityLineItem(num,id,salePrice,importPrice,remark));
				}
			}
	}
	
	/**
	 * 增加一个item到list中
	 * 
	 */
	public void addCommodity(CommodityLineItem item) {
		list.add(item);
	}
	
	/**
	 * 从list中删除指定的item
	 * 
	 */
	public void deleteCommodity(CommodityLineItem item) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).commodityid==item.commodityid) {
				list.remove(i);
			}
		}
	}

	/**
	 * 
	 * @return list里所有商品的售价之和
	 */
	public double getSaleTotal() {
		double total=0.0;
		for(int i=0;i<list.size();i++) {
			total+=list.get(i).num*list.get(i).salePrice;
		}
		return total;
	}
	/**
	 * 
	 * @return list里所有商品的进价之和
	 */
	public double getImportTotal(){
		double total=0;
		for(int i=0;i<list.size();i++) {
			total+=list.get(i).num*list.get(i).importPrice;
		}
		return total;

	}

	/**
	 * 
	 * @return list里所有商品的数量之和
	 */
	public int getNum() {
		int num=0;
		for(int i=0;i<list.size();i++) {
			num+=list.get(i).num;
		}
		return num;	
	}
	/**
	 * @return 形式为"num,id,salePrice,importPrice num,id,salePrice,importPrice..."的字符串
	 */
	public String toString(){
		String temp="";
		for(int i=0;i<list.size();i++){
			String remark=list.get(i).getRemark();
			if(remark.equals("")) remark="无";
			temp+=list.get(i).getNum()+","+list.get(i).getCommodityID()+","+
		list.get(i).getSalePrice()+","+list.get(i).getImportPrice()+","+remark;
			if(i!=list.size()-1){
				temp+=" ";
			}
		}
		return temp;
	}
	/**
	 * 
	 * @return list里商品item的个数
	 */
	public int getListSize(){
		return list.size();
	}
	/**
	 * 返回每个item的商品名称及商品数量
	 * @return 形式为"name×num name×num..."的字符串
	 */
	public String getNumInfo(){
		String temp="";
		CommodityController ccon=new CommodityController();
		for(CommodityLineItem each:list){
			CommodityVO vo=ccon.findCommodityByID(each.getCommodityID());
			temp+=vo.getName()+"×"+each.getNum()+" ";
		}
		return temp;
	}
	/**
	 * 返回每个item的商品名称
	 * @return 形式为"name name name..."的字符串
	 */
	public String getNameInfo(){
		String temp="";
		CommodityController ccon=new CommodityController();
		for(CommodityLineItem each:list){
			CommodityVO vo=ccon.findCommodityByID(each.getCommodityID());
			temp+=vo.getName()+" ";
		}
		return temp;
	}
	/**
	 * @return 返回指定id的商品是否在list中
	 */
	public boolean hasCommodity(long id){
		for(CommodityLineItem item:list){
			if(item.getCommodityID()==id){
				return true;
			}
		}
		return false;
	}
	/**
	 * 根据id查找list里的商品
	 * @param id 商品id
	 * @return list里的商品，如果不存在返回null
	 */
	public CommodityLineItem findCommodity(long id){
		for(CommodityLineItem item:list){
			if(item.getCommodityID()==id){
				return item;
			}
		}
		return null;
	}
	/**
	 * @return list里的第index个item
	 */
	public CommodityLineItem get(int index){
		return list.get(index);
	}
	
}
