package onlinehotelbooking.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onlinehotelbooking.util.DBConnection;

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

		boolean fieldsEmpty = false;

		if (fullname.isEmpty()) {
			fieldsEmpty = true;
			request.setAttribute("fullnameError", "Enter Fullname");
		}

		if (email.isEmpty()) {
			fieldsEmpty = true;
			request.setAttribute("emailError", "Enter Email");
		}

		if (mobile.isEmpty()) {
			fieldsEmpty = true;
			request.setAttribute("mobileError", "Enter mobile number");
		}

		if (username.isEmpty()) {
			fieldsEmpty = true;
			request.setAttribute("usernameError", "Enter username");
		}

		if (password.isEmpty()) {
			fieldsEmpty = true;
			request.setAttribute("passwordError", "Enter password");
		}

		if (fieldsEmpty) {
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
