<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="minHeadBody.jsp"></jsp:include>
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