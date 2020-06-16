package birthdatedemo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Validate
 */
@WebServlet("/validate")
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Date currentDate = new Date();
			String dob = request.getParameter("dob");
			String date = dob.split("T")[0];

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date dateOfBirth = sdf.parse(date);

			PrintWriter out = response.getWriter();

			response.setContentType("text/html");

			out.print(dateOfBirth);

			if (dateOfBirth.before(currentDate)) {
				request.setAttribute("dateofbirth", dateOfBirth);
				request.getRequestDispatcher("age").include(request, response);
				request.getRequestDispatcher("demo.html").include(request, response);
				;
			} else {
				out.print("Invalid Date of birth");
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
