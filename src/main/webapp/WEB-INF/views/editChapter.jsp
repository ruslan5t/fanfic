<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="minHeadBody.jsp"></jsp:include>
</head>
<body>
	<div class="pageContainer">
		<jsp:include page="menu.jsp"></jsp:include>
		<form:form
			action="${pageContext.servletContext.contextPath}/editChapter/${editingFanficId}/${editingChapterId}"
			method="POST" modelAttribute="newChapter">
			<jsp:include page="makeChapterForm.jsp"></jsp:include>
			<div class="row offset4">
				<spring:message code="editChapter" var="editChapterTranslate" />
				<input type="submit" value="${editChapterTranslate}" class="btn" />
			</div>
		</form:form>
	</div>
</body>
</html>