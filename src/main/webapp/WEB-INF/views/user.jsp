<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<div class="page-header" id="banner">
	<div class="row">
		<div class="col-lg-6">
			<h1>
				<spring:message code="userProfile" />
			</h1>
		</div>
	</div>
</div>

<hr />
<spring:message code="name" />
: ${showedUser.getUsername()}
<br />
<c:if test="${!noFanfics}">
	<h3>
		<b><spring:message code="fanfics" />:</b>
	</h3>
	<c:forEach items="${showedUser.getFanfics()}" var="fanfic">
		<a
			href="${pageContext.servletContext.contextPath}/fanfic/${fanfic.getId()}">${fanfic.getName()}</a>
		<c:if test="${showedUser.getId().equals(currentUserId)}">
			<form method="post"
				action="${pageContext.servletContext.contextPath}/removeFanfic/${fanfic.getId()}">
				<button class="remove">
					<div>x</div>
				</button>
			</form>
		</c:if>
		<br />
	</c:forEach>
</c:if>
<c:if test="${noFanfics}">
	<spring:message code="noFanfics" />
	<br />
</c:if>
<c:if test="${showedUser.getId().equals(currentUserId)}">
	<br />
	<a href="${pageContext.servletContext.contextPath}/createFanfic"> <spring:message
			code="createFanfic" />
	</a>
</c:if>

