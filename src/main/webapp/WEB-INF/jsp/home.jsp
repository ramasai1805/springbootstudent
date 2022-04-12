<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Student Registration</h1>

	<form action="/StudentCrud/save" method="post">

		<label for="name">Enter Name : </label> <input type="text" id="name"
			name="name">
		<hr>
		<label for="email">Enter Email : </label> <input type="text"
			id="email" name="email">
		<hr>
		<input type="submit" value="Submit">

	</form>

	<a href="/StudentCrud/getall" method="get">VIEW STUDENTS</a>

	<div>
		<a href="<c:url value="?lang=vi"/>"> <spring:message
				code="app.lang.vi" />
		</a> | <a href="<c:url value="?lang=en"/>"> <spring:message
				code="app.lang.en" />
		</a>

		<h1>
			<spring:message code="app.welcome" />
			!
		</h1>

		<P>
			<spring:message code="app.time" />
			${serverTime}.
		</P>
	</div>

</body>
</html>