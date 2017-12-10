package presentation.memberui;

import javafx.beans.property.StringProperty;
import vo.MemberVO;

public class MemberData {
	StringProperty name;
	StringProperty id;
	StringProperty telephone;
	StringProperty address;
	StringProperty postcode;
	StringProperty email;
	StringProperty category;
	StringProperty rank;
	StringProperty shouldpay;
	StringProperty shouldget;
	StringProperty quota;//”¶ ’∂Ó∂»
	StringProperty operator;
	MemberVO a;
	public MemberData(MemberVO a){
		this.a=a;
		name.set(a.getName());
		id.set(Long.toString(a.getID()));
		telephone.set(Long.toString(a.getPhoneNum()));
		address.set(a.getAddress());
		postcode.set(Long.toString(a.getPostCode()));
		email.set(a.getEmail());
		category.set(Integer.toString(a.getCategory()));
		rank.set(Integer.toString(a.getRank()));
		shouldpay.set(Double.toString(a.getShouldPay()));
		shouldget.set(Double.toString(a.getShouldGet()));
		quota.set(Double.toString(a.getQuota()));
		operator.set(Long.toString(a.getDefaultOperatorID()));
	}

	public MemberVO getVO() {
		// TODO Auto-generated method stub
		return a;
	}

	public StringProperty getNameProperty() {
		// TODO Auto-generated method stub
		return name;
	}

	public StringProperty getCategoryProperty() {
		// TODO Auto-generated method stub
		return category;
	}

	public StringProperty getidProperty() {
		// TODO Auto-generated method stub
		return id;
	}

	public StringProperty getRankProperty() {
		// TODO Auto-generated method stub
		return rank;
	}

	public StringProperty getAddressProperty() {
		// TODO Auto-generated method stub
		return address;
	}

	public StringProperty getPostCodeProperty() {
		// TODO Auto-generated method stub
		return postcode;
	}

	public StringProperty getEmailProperty() {
		// TODO Auto-generated method stub
		return email;
	}

	public StringProperty getQuotaProperty() {
		// TODO Auto-generated method stub
		return quota;
	}

	public StringProperty getOperatorProperty() {
		// TODO Auto-generated method stub
		return operator;
	}

	public StringProperty getpayProperty() {
		// TODO Auto-generated method stub
		return shouldpay;
	}

	public StringProperty getgetProperty() {
		// TODO Auto-generated method stub
		return shouldget;
	}

	public StringProperty getTelephoneProperty() {
		// TODO Auto-generated method stub
		return telephone;
	}

}
