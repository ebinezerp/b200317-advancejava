package scopedemo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebServlet("/demo")*/

@WebServlet(urlPatterns = { "/demo" }, initParams = { @WebInitParam(name = "name", value = "ebinezer"),
		@WebInitParam(name = "age", value = "27") })
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletConfig config = getServletConfig();
		String name = config.getInitParameter("name");

		ServletContext context = request.getServletContext();

		String name2 = context.getInitParameter("name");

		PrintWriter out = response.getWriter();
		out.println(name);
		out.println(name2);

	}

}
