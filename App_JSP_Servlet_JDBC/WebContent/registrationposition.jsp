<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Staff</title>
</head>
<body>

<h2>>Registration Staff</h2>

<a href="index.jsp">Home</a> &nbsp;|&nbsp;
	
<a href="positioncontrol">Registration Position </a> &nbsp;|&nbsp;
	
<a href="newstaff">Registration Staff </a> &nbsp;|&nbsp;	
	
<a href="staffcontrolcons">Consult</a> &nbsp;|&nbsp;

<hr /> <br />
${message}
<hr /> <br />

<form method="post" action="positioncontrol">
	<fieldset style="width: 35%"> 
	
		<legend> Inform Position data</legend>
		
		Title:<br />
		<input type="text" name="title">
		<br/>
		
		Salary:<br />
		<input type="text" name="salary">
		
		<br/>		
		
		<input type="submit" value="Save"/>
		
	</fieldset>
</form>

</body>
</html>