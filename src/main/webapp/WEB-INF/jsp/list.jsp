<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student</title>
<style type="text/css">
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<h1>Student details</h1>
	<hr>

	<table>
		<tr>
			<th>STUDENT ID</th>
			<th>NAME</th>
			<th>EMAIL</th>
		</tr>
		<c:forEach items="${ students }" var="s">
			<tr>
				<td>${ s.sid }</td>
				<td>${ s.name }</td>
				<td>${ s.email }</td>
			</tr>
		</c:forEach>
	</table>

	<a href="/StudentCrud/">Add EMP</a>
	<a href="/StudentCrud/report?type=xls">Download Excel</a>
	<a href="/StudentCrud/report?type=pdf">Download PDF</a>

</body>
</html>