package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class loginController implements Initializable{
public CStopModel csModel = new CStopModel();
	
	@FXML
	private Label isConnected;
	
	@FXML
	private TextField userName;
	
	@FXML
	private TextField passWord;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		if(csModel.isDbConnected()){
			isConnected.setText("Connected");
		}
		else{
			isConnected.setText("Not Connected");
		}
	}
	
	public void submit(ActionEvent event){
		try {
			if(csModel.isLogin(userName.getText(), passWord.getText())){
				isConnected.setText("Data already exists");
			}
			else{
				isConnected.setText("Data not inserted");
			}
		} 
		catch (SQLException e) {
			isConnected.setText("Data not inserted");
			e.printStackTrace();
			
		}
	}
}