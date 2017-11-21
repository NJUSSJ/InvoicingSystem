package data.datafactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataFactory {
	//JDBC 驱动名及数据库URL
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost:3306/bulbmanagementdatabase";
	
	static final String USER="root";
	static final String PASSWORD="19980219";
	
	public static Connection conn;
	public static java.sql.Statement statement;
	
	public DataFactory() {
		// TODO Auto-generated constructor stub
		try {
			//注册JDBC驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//打开链接
			System.out.println("连接数据库...");
			conn=DriverManager.getConnection(DB_URL, USER, PASSWORD);
			statement=conn.createStatement();
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
