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
	MemberVO memberVO;
	public MemberData(MemberVO vo){
		setMemberVO(vo);
	}

	public MemberVO getVO() {
		return memberVO;
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
		memberVO=vo;
		name.set(memberVO.getName());
		id.set(Long.toString(memberVO.getID()));
		telephone.set(Long.toString(memberVO.getPhoneNum()));
		address.set(memberVO.getAddress());
		postcode.set(Long.toString(memberVO.getPostCode()));
		email.set(memberVO.getEmail());
		category.set(Integer.toString(memberVO.getCategory()));
		rank.set(Integer.toString(memberVO.getRank()));
		shouldpay.set(Double.toString(memberVO.getShouldPay()));
		shouldget.set(Double.toString(memberVO.getShouldGet()));
		quota.set(Double.toString(memberVO.getQuota()));
		operator.set(Long.toString(memberVO.getDefaultOperatorID()));
	}

}
