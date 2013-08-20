<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	media="screen">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet" media="screen">
<script
	src="<c:url value="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="row offset7">
		<div class="span3">
			<form:form method="post" modelAttribute="user" class="inputDialog">
				<div class="row">
					<div class="span3">
						<form:input path="username" placeholder="Username" />
					</div>
				</div>
				<div class="row">
					<div class="span3">
						<form:password path="password" placeholder="Password" />
					</div>
				</div>
				<c:if test="${not empty error}">
					<div class="row">
						<div class="span3">
							<form:label path="">Incorrect username or password.</form:label>
						</div>
					</div>
				</c:if>
				<div class="row">
					<div class="span1">
						<input type="submit" value="Sign in">
					</div>
					<div class="span2">
						<a href="signUp">Register now</a>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>