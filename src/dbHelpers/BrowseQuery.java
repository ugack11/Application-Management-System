/**
 *
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;


public class BrowseQuery {

	private Connection connection;
	private ResultSet results;

	public BrowseQuery(String dbName, String uname, String pwd){
		String url = "jdbc:mysql://localhost:3306/" + dbName;

		// set up the driver
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doRead() {
		String query = "select * from profile";
		System.out.println(query);
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.results= ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doFilteredRead(String column, String value){
		String query = "select * from profile where " + column + "='" + value + "'";
		System.out.println(query);

		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.results = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getHTMLTable(){
		String table ="";
		table += "<table border=1><tr><td>First Name</td><td>Last Name</td><td>Type</td><td>Sex(M/F)</td><td>Birth Date(MM/DD/YYYY)</td><td>Mailing Address</td><td>City</td><td>State</td><td>Zip Code</td><td>Telephone(XXX-XXX-XXXX)</td><td>E-mail</td><td>Application</td></tr>";

		try {
			while(this.results.next()){
				Profile profile = new Profile();
				profile.setFirstName(this.results.getString("fName"));
				profile.setLastName(this.results.getString("lName"));
				profile.setType(this.results.getString("type"));
				profile.setSex(this.results.getString("sex"));
				profile.setBirthDate(this.results.getString("birthdate"));
				profile.setMAddress(this.results.getString("maddress"));
				profile.setCity(this.results.getString("city"));
				profile.setState(this.results.getString("state"));
				profile.setZipCode(this.results.getInt("zipcode"));
				profile.setTelephone(this.results.getString("telephone"));
				profile.setEmail(this.results.getString("email"));
				profile.setApplication(this.results.getString("application"));

				table +="<tr>";
					table +="<td>";
						table += profile.getFirstName();
					table +="</td>";
					table +="<td>";
						table += profile.getLastName();
					table +="</td>";
					table +="<td>";
						table += profile.getType();
					table +="</td>";
					table +="<td>";
						table += profile.getSex();
					table +="</td>";
					table +="<td>";
						table += profile.getBirthDate();
					table +="</td>";
					table +="<td>";
						table += profile.getMAddress();
					table +="</td>";
					table +="<td>";
						table += profile.getCity();
					table += "</td>";
					table +="<td>";
						table += profile.getState();
					table += "</td>";
					table +="<td>";
						table += profile.getZipCode();
					table += "</td>";
					table +="<td>";
						table += profile.getTelephone();
					table += "</td>";
					table +="<td>";
						table += profile.getEmail();
					table += "</td>";
					table +="<td>";
						table += "<a href='/Gym_Sign_Up/applications/" + profile.getApplication() + "' target='_'><button class='input'>View</button></a>";
					table += "</td>";
				table +="</tr>";

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		table += "</table>";
		return table;
	}




}