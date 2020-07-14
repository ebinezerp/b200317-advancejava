package cookies.demo.filters;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LogFilter implements Filter {

	private BufferedWriter bufferedWriter;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(filterConfig.getInitParameter("logfile")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String ipAddress = request.getRemoteAddr();
		Date currentDate = new Date();

		bufferedWriter.write(ipAddress);
		bufferedWriter.write('\t');
		bufferedWriter.write(currentDate.toString());
		bufferedWriter.newLine();
		bufferedWriter.flush();

		//forwarding the request to servlet
		chain.doFilter(request, response);

	}

}
