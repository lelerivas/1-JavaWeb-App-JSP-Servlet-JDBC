<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="entity.Staff" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consult</title>
</head>
<body>

<h2>Consult Staff</h2>

<a href="index.jsp">Home</a> &nbsp;|&nbsp;

<a href="positioncontrol">Registration Position </a> &nbsp;|&nbsp;	
	
<a href="newstaff">Registration Staff </a> &nbsp;|&nbsp;
		
<a href="staffcontrolcons">Consult Data </a> &nbsp;|&nbsp;

<hr /> <br />

${message}

<hr /> <br />

<table border="1" width="75%" bgcolor="Silver">
<tr><th colspan="8"> List of Staff</th></tr>

<tr>
	<th> ID </th>
	<th> NAME </th>
	<th> REG. COD </th>
	<th> MARITAL STATUS </th>
	<th> GENDER </th>
	<th> TITLE </th>
	<th> SALARY </th>
	<th> ACTIONS </th>
</tr>

  <c:forEach items="${liststaff}" var="staff">
	<tr>
	<td> ${staff.idstaff}</td>
	<td> ${staff.name}</td>
	<td> ${staff.regcod}</td>
	<td> ${staff.maritalst}</td>
	<td> ${staff.gender}</td>
	<td> ${staff.position.title}</td>
	<td> <fmt:formatNumber value="${staff.position.salary}" type="currency"/></td>
	<td style="text-align: center">
		 <a href="staffcontroledit?id=${staff.idstaff}">Edit</a>&nbsp;|&nbsp;
		 <a href="staffcontroldel?id=${staff.idstaff}">Delete</a>
	</td>
	</tr>
  </c:forEach>
  
</table>

</body>
</html>