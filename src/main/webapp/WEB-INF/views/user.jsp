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
			<td><a href="/fanfic/createFanfic">Create fanfic</a></td>
		</tr>
		<tr>
			<td>
				<div class="pageTitle">User profile</div>
			</td>
		</tr>
		<tr>
			<td>
				<hr />
			</td>
		</tr>
		<tr>
			<td>
				<h3><b>${showedUser.getUsername()}</b></h3>
			</td>
		</tr>
		<tr>
			<td>
				<h3><b>Fanfics:</b></h3>
			</td>
		</tr>
		<c:forEach items="${showedUser.getFanfics()}" var="fanfic">
			<tr>
				<td>
					<h3>
						<a href="/fanfic/fanfic/${fanfic.getId()}">${fanfic.getName()}</a>
					</h3>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>