package businesslogic.billbl;

import java.util.ArrayList;

public class AccountList {
	ArrayList<AccountLineItem> list;
	public AccountList(){
		list=new ArrayList<AccountLineItem>();
	}
	public void addAccount(AccountLineItem a){
		list.add(a);
	}
	public String toString(){
		String temp="";
		for(int i=0;i<list.size();i++){
			temp+=list.get(i).getAccountID()+","+list.get(i).getMoney();
			if(list.get(i).getRemark()!=null){
				temp+=list.get(i).getRemark();
			}
			
			if(i!=list.size()-1){
				temp+=" ";
			}
		}
		return temp;
	}
	public double getSum(){
		double temp=0;
		for(int i=0;i<list.size();i++){
			temp+=list.get(i).getMoney();
		}
		return temp;
	}
}
