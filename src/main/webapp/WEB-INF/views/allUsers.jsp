<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="minHeadBody.jsp" />
</head>
<body>
	<div class="pageContainer">
		<jsp:include page="menu.jsp" />
		<div class="span9">
			<div class="pageTitle">
				<spring:message code="listOfUsers" />
			</div>
			<c:forEach items="${allUsers}" var="user">
				<a
					href="${pageContext.servletContext.contextPath}/user/${user.getId()}">
					${user.getUsername()} </a>
				<form method="post"
					action="${pageContext.servletContext.contextPath}/removeUser/${user.getId()}">
					<button class="remove">
						<div>x</div>
					</button>
				</form>
				<br />
			</c:forEach>
		</div>
		<jsp:include page="sidebar.jsp" />
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>