<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="minHeadBody.jsp"></jsp:include>
<script src="<c:url value="/resources/js/editFanfic.js" />"></script>
</head>
<body>
	<div class="pageContainer">
		<jsp:include page="menu.jsp"></jsp:include>
		<form:form
			action="${pageContext.servletContext.contextPath}/editFanfic/${editingFanficId}"
			method="post" modelAttribute="newFanfic">
			<jsp:include page="makeFanficForm.jsp"></jsp:include>
			<div class="row offset4">
				<spring:message code="editFanfic" var="editFanficTranslate" />
				<input type="submit" value="${editFanficTranslate}" class="btn" />
			</div>
		</form:form>
	</div>
</body>
</html>