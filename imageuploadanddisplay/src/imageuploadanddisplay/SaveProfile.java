package imageuploadanddisplay;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import imageuploadanddisplay.dto.User;
import imageuploadanddisplay.service.UserService;
import imageuploadanddisplay.util.ImageUpload;

/**
 * Servlet implementation class SaveProfile
 */
@WebServlet("/saveprofile")
@MultipartConfig
public class SaveProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fullname = request.getParameter("fullname");
		String mobile = request.getParameter("mobile");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Part imagePart = request.getPart("image");

		/* validations */

		// to store image in server - we require application path in server

		String applicationContextPath = request.getRealPath("/");

		new ImageUpload().saveImage(imagePart.getInputStream(), applicationContextPath, username);

		User user = new User(fullname, mobile, username, password);

		try {
			UserService userService = new UserService();
			userService.saveUser(user);

			response.sendRedirect("login.jsp");

		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", "Try again later...");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}

}
