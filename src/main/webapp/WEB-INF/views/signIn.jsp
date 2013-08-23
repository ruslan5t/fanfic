<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
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
			<form:form method="post" modelAttribute="user">
				<div class="row">
					<div class="span3">
						<form:input path="username" placeholder="<spring:message code="username" />" />
					</div>
				</div>
				<div class="row">
					<div class="span3">
						<form:password path="password" placeholder="<spring:message code="password" />" />
					</div>
				</div>
				<c:if test="${not empty error}">
					<div class="row">
						<div class="span3">
							<form:label path="">
							<spring:message code="incorrectUsernameOrPassword" />.
							</form:label>
						</div>
					</div>
				</c:if>
				<div class="row">
					<div class="span1">
						<input type="submit" value="Sign in">
					</div>
					<div class="span2">
						<a href="signUp"><spring:message code="registerNow" /></a>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>