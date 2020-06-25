<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>


	<%
		int a = 10;
	%>

	<c:set var="a" value="11"></c:set>

	<c:out value="${a}"></c:out>

	<c:if test=""></c:if>


	${a} ${10*20}



	<a href="demo">Demo Servlet</a>


	<%
		if (request.getAttribute("name") != null) {
		out.println(request.getAttribute("name"));
	}
	%>

	${name} ${age}


	<%-- <%
	    if(request.getAttribute("std")!=null){
	    	Object o= request.getAttribute("std");
	    	out.println((Student)o);
	    }
	%>
	 --%>


	${std} ${std.name} ${array[3]}



	<%
		if (request.getAttribute("array") != null) {
		Object ob = request.getAttribute("array");

		Integer[] array = (Integer[]) ob;

		out.println(array);

		for (int i = 0; i < array.length; i++) {
			out.println(array[i]);
		}

	}
	%>



	<c:if test="${a%2==0}">
		<h1>even</h1>
	</c:if>

	<c:choose>
		<c:when test="${a>10}">

			<h1>Greater</h1>

		</c:when>
		<c:when test="${a<10}">

			<h1>Lesser</h1>
		</c:when>
		<c:otherwise>
			<h1>Equal</h1>
		</c:otherwise>
	</c:choose>

<%-- 
	<%
		for (datattype var : collectionvar) {

	}
	%> --%>


	<c:forEach var="num" items="${array}">
	
	${num}
	
	</c:forEach>


</body>
</html>