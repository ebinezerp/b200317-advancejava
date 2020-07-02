package imageuploadanddisplay;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import imageuploadanddisplay.dto.User;
import imageuploadanddisplay.service.UserService;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		/* validations */

		try {
			UserService userService = new UserService();

			User user = userService.getUser(username, password);

			if (user != null) {
				HttpSession session = request.getSession();

				session.setAttribute("user", user);

				response.sendRedirect("display.jsp");
			} else {
				request.setAttribute("errrorMsg", "Invalid Credentials");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errrorMsg", "Internal Error Occured. Try after some time");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
