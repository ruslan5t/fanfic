<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
	<div class="pageContainer">
		<jsp:include page="menu.jsp"></jsp:include>
		<div class="row offset4">
			<div class="span3">
				<form:form method="post" modelAttribute="user">
					<div class="row">
						<div class="span3">
							<spring:message code="username" var="usernameTranslate" />
							<form:input path="username" placeholder="${usernameTranslate}" />
						</div>
					</div>
					<div class="row">
						<div class="span3">
							<spring:message code="password" var="passwordTranslate" />
							<form:password path="password" placeholder="${passwordTranslate}" />
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
							<spring:message code="signIn" var="signInTranslate" />
							<input type="submit" value="${signInTranslate}">
						</div>
						<div class="span2">
							<a href="signUp"><spring:message code="registerNow" /></a>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>