package presentation.memberui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import vo.MemberVO;

public class MemberData {
	StringProperty name=new SimpleStringProperty();
	StringProperty id=new SimpleStringProperty();
	StringProperty telephone=new SimpleStringProperty();
	StringProperty address=new SimpleStringProperty();
	StringProperty postcode=new SimpleStringProperty();
	StringProperty email=new SimpleStringProperty();
	StringProperty category=new SimpleStringProperty();
	StringProperty rank=new SimpleStringProperty();
	StringProperty shouldpay=new SimpleStringProperty();
	StringProperty shouldget=new SimpleStringProperty();
	StringProperty quota=new SimpleStringProperty();//”¶ ’∂Ó∂»
	StringProperty operator=new SimpleStringProperty();
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
		return a;
	}

	public StringProperty getNameProperty() {
		return name;
	}

	public StringProperty getCategoryProperty() {
		return category;
	}

	public StringProperty getidProperty() {
		return id;
	}

	public StringProperty getRankProperty() {
		return rank;
	}

	public StringProperty getAddressProperty() {
		return address;
	}

	public StringProperty getPostCodeProperty() {
		return postcode;
	}

	public StringProperty getEmailProperty() {
		return email;
	}

	public StringProperty getQuotaProperty() {
		return quota;
	}

	public StringProperty getOperatorProperty() {
		return operator;
	}

	public StringProperty getpayProperty() {
		return shouldpay;
	}

	public StringProperty getgetProperty() {
		return shouldget;
	}

	public StringProperty getTelephoneProperty() {
		return telephone;
	}
	public void setMemberVO(MemberVO vo){
		this.a=vo;
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

}
