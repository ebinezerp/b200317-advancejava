
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/demo")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("name", "ebinezer");

		HttpSession session = request.getSession();

		session.setAttribute("age", 28);
		session.setAttribute("name", "vasu");

		request.setAttribute("std", new Student(101, "kumar", 14));

		Integer[] array = new Integer[] { 1, 5, 3, 8, 9 };

		request.setAttribute("array", array);

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
