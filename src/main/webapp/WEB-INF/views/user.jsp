<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	media="screen">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet" media="screen">
<script
	src="<c:url value="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="row offset1">
		<div class="pageTitle">
			<spring:message code="userProfile" />
		</div>
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
				<spring:message code="createFanfic" />
			</a>
		</div>
	</c:if>
	<div class="row offset1">
		<h3>
			<b><spring:message code="fanfics" />:</b>
		</h3>
	</div>
	<c:forEach items="${showedUser.getFanfics()}" var="fanfic">
		<div class="row offset1">
			<div class="span2">
				<h4>
					<a
						href="${pageContext.servletContext.contextPath}/fanfic/${fanfic.getId()}">${fanfic.getName()}</a>
				</h4>
			</div>
			<c:if test="${showedUser.getId().equals(currentUserId)}">
				<div class="span1">
					<form method="post"
						action="${pageContext.servletContext.contextPath}/removeFanfic/${fanfic.getId()}">
						<button>
							<spring:message code="remove" />
						</button>
					</form>
				</div>
			</c:if>
		</div>
	</c:forEach>
</body>
</html>