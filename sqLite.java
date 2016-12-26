package application;
import java.sql.*;

public class sqLite {
	public static Connection Connector(){
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Sumit Sharma\\workspace\\Committee Work\\src\\committeeWork.db");
			return conn;			
		}
		catch (Exception e){
			return null;
		}
	}
}
