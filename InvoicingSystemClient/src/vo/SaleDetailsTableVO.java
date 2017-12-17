package vo;

import java.sql.Date;
import java.util.ArrayList;


public class SaleDetailsTableVO {
	Date begin;
	Date end;
	ArrayList<SaleBillVO> list;
	public SaleDetailsTableVO(Date begin,Date end,ArrayList<SaleBillVO> list){
		this.begin=begin;
		this.end=end;
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
	public Date getBegin(){
		return begin;
	}
	public Date getEnd(){
		return end;
	}
	public ArrayList<SaleBillVO> getList(){
		return list;
	}
}

