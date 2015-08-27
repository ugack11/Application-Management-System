/**
 *
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Profile;

public class ReadRecord {

	private Connection connection;
	private ResultSet results;

	private Profile profile = new Profile();
	private String username;

	public ReadRecord(String dbName, String uname, String pwd, String username){

		String url = "jdbc:mysql://localhost:3306/" + dbName;
		this.username = username;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);

		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void doRead(){
		String query = "select * from profile where username='" + this.username + "'";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			this.results = ps.executeQuery();
			this.results.next();

			profile.setUsername(this.results.getString("username"));
			profile.setPassword(this.results.getString("password"));
			profile.setType(this.results.getString("type"));
			profile.setFirstName(this.results.getString("fName"));
			profile.setLastName(this.results.getString("lName"));
			profile.setSex(this.results.getString("sex"));
			profile.setBirthDate(this.results.getString("birthdate"));
			profile.setMAddress(this.results.getString("maddress"));
			profile.setCity(this.results.getString("city"));
			profile.setState(this.results.getString("state"));
			profile.setZipCode(this.results.getInt("zipcode"));
			profile.setTelephone(this.results.getString("telephone"));
			profile.setEmail(this.results.getString("email"));
			profile.setApplication(this.results.getString("application"));


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Profile getProfile(){
		return this.profile;
	}



}

