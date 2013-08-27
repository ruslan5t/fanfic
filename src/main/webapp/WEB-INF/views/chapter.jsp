<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="minHeadBody.jsp"></jsp:include>
<link
	href="<c:url value="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />"
	rel="stylesheet" media="screen">
<script
	src="<c:url value="http://code.jquery.com/ui/1.10.3/jquery-ui.js" />"></script>
<script src="<c:url value="/resources/js/chapter.js" />"></script>
</head>
<body>
	<div class="pageContainer">
		<jsp:include page="menu.jsp" />
		<div class="span9">
			<div class="pageTitle"><a
						href="${pageContext.servletContext.contextPath}/fanfic/${fanfic.getId()}">
						${fanfic.getName()} </a> / ${chapter.getName()}</div>
			<a
				href="${pageContext.servletContext.contextPath}/editChapter/${fanfic.getId()}/${chapter.getId()}">
				<spring:message code="editChapter" />
			</a>
			<select id="fontSizes"></select>
			<div id="resizableChapterPlace">
				<div id="textChapterPlace">${chapterParsedContent}</div>
			</div>

			<div class="span8">
				<c:if test="${!isFirstChapter}">
					<a
						href="${pageContext.servletContext.contextPath}/chapter/prev/${fanfic.getId()}/${chapter.getId()}">
						${prevChapterName}</a>
				</c:if>
				<c:if test="${!isLastChapter}">
					<a class="nextChapterLink"
						href="${pageContext.servletContext.contextPath}/chapter/next/${fanfic.getId()}/${chapter.getId()}">
						${nextChapterName}</a>
				</c:if>
			</div>
		</div>
		<jsp:include page="sidebar.jsp" />
	</div>
</body>
</html>