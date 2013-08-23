<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
<link href="<c:url value="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />"
	rel="stylesheet" media="screen">
<script
	src="<c:url value="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="http://code.jquery.com/ui/1.10.3/jquery-ui.js" />"></script>
<script src="<c:url value="/resources/js/chapter.js" />"></script>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="row offset1">${chapter.getName()}</div>
	<div class="row offset1">
		<a
			href="${pageContext.servletContext.contextPath}/editChapter/${fanfic.getId()}/${chapter.getId()}">
			<spring:message code="edit" /> </a>
	</div>
	<div class="row offset1">
		<div class="span12">
			<div id="showChapterPlace">
					${chapterParsedContent}
			</div>
		</div>
	</div>
</body>
</html>