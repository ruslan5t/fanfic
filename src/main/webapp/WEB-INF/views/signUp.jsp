<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<div class="row offset4">
			<form:form method="POST" modelAttribute="user">
				<p>
					<spring:message code="email" var="emailTranslate" />
					<form:input path="email" placeholder="${emailTranslate}" />
				</p>
				<p>
					<spring:message code="username" var="usernameTranslate" />
					<form:input path="username" placeholder="${usernameTranslate }" />
				</p>
				<p>
					<spring:message code="password" var="passwordTranslate" />
					<form:password path="password" placeholder="${passwordTranslate}" />
				</p>
				<c:if test="${not empty error}">
					<p>
						<form:label path="">
							<spring:message code="userWithThisNameIsAlreadyRegistered" />.
					</form:label>
					</p>
				</c:if>
				<spring:message code="register" var="registerTranslate" />
				<input type="submit" value="${registerTranslate}" />
			</form:form>
		</div>
	</div>
</body>
</html>