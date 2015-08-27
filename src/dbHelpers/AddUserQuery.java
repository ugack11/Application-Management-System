/*
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddUserQuery {
	
	private Connection connection;
	
	public AddUserQuery(String dbName, String uname, String pwd){
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
	
	public void doAdd(String username, String password, String type, String fName, String lName, String sex, String birthdate, String maddress, String city, String state, int zipcode, String telephone, String email){
		String query = "INSERT INTO profile  (username, password, type, fName, lName, sex, birthdate, maddress, city, state, zipcode, telephone, email) VALUES ('"+ username +"', '"+ password + "', '" + type + "', '" + fName + "', '" + lName + "', '" + sex + "', '" + birthdate + "', '" + maddress + "', '" + city + "', '" + state +"', '"+zipcode+"', '"+telephone+"', '"+email+"')" ;
		System.out.println(query);
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}

}




