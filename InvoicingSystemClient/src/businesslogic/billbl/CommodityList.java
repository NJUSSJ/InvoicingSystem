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
	public CommodityList(String info){
		list=new ArrayList<>();
		String[] commodityInfo=info.split(" ");
		CommodityController comController=new CommodityController();
		for(int i=0;i<commodityInfo.length;i++){
			String[] details=commodityInfo[i].split(",");
			int num=Integer.parseInt(details[0]);
			long id=Long.parseLong(details[1]);
			CommodityVO vo=comController.findCommodityByID(id);
			list.add(new CommodityLineItem(vo,num));
		}
	}
	
	public void addCommodity(CommodityLineItem item) {
		list.add(item);
	}
	
	public void deleteCommodity(CommodityLineItem item) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).equals(item)) {
				list.remove(i);
			}
		}
	}
	
	public int getTotal() {
		int total=0;
		for(int i=0;i<list.size();i++) {
			total+=list.get(i).num*list.get(i).salePrice;
		}
		return total;
	}
	
	public int getNum() {
		int num=0;
		for(int i=0;i<list.size();i++) {
			num+=list.get(i).num;
		}
		return num;	
	}
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
	public int getSize(){
		return list.size();
	}
}
