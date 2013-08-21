<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="row offset1">
		<div class="span7">
			<div class="pageTitle">Main page</div>
			<hr />
			<c:forEach items="${bestFanfics}" var="fanfic">
				<div class="row">
					<h2>
						<a
							href="${pageContext.servletContext.contextPath}/fanfic/${fanfic.getId()}">
							${fanfic.getName()} </a>
					</h2>
				</div>
			</c:forEach>
		</div>
		<div class="span7">
			<div id="tagcloud" class="row">
				<ul>
					<li><a
						href="${pageContext.servletContext.contextPath}/catalog/comedy">
							comedy</a></li>
					<li><a
						href="${pageContext.servletContext.contextPath}/catalog/tragedy">
							tragedy</a></li>
					<li><a
						href="${pageContext.servletContext.contextPath}/catalog/drama">
							drama</a></li>
					<li><a
						href="${pageContext.servletContext.contextPath}/catalog/fantasy">
							fantasy</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
