<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="minHeadBody.jsp"></jsp:include>
</head>
<body>
	<div class="pageContainer">
		<jsp:include page="menu.jsp" />
		<div class="span9">
			<div class="pageTitle">
				<spring:message code="userProfile" />
			</div>
			<hr />
			<spring:message code="name"/>: ${showedUser.getUsername()}
			<br />
			<c:if test="${!noFanfics}">
				<h3>
					<b><spring:message code="fanfics" />:</b>
				</h3>
				<c:forEach items="${showedUser.getFanfics()}" var="fanfic">
					<h4>
						<a
							href="${pageContext.servletContext.contextPath}/fanfic/${fanfic.getId()}">${fanfic.getName()}</a>
					</h4>
					<c:if test="${showedUser.getId().equals(currentUserId)}">
						<form method="post"
							action="${pageContext.servletContext.contextPath}/removeFanfic/${fanfic.getId()}">
							<button class="btn" >
								<spring:message code="remove" />
							</button>
						</form>
					</c:if>
				</c:forEach>
			</c:if>
			<c:if test="${noFanfics}">
				<spring:message code="noFanfics" />
				<br />
			</c:if>
			<c:if test="${showedUser.getId().equals(currentUserId)}">
				<a href="${pageContext.servletContext.contextPath}/createFanfic">
					<spring:message code="createFanfic" />
				</a>
			</c:if>
		</div>
		<jsp:include page="sidebar.jsp" />
	</div>
</body>
</html>