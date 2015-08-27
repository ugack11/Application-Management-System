/*
 *
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateFormQuery {

	private Connection connection;

	public UpdateFormQuery(String dbName, String uname, String pwd){

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

	public boolean doUpdate(/*String oldUsername,*/ String username, String password, String type, String fName, String lName, String sex, String birthdate, String maddress, String city, String state, int zipcode, String telephone, String email){
		String query = "UPDATE profile SET username='" + username + "', password='" + password + "',type='"+type+"', fName='" + fName + "', lName='" + lName + "', sex='" + sex + "', birthdate='" + birthdate + "', maddress='" + maddress + "', city='" + city + "', state='" + state+"', zipcode='" +zipcode+"', telephone='"+telephone+"', email='"+email+ "'  WHERE username='" + username + "'";
		//System.out.println("OldUSername: " + oldUsername);
		System.out.println(query);
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


}