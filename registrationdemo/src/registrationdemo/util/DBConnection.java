package registrationdemo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DBConnection {

	public Connection getConnection() throws SQLException {
		DriverManager.registerDriver(new Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registerdemo", "root", "root");
		return con;
	}

}
