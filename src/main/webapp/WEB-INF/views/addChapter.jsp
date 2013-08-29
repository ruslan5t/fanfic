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
		<jsp:include page="menu.jsp" />
		<div class="span9">
			<form:form method="POST" modelAttribute="chapter"
				action="${pageContext.servletContext.contextPath}/addChapter/${fanficId}">
				<jsp:include page="makeChapterForm.jsp" />
				<spring:message code="addChapter" var="addChapterTranslate" />
				<input type="submit" value="${addChapterTranslate}" class="btn" />
			</form:form>
		</div>
		<jsp:include page="sidebar.jsp" />
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>