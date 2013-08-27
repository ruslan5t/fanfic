<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="minHeadBody.jsp"></jsp:include>
</head>
<body>
	<div class="pageContainer">
		<jsp:include page="menu.jsp"></jsp:include>
		<c:forEach items="${allUsers}" var="user">
			<div class="row offset1">
				<a
					href="${pageContext.servletContext.contextPath}/user/${user.getId()}">
					${user.getUsername()} </a>
				<form method="post"
					action="${pageContext.servletContext.contextPath}/removeUser/${user.getId()}">
					<button class="btn">
						<spring:message code="remove" />
					</button>
				</form>
			</div>
		</c:forEach>
	</div>
</body>
</html>