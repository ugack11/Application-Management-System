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


public class MembersQuery {

	private Connection connection;
	private ResultSet results;

	public MembersQuery(String dbName, String uname, String pwd){
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
		String query = "SELECT * FROM profile";

		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.results= ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doFilteredRead(String column, String operator, String value){
		String query = "select * from profile where " + column + operator + value;

		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.results= ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getHTMLTable(){
		String table ="";
		table += "<table border=1>";

		//

		table += "<tr>";
			table += "<th>";
				table += "Username";
			table += "</th>";
			table += "<th>";
				table += "Password";
			table += "</th>";
			table += "<th>";
				table += "Type";
			table += "</th>";
			table += "<th>";
				table += "First Name";
			table += "</th>";
			table += "<th>";
				table += "Last Name";
			table += "</th>";
			table += "<th>";
				table += "Sex";
			table += "</th>";
			table += "<th>";
				table += "BirthDate(MM/DD/YYYY)";
			table += "</th>";
			table += "<th>";
				table += "Mailing Address";
			table += "</th>";
			table += "<th>";
				table += "City";
			table += "</th>";
			table += "<th>";
				table += "State";
			table += "</th>";
			table += "<th>";
				table += "Zip Code";
			table += "</th>";
			table += "<th>";
				table += "Telephone(XXX-XXX-XXXX)";
			table += "</th>";
			table += "<th>";
				table += "E-mail";
			table += "</th>";
			table += "<th>";
				table += "Application";
			table += "</th>";
		table += "</tr>";

		//Add User Table Row

		table += "<form action='addUser'><tr>";
			table += "<td>";
				table += "<input class='input' type='text' name='username'>";
			table += "</td>";
			table += "<td>";
				table += "<input class='input' type='text' name='password'>";
			table += "</td>";
			table += "<td>";
				table += "<input class='input' type='text' name='type'>";
			table += "</td>";
			table += "<td>";
				table += "<input class='input' type='text' name='fName'>";
			table += "</td>";
			table += "<td>";
				table += "<input class='input' type='text' name='lName'>";
			table += "</td>";
			table += "<td>";
				table += "<input class='input' type='text' name='sex'>";
			table += "</td>";
			table += "<td>";
				table += "<input class='input' type='text' name='birthdate'>";
			table += "</td>";
			table += "<td>";
				table += "<input class='input' type='text' name='maddress'>";
			table += "</td>";
			table += "<td>";
				table += "<input class='input' type='text' name='city'>";
			table += "</td>";
			table += "<td>";
				table += "<input class='input' type='text' name='state'>";
			table += "</td>";
			table += "<td>";
				table += "<input class='input' type='text' name='zipcode'>";
			table += "</td>";
			table += "<td>";
				table += "<input class='input' type='text' name='telephone'>";
			table += "</td>";
			table += "<td>";
				table += "<input class='input' type='text' name='email'>";
			table += "</td><td></td>";
			table += "<td>";
				table += "<input class='input' type='submit' value='Add Profile'>";
			table += "</td>";
		table += "</tr></form>";
		Profile profile;


		try {
			while(this.results.next()){

				profile = new Profile();
				profile.setUsername(this.results.getString("username"));
				profile.setPassword(this.results.getString("password"));
				profile.setType(this.results.getString("type"));
				profile.setFirstName(this.results.getString("fName"));;
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


				table +="<tr>";
					table +="<td>";
						table += profile.getUsername();
					table +="</td>";
					table +="<td>";
						table += profile.getPassword();
					table +="</td>";
					table +="<td>";
						table += profile.getType();
					table += "</td>";
					table +="<td>";
						table += profile.getFirstName();
					table +="</td>";
					table +="<td>";
						table += profile.getLastName();
					table +="</td>";
					table +="<td>";
						table += profile.getSex();
					table += "</td>";
					table +="<td>";
						table += profile.getBirthDate();
					table += "</td>";
					table +="<td>";
						table += profile.getMAddress();
					table += "</td>";
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
						table += profile.getApplication();
					table += "</td>";
					table += "<td>";
						table += "<a href=updateMember?username=" + profile.getUsername() + "><button class='input'>update</button></a>";
						table += "<a href=delete?username=" + profile.getUsername() + "><button class='input'>delete</button></a>";
					table +="</td>";
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