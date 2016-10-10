<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit</title>
</head>
<body>


<h2>Edit Staff</h2>

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
		
		ID:<br />
		<input type="text" name="codstaff" value="${staff.idstaff}" readonly="readonly"/>
		<br/>
		
		Name:<br />
		<input type="text" name="name" value="${staff.name}" >
		<br/>
		
		Reg Cod:<br />
		<input type="text" name="regcod" value="${staff.regcod }">
		<br/>
		
		Gender:<br/>
		
		<c:choose>
		<c:when test="${staff.gender == 'female'}">
			<input type="radio" name="gender" value="female" checked="checked">Female &nbsp;
			<input type="radio" name="gender" value="male">Male &nbsp;
		</c:when>
		<c:when test="${staff.gender == 'male'}">
			<input type="radio" name="gender" value="female">Female &nbsp;
			<input type="radio" name="gender" value="male" checked="checked">Male &nbsp;
		</c:when>
		</c:choose>
		
		
		<br/>
		
		Marital Status: <input type="text" value="${staff.maritalst}" readonly="readonly">  <br/>
		<select name="maritalst">
			<option value="">Select other </option>
			<option value="single">Single</option>
			<option value="married">Married</option>
			<option value="divorced">divorced</option>
		</select>
		
		<br/>
		
		Position: <input type="text" name="position" value="${staff.position.title}" readonly="readonly"> <br/>
		<select name="idposition">
			<option value="">Select other </option>
			<c:forEach items="${listposition}" var="position">
				<option value="${position.idposition}"> ${position.title} </option>					
			</c:forEach>
		
		<br/>

		</select>
		
		<input type="submit" value="Save"/>
		
	</fieldset>
</form>

</body>
</html>