<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="minHeadBody.jsp"></jsp:include>
</head>
<body>
	<div class="pageContainer">
		<jsp:include page="menu.jsp"></jsp:include>
		<div class="span7">
			<h2 class="pageTitle">
				<spring:message code="mainPage" />
			</h2>
			<hr />
			<c:forEach items="${bestFanfics}" var="fanfic">
				<h2>
					<a
						href="${pageContext.servletContext.contextPath}/fanfic/${fanfic.getId()}">
						${fanfic.getName()} </a>
				</h2>
				<h4>
					<a
						href="${pageContext.servletContext.contextPath}/user/${fanfic.getAuthor().getId()}">
						${fanfic.getAuthor().getUsername()} </a>
				</h4>
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
