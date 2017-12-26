package businesslogic.billbl;

import java.util.ArrayList;

public class AccountList {
	ArrayList<AccountLineItem> list=new ArrayList<>();
	public AccountList(){
		list=new ArrayList<AccountLineItem>();
	}
	public AccountList(String info){
		String[] items=info.split(" ");
		for(int i=0;i<items.length;i++){
			String[] temp=items[i].split(",");
			Long id=Long.parseLong(temp[0]);
			double money=Double.parseDouble(temp[1]);
			String remark="";
			if(temp.length>2){
				remark=temp[2];
			}
			list.add(new AccountLineItem(id,money,remark));
		}
	}
	public void addAccount(AccountLineItem a){
		list.add(a);
	}
	public void removeAccount(AccountLineItem a){
		list.remove(a);//
	}
	public String toString(){
		String temp="";
		for(int i=0;i<list.size();i++){
			temp+=list.get(i).getAccountID()+","+list.get(i).getMoney()+","+list.get(i).getRemark();
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
	public int getListLength() {
		return list.size();
	}
	public AccountLineItem getItem(int i) {
		return list.get(i);
	}
}
