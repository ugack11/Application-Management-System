/*
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Profile;

public class AddQuery {
	
	public Connection connection;
	
	public AddQuery(String dbName, String uname, String pwd){
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
	
	public void doAdd(Profile profile){
		String query = "insert into profile (username, password, fName, lName, type, sex, birthdate, maddress, city, state, zipcode, telephone, email) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, profile.getUsername());
			ps.setString(2, profile.getPassword());
			ps.setString(3, profile.getFirstName());
			ps.setString(4, profile.getLastName());
			ps.setString(5, profile.getType());
			ps.setString(6, profile.getSex());
			ps.setString(7, profile.getBirthDate());
			ps.setString(8, profile.getMAddress());
			ps.setString(9, profile.getCity());
			ps.setString(10, profile.getState());
			ps.setInt(11, profile.getZipCode());
			ps.setString(12, profile.getTelephone());
			ps.setString(13, profile.getEmail());
			
			
			
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

