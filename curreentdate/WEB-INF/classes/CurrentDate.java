package currentdate.servlet;



import javax.servlet.*;

import java.io.*;

import java.util.Date;


public class CurrentDate implements Servlet{
	
	public void init(ServletConfig config){
		
	}
	
	public void service(ServletRequest r, ServletResponse rp) throws ServletException, IOException{
		
		Date currentDate = new Date();
		
		PrintWriter out = rp.getWriter();
		
		out.println(currentDate);
		
	}
	
	public void destroy(){}
	
	public ServletConfig getServletConfig(){
		return null;
	}
	
	public String getServletInfo(){
		return null;
	}
	
}