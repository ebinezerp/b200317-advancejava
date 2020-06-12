package demoapp.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;

import java.io.PrintWriter;
import java.io.IOException;



public class DemoServlet implements Servlet{
	
	
	StringBuffer sb = new StringBuffer();
	
	public void init(ServletConfig config){
		sb.append("init ");
	}
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException,IOException{
		sb.append("service ");
		PrintWriter out= response.getWriter();
		out.println("myresponse");
		out.println(sb.toString());
	}
	
	public void destroy(){}
	
	public ServletConfig getServletConfig(){
		return null;
	}
	
	public String getServletInfo(){
		return null;
	}
}