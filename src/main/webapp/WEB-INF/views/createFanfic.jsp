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
		<form:form method="post" modelAttribute="newFanfic">
			<jsp:include page="makeFanficForm.jsp"></jsp:include>
			<div class="row offset4">
				<spring:message code="createFanfic" var="createFanficTranslate" />
				<input type="submit" value="${createFanficTranslate}">
			</div>
		</form:form>
	</div>
</body>
</html>