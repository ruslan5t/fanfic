<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/style.css" />" 
	rel="stylesheet" media="screen">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet" media="screen">
<script src="/resources/js/jquery-1.10.2.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="navbar">
		<div class="navbar-inner">
			<ul class="nav">
				<jsp:include page="menu.jsp"></jsp:include>
			</ul>
		</div>
	</div>
	<table>
		<tr>
			<td>
			<form:form method="post" modelAttribute="user" class="inputDialog">
				<p><form:input path="username" placeholder="Username"/></p>
				<p><form:password path="password" placeholder="Password"/></p>
				<c:if test="${not empty error}">
					<p><form:label path="">Incorrect username or password.</form:label></p>
				</c:if>
				<input type="submit" value="Sign in">
				<a href="signUp">Register now</a>
			</form:form>
			</td>
		</tr>
	</table>
</body>
</html>