package application;

import java.sql.*;
public class CStopModel {
	Connection connection;
	public CStopModel(){
		connection = sqLite.Connector();
		if(connection == null) System.exit(1);
		
	}
	public boolean isDbConnected(){
		try {
			return !connection.isClosed();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean isLogin(String userName, String passWord) throws SQLException{
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "Select * from loginUser where Username = ? and Password = ?";
		try{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, passWord);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return true;
			}
			else{
				return false;
			}
		}
			catch(Exception e){
				return false;
			}
			finally{
				preparedStatement.close();
				resultSet.close();
				
			}
			
	}
}
