<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="minHeadBody.jsp"></jsp:include>
<script src="<c:url value="/resources/js/tagcloud.jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/home.js" />"></script>
</head>
<body>
	<div class="pageContainer">
		<jsp:include page="menu.jsp"></jsp:include>
		<div class="span8">
			<div class="pageTitle">
				<spring:message code="mainPageTitle" />
			</div>
			<hr />
			<c:forEach items="${bestFanfics}" var="fanfic">
				<div class="postTitle">
					<a
						href="${pageContext.servletContext.contextPath}/fanfic/${fanfic.getId()}">
						${fanfic.getName()} </a>
				</div>
				<div class="author">
					<a
						href="${pageContext.servletContext.contextPath}/user/${fanfic.getAuthor().getId()}">
						${fanfic.getAuthor().getUsername()} </a>
				</div>
				<div class="description">
					${fanfic.getDescription()}
				</div>
				<div class="tags">
					Tags:
					<c:forEach items="${fanfic.getTags()}" var="tag">
						<div class="tag">${ tag.getName() }</div>
					</c:forEach>
				</div>
				<hr />
			</c:forEach>
		</div>
		<div class="sidePanel span4">
			<div id="tagcloud" class="row">
				<ul>
					<c:forEach items="${allTags}" var="tag">
						<li><a
							href="${pageContext.servletContext.contextPath}/catalog/tag/${tag.getId()}">
								${tag.getName()} </a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
