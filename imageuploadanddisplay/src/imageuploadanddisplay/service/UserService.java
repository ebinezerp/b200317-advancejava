package imageuploadanddisplay.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import imageuploadanddisplay.dto.User;
import imageuploadanddisplay.util.DBConnection;

public class UserService {

	private Connection con;

	public UserService() throws SQLException {
		con = new DBConnection().getConnection();
	}

	public void saveUser(User user) {

		try {
			PreparedStatement ps = con
					.prepareStatement("insert into users(fullname,mobile,username,password) values(?,?,?,?)");
			ps.setString(1, user.getFullname());
			ps.setString(2, user.getMobile());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public User getUser(String username, String password) {
		try {
			PreparedStatement ps = con.prepareStatement("select * from users where username = ? and password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				User user = new User();

				user.setFullname(rs.getString("fullname"));
				user.setMobile(rs.getString("mobile"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));

				return user;

			} else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
