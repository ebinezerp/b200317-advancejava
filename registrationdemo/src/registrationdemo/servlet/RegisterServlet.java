package registrationdemo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.Driver;

import registrationdemo.util.DBConnection;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");

		RequestDispatcher rd = request.getRequestDispatcher("register.html");

		if (firstname.isEmpty()) {
			out.println("Enter First Name");
			rd.include(request, response);
		} else if (lastname.isEmpty()) {
			out.println("Enter lastname Name");
			rd.include(request, response);
		} else if (password.isEmpty()) {
			out.println("Enter password");
			rd.include(request, response);
		} else if (confirmPassword.isEmpty()) {
			out.println("Enter confirm password");
			rd.include(request, response);
		} else if (!password.equals(confirmPassword)) {
			out.println("Password and confirm password should be same");
			rd.include(request, response);
		} else {

			try {
				Connection con = new DBConnection().getConnection();

				PreparedStatement ps = con.prepareStatement(
						"insert into user(firstname,lastname,email,mobile,username,password) values(?,?,?,?,?,?)");

				ps.setString(1, firstname);
				ps.setString(2, lastname);
				ps.setString(3, email);
				ps.setString(4, mobile);
				ps.setString(5, username);
				ps.setString(6, password);

				int count = ps.executeUpdate();
				if (count > 0) {
					// request.getRequestDispatcher("login.html").forward(request, response);
					response.sendRedirect("login.html");

				} else {
					out.print("Error occured try again");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
