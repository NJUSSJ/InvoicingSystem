package presentation.promotionui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import vo.PackagePromotionVO;

public class PackagePromotionData {
	StringProperty discountPro;
	StringProperty commodityPro;
	PackagePromotionVO promotion;
	public PackagePromotionData(PackagePromotionVO promotion){
		this.promotion=promotion;
		discountPro=new SimpleStringProperty(promotion.getDiscount()+"");
		commodityPro=new SimpleStringProperty(promotion.getList().getNameInfo());
	}
	public StringProperty getDiscountProperty() {
		return discountPro;
	}
	public StringProperty getCommodityProperty() {
		return commodityPro;
	}
	public PackagePromotionVO getVO(){
		return promotion;
	}
}
