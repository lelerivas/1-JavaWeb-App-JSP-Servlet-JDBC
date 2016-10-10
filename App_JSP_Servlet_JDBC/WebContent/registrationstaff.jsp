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

<form method="post" action="staffcontrolcad">
	<fieldset style="width: 35%"> 
	
		<legend> Inform Staff data</legend>
		
		Name:<br />
		<input type="text" name="name">
		<br/>
		
		Cod:<br />
		<input type="text" name="regcod">
		<br/>
		
		Gender:<br/>
		<input type="radio" name="gender" value="female">Female &nbsp;
		<input type="radio" name="gender" value="male">Male &nbsp;
		
		<br/>
		
		Marital Status:<br/>
		<select name="maritalst">
			<option value="single">Single</option>
			<option value="married">Married</option>
			<option value="divorced">divorced</option>
		</select>
		
		<br/>
		
		Position:<br/>
		<select name="idposition">
			<c:forEach items="${listposition}" var="position">
				<option value="${position.idposition}"> ${position.title} </option>					
			</c:forEach>
		</select>
		
		<br/>		
		
		<input type="submit" value="Save"/>
		
	</fieldset>
</form>

</body>
</html>