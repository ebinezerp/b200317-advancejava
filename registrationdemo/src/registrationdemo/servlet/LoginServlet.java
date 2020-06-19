package registrationdemo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

import registrationdemo.util.DBConnection;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			Connection con = new DBConnection().getConnection();

			PreparedStatement ps = con.prepareStatement("select * from user where username=? and password = ?");

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				// request.setAttribute("resultSet", rs);

				HttpSession session = request.getSession();
				session.setAttribute("resultSet", rs);

				// request.getRequestDispatcher("display.jsp").forward(request, response);
				response.sendRedirect("display.jsp");

			} else {
				out.println("Invalid Credentails");
				request.getRequestDispatcher("login.html").include(request, response);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
