<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	media="screen">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet" media="screen">
<script src="<c:url value="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="row offset1">
		<div class="pageTitle">User profile</div>
	</div>
	<div class="row offset1">
		<hr />
	</div>
	<div class="row offset1">
		<h3>
			<b>${showedUser.getUsername()}</b>
		</h3>
	</div>
	<c:if test="${showedUser.getId().equals(currentUserId)}">
		<div class="row offset1">
			<a href="${pageContext.servletContext.contextPath}/createFanfic">
				Create fanfic </a>
		</div>
	</c:if>
	<div class="row offset1">
		<h3>
			<b>Fanfics:</b>
		</h3>
	</div>
	<c:forEach items="${showedUser.getFanfics()}" var="fanfic">
		<div class="row offset1">
			<h3>
				<a
					href="${pageContext.servletContext.contextPath}/fanfic/${fanfic.getId()}">${fanfic.getName()}</a>
			</h3>
		</div>
	</c:forEach>
</body>
</html>