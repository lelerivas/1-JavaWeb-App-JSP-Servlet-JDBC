<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Initial</title>
</head>
<body>

	<h2>Aplication in JSP and Servlet with JDBC.</h2>
	
	<a href="registrationstaff.jsp"> Registration Staff</a>
	
	&nbsp;&nbsp;|&nbsp;&nbsp;
	<hr/><br/>
	
	<% String msg = (String) request.getAttribute("message");
		if(msg != null){
			out.print(msg);
		}
	%>

</body>
</html>