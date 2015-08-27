package dbHelpers;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UploadQuery {
	
	private Connection connection;
	private String username;
	
	public UploadQuery(String dbName, String uname, String pwd, String username){
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
	
	public boolean doUpload(String path) throws FileNotFoundException{
		//String query = "UPDATE connect c inner join profile p on c.profileID = p.profileID inner join application app on c.appID = app.appID SET application='" + path + "' WHERE username='" + this.username + "'";
		String query = "UPDATE profile SET application='" + path + "' WHERE username='" + this.username + "'";
		System.out.println(query);
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.executeUpdate();
			System.out.println("Upload Executed");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
