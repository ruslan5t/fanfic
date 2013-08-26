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
		<c:if test="${!noFanfics}">
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
		</c:if>
		<c:if test="${noFanfics}">
			<spring:message code="noFanfics" />
		</c:if>
	</div>
</body>
</html>