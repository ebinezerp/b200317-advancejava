package registrationdemo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/profile")
public class DisplayProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			ResultSet rs = (ResultSet) request.getAttribute("resultSet");

			PrintWriter out = response.getWriter();

			/*
			 * out.println(rs.getString("firstname") + " " + rs.getString("lastname") + " "
			 * + rs.getString("email")); out.println(rs.getString("mobile") + " " +
			 * rs.getString("username"));
			 */

			out.print("<html>");
			out.print("<head>");
			out.print("<title>Profile Page</title>");
			out.print("</head>");
			out.print("<body>");
			out.print("<table border='1'>");
			out.print("<tr>");
			out.print("<td><label>First Name</label></td><td>" + rs.getString("firstname") + "</td>");
			out.print("</tr>");
			out.print("</table>");
			out.print("</body>");
			out.print("</html>");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
