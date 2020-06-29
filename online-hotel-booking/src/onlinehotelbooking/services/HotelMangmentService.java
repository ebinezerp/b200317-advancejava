package onlinehotelbooking.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import onlinehotelbooking.dto.HotelManagement;
import onlinehotelbooking.util.DBConnection;

public class HotelMangmentService {

	private Connection con;

	public HotelMangmentService() throws SQLException {
		con = new DBConnection().getConnection();
	}

	// to store data in DB
	public boolean save(HotelManagement hotelManagement) {

		try {
			PreparedStatement ps = con.prepareStatement(
					"insert into hotelmang(fullname,email,mobile,username,password) values(?,?,?,?,?)");

			ps.setString(1, hotelManagement.getFullname());
			ps.setString(2, hotelManagement.getEmail());
			ps.setString(3, hotelManagement.getMobile());
			ps.setString(4, hotelManagement.getUsername());
			ps.setString(5, hotelManagement.getPassword());

			int count = ps.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public HotelManagement login(String username, String password) {

		try {
			PreparedStatement ps = con.prepareStatement("select * from hotelmang where username=? and password = ?");
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				HotelManagement hotelManagement = new HotelManagement();
				hotelManagement.setId(rs.getInt("id"));
				hotelManagement.setFullname(rs.getString("fullname"));
				hotelManagement.setEmail(rs.getString("email"));
				hotelManagement.setMobile(rs.getString("mobile"));
				hotelManagement.setUsername(rs.getString("usernanme"));
				hotelManagement.setPassword(rs.getString("password"));

				return hotelManagement;

			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}
