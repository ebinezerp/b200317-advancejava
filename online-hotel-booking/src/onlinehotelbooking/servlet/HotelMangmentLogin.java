package onlinehotelbooking.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import onlinehotelbooking.dto.HotelManagement;
import onlinehotelbooking.util.DBConnection;

@WebServlet("/hotellogin")
public class HotelMangmentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			Connection con = new DBConnection().getConnection();
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
				hotelManagement.setUsername(rs.getString("username"));
				hotelManagement.setPassword(rs.getString("password"));

				HttpSession session = request.getSession();

				session.setAttribute("hotelManagment", hotelManagement);

				response.sendRedirect("hotelmanghome.jsp");
			} else {
				request.setAttribute("errorMsg", "Invalid Credentials");
				request.getRequestDispatcher("hotelmanglogin.jsp").forward(request, response);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
