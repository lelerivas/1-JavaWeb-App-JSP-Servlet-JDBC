<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Staff</title>
</head>
<body>
	<h2> Registration Staff </h2>
	<a href="index.jsp"> Initial </a>
	&nbsp;&nbsp;|&nbsp;&nbsp;
	<a href="registrationstaff.jsp"> Registration Staff </a>
	&nbsp;&nbsp;|&nbsp;&nbsp;
	<a href="staffcontrol"> Consult </a>
	<hr/><br/>
	
	<form method="post" action="Staffcontrol">
		<fieldset style="width: 35%">
			<legend> Entry with Staff data</legend>
			
			 Name: <br/>
			 <input type="text" name="name"/> <br/>
			
			 Registration Cod: <br/>
			 <input type="text" name="regcod"/> <br/>
			
			 Gender: <br/>
			 <input type="radio" name="gender" checked="checked" value="female"/> Female <br/>
			 <input type="radio" name="gender" checked="checked" value="male"/> Male <br/>
			 
			 Marital Status: <br/>
			<select name="maritalst">
				<option value="single">single</option>
				<option value="married">married</option>
				<option value="divorced">divorced</option>
			</select>
			<br/>
		
			Salary:<br/>
		    <input type="text" name="salary"/> <br/>
			
			<br/>
			<input type="submit" value="Register">
		
		</fieldset>
	</form>
	
	
</body>
</html>