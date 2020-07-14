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
import onlinehotelbooking.services.HotelMangmentService;
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

		Map<String, String> errorMessages = new HotelManagmentDataValidation().validate(hotelManagement);

		if (!errorMessages.isEmpty()) {
			request.setAttribute("errorMessages", errorMessages);
			request.getRequestDispatcher("hotelmanagmentreg.jsp").forward(request, response);
		} else {
			/* try { */
				HotelMangmentService hotelMangmentService = new HotelMangmentService();

				boolean result = hotelMangmentService.save(hotelManagement);

				if (result) {
					response.sendRedirect("login.jsp");
				} else {
					request.setAttribute("errorMsg", "Registration is failed. Try again");
					request.getRequestDispatcher("hotelmanagmentreg.jsp").forward(request, response);
				}

			/*} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("errorMsg", "Database Connection is not established. Try again..");
				request.getRequestDispatcher("hotelmanagmentreg.jsp").forward(request, response);
			}*/
		}
	}

}
