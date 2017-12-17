package vo;

import java.util.ArrayList;


public class SaleDetailsTableVO {
	ArrayList<SaleBillVO> list;
	public SaleDetailsTableVO(ArrayList<SaleBillVO> list){
		this.list=list;
		//∞¥ ±º‰À≥–Ú≈≈–Ú
		for(int i=0;i<list.size()-1;i++){
			for(int j=i+1;j<list.size();j++){
				if(list.get(i).getTime().after(list.get(j).getTime())){
					SaleBillVO temp=list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
	}
}

