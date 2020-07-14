package onlinehotelbooking.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import onlinehotelbooking.dto.HotelManagement;
import onlinehotelbooking.services.HotelMangmentService;

@WebServlet("/hotellogin")
public class HotelMangmentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			HotelMangmentService hotelMangmentService = new HotelMangmentService();
			HotelManagement hotelManagement = hotelMangmentService.login(username, password);

			if (hotelManagement != null) {

				HttpSession session = request.getSession();
				session.setAttribute("hotelManagment", hotelManagement);
				response.sendRedirect("hotelmanghome.jsp");

			} else {
				request.setAttribute("errorMsg", "Invalid Credentials");
				request.getRequestDispatcher("hotelmanglogin.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", "Database Connection is not established. Try again..");
			request.getRequestDispatcher("hotelmanglogin.jsp").forward(request, response);
		}

	}
}
