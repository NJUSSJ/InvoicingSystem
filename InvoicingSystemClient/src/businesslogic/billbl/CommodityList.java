package businesslogic.billbl;

import java.util.ArrayList;

import businesslogic.commoditybl.CommodityController;
import vo.CommodityVO;

public class CommodityList {
	
	ArrayList<CommodityLineItem> list;
	
	public CommodityList() {
		// TODO Auto-generated constructor stub
		list=new ArrayList<>();
	}
	/**
	 * 
	 * @param info:��ʽΪ"id,num,salePrice,importPrice id,num,salePrice,importPrice..."���ַ���
	 */
	public CommodityList(String info){
		list=new ArrayList<>();
		String[] commodityInfo=info.split(" ");
		for(int i=0;i<commodityInfo.length;i++){
			String[] details=commodityInfo[i].split(",");
			int num=Integer.parseInt(details[0]);
			long id=Long.parseLong(details[1]);
			double salePrice=Double.parseDouble(details[2]);
			double importPrice=Double.parseDouble(details[3]);
			list.add(new CommodityLineItem(num,id,salePrice,importPrice));
		}
	}
	/**
	 * ����һ��item��list��
	 * 
	 */
	public void addCommodity(CommodityLineItem item) {
		list.add(item);
	}
	/**
	 * ��list��ɾ��ָ����item
	 * 
	 */
	public void deleteCommodity(CommodityLineItem item) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).equals(item)) {
				list.remove(i);
			}
		}
	}

	/**
	 * 
	 * @return list��������Ʒ���ۼ�֮��
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
	 * @return list��������Ʒ�Ľ���֮��
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
	 * @return list��������Ʒ������֮��
	 */

	public int getNum() {
		int num=0;
		for(int i=0;i<list.size();i++) {
			num+=list.get(i).num;
		}
		return num;	
	}
	/**
	 * @return ��ʽΪ"id,num,salePrice,importPrice id,num,salePrice,importPrice..."���ַ���
	 */
	public String toString(){
		String temp="";
		for(int i=0;i<list.size();i++){
			temp+=list.get(i).getNum()+","+list.get(i).getCommodityID()+","+
		list.get(i).getSalePrice()+","+list.get(i).getImportPrice();
			if(i!=list.size()-1){
				temp+=" ";
			}
		}
		return temp;
	}
	/**
	 * 
	 * @return list����Ʒitem�ĸ���
	 */
	public int getListSize(){
		return list.size();
	}
	/**
	 * ����ÿ��item����Ʒ���Ƽ���Ʒ����
	 * @return ��ʽΪ"name��num name��num..."���ַ���
	 */
	public String getNumInfo(){
		String temp="";
		CommodityController ccon=new CommodityController();
		for(CommodityLineItem each:list){
			CommodityVO vo=ccon.findCommodityByID(each.getCommodityID());
			temp+=vo.getName()+"��"+each.getNum()+" ";
		}
		return temp;
	}
	/**
	 * @return ����ָ��id����Ʒ�Ƿ���list��
	 */
	public boolean hasCommodity(long id){
		for(CommodityLineItem item:list){
			if(item.getCommodityID()==id){
				return true;
			}
		}
		return false;
	}
	public CommodityLineItem findCommodity(long id){
		for(CommodityLineItem item:list){
			if(item.getCommodityID()==id){
				return item;
			}
		}
		return null;
	}
}
