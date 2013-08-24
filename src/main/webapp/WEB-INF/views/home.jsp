<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Home</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	media="screen">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet" media="screen">
<script
	src="<c:url value="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/tagcloud.jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/home.js" />"></script>
</head>
<body>
	<div class="pageContainer">
		<div class="pageContainer">
			<jsp:include page="menu.jsp"></jsp:include>
			<div class="span7 pageContent">
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
					<h3>
						<a
							href="${pageContext.servletContext.contextPath}/user/${fanfic.getAuthor().getId()}">
							${fanfic.getAuthor().getUsername()} </a>
					</h3>
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
	</div>
</body>
</html>
