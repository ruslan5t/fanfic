<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<script src="<c:url value="/resources/js/jquery.cookie.js" />"></script>
<script src="<c:url value="/resources/js/chapter.js" />"></script>


<div class="page-header" id="banner">
	<div class="row">
		<div class="col-lg-6">
			<h1>
				<a
					href="${pageContext.servletContext.contextPath}/fanfic/${fanfic.getId()}">
					${fanfic.getName()} </a> / ${chapter.getName()}
			</h1>
		</div>
	</div>
</div>
<div class="pageTitle">
	<a
		href="${pageContext.servletContext.contextPath}/fanfic/${fanfic.getId()}">
		${fanfic.getName()} </a> / ${chapter.getName()}
</div>
<a
	href="${pageContext.servletContext.contextPath}/editChapter/${fanfic.getId()}/${chapter.getId()}">
	<spring:message code="editChapter" />
</a>
<select id="fontSizes"></select>
<input type="range" id="widthRange" value="100" />
<div id="resizableChapterPlace">
	<div id="textChapterPlace">
		<pre>${chapterParsedContent}</pre>
	</div>
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
	<br /> <a class="goToContentLink"
		href="${pageContext.servletContext.contextPath}/fanfic/${fanfic.getId()}">
		<spring:message code="goToContent" />
	</a>
</div>