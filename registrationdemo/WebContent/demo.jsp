<%@page import="java.util.Date"%>
<html>
<head>
<title>Demo jsp</title>
</head>
<body>
	<h1>Welcome to Jsp Demo</h1>

	<%
		int a = 10;
	int b = 20;

	out.print(a + b);

	Date currentDate = new Date();

	out.println(currentDate);
	%>

	<table border=1 style="border-collapse: collapse;">
		<thead>
			<tr>
				<th>Date</th>
				<th>Hours</th>
				<th>Mins</th>
				<th>Secs</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%=currentDate.getDate()%></td>
				<td>
					<%
						out.println(currentDate.getHours());
					%>
				</td>
				<td>
					<%
						out.println(currentDate.getMinutes());
					%>
				</td>
				<td>
					<%
						out.println(currentDate.getSeconds());
					%>
				</td>
			</tr>
		</tbody>
	</table>




</body>
</html>



