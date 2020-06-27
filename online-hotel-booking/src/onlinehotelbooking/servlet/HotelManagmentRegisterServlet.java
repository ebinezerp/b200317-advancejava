package onlinehotelbooking.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onlinehotelbooking.dto.HotelManagement;
import onlinehotelbooking.util.DBConnection;
import onlinehotelbooking.util.HotelManagmentDataValidation;

/**
 * Servlet implementation class HotelManagmentRegisterServlet
 */
@WebServlet("/hotelmangreg")
public class HotelManagmentRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		HotelManagement hotelManagement = new HotelManagement();
		hotelManagement.setFullname(fullname);
		hotelManagement.setEmail(email);
		hotelManagement.setMobile(mobile);
		hotelManagement.setUsername(username);
		hotelManagement.setPassword(password);

		/*
		 * boolean fieldsEmpty = false;
		 * 
		 * if (fullname.isEmpty()) { fieldsEmpty = true;
		 * request.setAttribute("fullnameError", "Enter Fullname"); }
		 * 
		 * if (email.isEmpty()) { fieldsEmpty = true; request.setAttribute("emailError",
		 * "Enter Email"); }
		 * 
		 * if (mobile.isEmpty()) { fieldsEmpty = true;
		 * request.setAttribute("mobileError", "Enter mobile number"); }
		 * 
		 * if (username.isEmpty()) { fieldsEmpty = true;
		 * request.setAttribute("usernameError", "Enter username"); }
		 * 
		 * if (password.isEmpty()) { fieldsEmpty = true;
		 * request.setAttribute("passwordError", "Enter password"); }
		 */

		Map<String, String> errorMessages = new HotelManagmentDataValidation().validate(hotelManagement);

		if (!errorMessages.isEmpty()) {
			request.setAttribute("errorMessages", errorMessages);
			request.getRequestDispatcher("hotelmanagmentreg.jsp").forward(request, response);
		} else {

			try {
				Connection con = new DBConnection().getConnection();
				PreparedStatement ps = con.prepareStatement(
						"insert into hotelmang(fullname,email,mobile,username,password) values(?,?,?,?,?)");

				ps.setString(1, fullname);
				ps.setString(2, email);
				ps.setString(3, mobile);
				ps.setString(4, username);
				ps.setString(5, password);

				int count = ps.executeUpdate();

				if (count > 0) {
					response.sendRedirect("hotelmanglogin.jsp");
				} else {
					request.setAttribute("errorMsg", "Some Internal Error occured. Try again");
					request.getRequestDispatcher("hotelmanagmentreg.jsp").forward(request, response);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

}
