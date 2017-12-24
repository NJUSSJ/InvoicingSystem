package presentation.logui;

import java.sql.Date;

import businesslogic.userbl.UserController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import vo.LogVO;

public class LogData {
	StringProperty time;
	StringProperty type;
	StringProperty name;
	LogVO vo;
	LogData(LogVO vo){
		setVO(vo);
	}
	public void setVO(LogVO vo){
		this.vo=vo;
		time=new SimpleStringProperty(vo.getTime()+"");
		type=new SimpleStringProperty(vo.getType());
		name=new SimpleStringProperty(new UserController().findUserByID(vo.getUserID()).getUsername());
	}
	public StringProperty getTime(){
		return time;
	}
	public StringProperty getType(){
		return type;
	}
	public StringProperty getName(){
		return name;
	}
	public LogVO getVO(){
		return vo;
	}
}
