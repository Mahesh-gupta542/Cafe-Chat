package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.HashMap;

public class DemoDao {
	Connection connection =null;
	PreparedStatement statement = null;
	ResultSet resultset = null;
	String queryString=null;
	
	public boolean saveUserDetail(HashMap<String, String> user, FileInputStream pic, int file_size) throws Exception{
		try{
		connection=Dbconnector.makeConnection();		
		queryString = "insert into cafe_chat.cafe_chat_user_details(first_name, last_name, user_email, password, date_of_birth, profile_pic,pic_file_name) values (?, ?,?,?,to_date(?,'dd-mm-yyyy'),?,?)";
		statement = connection.prepareStatement(queryString);
		statement.setString(1, user.get("fname"));
		statement.setString(2, user.get("lname"));
		statement.setString(3, user.get("email"));
		statement.setString(4, user.get("password"));
		statement.setString(5, user.get("dob"));
		statement.setString(7, user.get("file"));
		if (pic != null) {
			statement.setBinaryStream(6, pic, file_size);
		}
		int row = statement.executeUpdate();
		System.out.println("insert rows: "+ row);
		Dbconnector.close(connection);
		} catch (Exception e){
			e.printStackTrace();
			Dbconnector.close(connection);
			return false;
		}
		return true;
	}
	
	public HashMap<String,String> userLogin(String username) throws Exception{
		HashMap<String,String> userDetails = new HashMap<>();
		String db_password="####";
		String db_user_fname="";
		try{
		connection=Dbconnector.makeConnection();
		queryString="Select first_name, password from cafe_chat.cafe_chat_user_details where user_email= ?";
		statement=connection.prepareStatement(queryString);
		statement.setString(1, username);
		resultset=statement.executeQuery();
		while (resultset.next()){
			db_password=resultset.getString(2);
			db_user_fname=resultset.getString(1);			
		}
		resultset.close();
		if(db_password=="####"){
			userDetails.put("UserExist", "0");
		}else{
			userDetails.put("UserExist", "1");
			userDetails.put("UserPassword", db_password);
			userDetails.put("UserFname", db_user_fname); 
		}
		Dbconnector.close(connection);
		}catch(Exception e){
			e.printStackTrace();
			Dbconnector.close(connection);
		}
		System.out.println(userDetails.toString());
		return userDetails;
	}

}
