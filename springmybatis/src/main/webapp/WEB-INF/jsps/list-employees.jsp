<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List Employees</h1>
	<button onclick="window.location.href='showFormAddEmployee.html'">Add Employee</button>
	<div>
		<table border="1">
			<tr>
				<th>Full Name</th>
				<th>Email</th>
				<th>Gender</th>
				<th>Hobbies</th>
				<th>Country</th>
				<th>Address</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${listemployees}" var="e" >
				<c:url var="deleteLink" value="/deleteemployee">
					<c:param name="employeeId" value="${e.id }"/>
				</c:url>
				<c:url var="updateLink" value="/editemployee">
						<c:param name="employeeId" value="${e.id }"/>
				</c:url>
				<tr>
					<td>${e.fullname}</td>
					<td>${e.email}</td>
					<td>${e.gender}</td>
					<td>${e.hobbies}</td>
					<td>${e.country}</td>
					<td>${e.address}</td>
					<td><a href="${updateLink }">Update</a> | <a href="${ deleteLink}" onclick="if(!confirm('Are you sure want to delete this Employee permanently')) return false">Delete</a> </td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>