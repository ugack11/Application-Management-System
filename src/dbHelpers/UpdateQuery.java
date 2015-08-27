/*
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Profile;

public class UpdateQuery {
	
	private Connection connection;
	
	public UpdateQuery(String dbName, String uname, String pwd){
		
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean doUpdate(Profile profile){
		String query = "update profile set fName=?, lName=?, sex=?, birthdate=?, maddress=?, city=?, state=?, zipcode=?, telephone=?, email=? where username=?";
		System.out.println(query);
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, profile.getFirstName());
			ps.setString(2, profile.getLastName());
			ps.setString(3, profile.getSex());
			ps.setString(4, profile.getBirthDate());
			ps.setString(5, profile.getMAddress());
			ps.setString(6, profile.getCity());
			ps.setString(7, profile.getState());
			ps.setInt(8, profile.getZipCode());
			ps.setString(9, profile.getTelephone());
			ps.setString(10, profile.getEmail());
			ps.setString(11, profile.getUsername());
		
			
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	

}