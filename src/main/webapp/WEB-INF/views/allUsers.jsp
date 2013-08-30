<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="page-header" id="banner">
	<div class="row">
		<div class="col-lg-6">
			<h1>
				<spring:message code="listOfUsers" />
			</h1>
		</div>
	</div>
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
