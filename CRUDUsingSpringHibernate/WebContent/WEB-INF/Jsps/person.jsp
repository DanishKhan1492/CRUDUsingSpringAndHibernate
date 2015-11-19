<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Persons</title>
</head>
<body>
	
	<h2>Manipulate Persons Data</h2>
	<form:form action="/CRUDUsingSpringHibernate/person" method="post" commandName="person">
		<table>
			<tr>
				<td> <form:hidden path="personId" /> </td>
			</tr>
			<tr>
				<td>First Name</td>
				<td> <form:input path="firstName" /> </td>
			</tr>
			
			<tr>
				<td>Last Name</td>
				<td> <form:input path="lastName" /> </td>
			</tr>
			
			<tr>
				<td>User Name</td>
				<td> <form:input path="userName" /> </td>
			</tr>
			
			<tr>
				<td>Address</td>
				<td> <form:input path="address" /> </td>
			</tr>
			
			<tr>
				<td>Contact Number</td>
				<td> <form:input path="contactNumber" /> </td>
			</tr>
			
			<tr>
				<td> <input type="submit" name="action" value="Add"> </td>
				<td> <input type="submit" name="action" value="Edit"> </td>
				<td> <input type="submit" name="action" value="delete"> </td>
				<td> <input type="submit" name="action" value="Search"> </td>
			</tr>
			
		</table>
	</form:form>
	
	<br/><br/><br/><br/><br/>
	<h2>Person List</h2>	
	<table border="1" cellspacing="2" cellpadding="1">
		<tr>
			<th>Person Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>User Name</th>
			<th>Address</th>
			<th>Contact Number</th>
		</tr>
		
		<c:forEach var="person" items="${personList}">
			<tr>
				<td>${person.personId}</td>
				<td>${person.firstName}</td>
				<td>${person.lastName}</td>
				<td>${person.userName}</td>
				<td>${person.address}</td>
				<td>${person.contactNumber}</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>