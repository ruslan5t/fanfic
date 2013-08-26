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
		<div class="row offset4">
			<div class="span3">
				<form method="post" action="${pageContext.servletContext.contextPath}/j_spring_security_check">
					<div class="row">
						<div class="span3">
							<spring:message code="username" var="usernameTranslate" />
							<input id="j_username" name="j_username" type="text"
								placeholder="${usernameTranslate}" />
						</div>
					</div>
					<div class="row">
						<div class="span3">
							<spring:message code="password" var="passwordTranslate" />
							<input id="j_password" name="j_password" type="password"
								placeholder="${passwordTranslate}" />
						</div>
					</div>
					<c:if test="${not empty wrongNameOrPasswordError}">
						<div class="row">
							<div class="span3">
								<spring:message code="incorrectUsernameOrPassword" />
								.
							</div>
						</div>
					</c:if>
					<div class="row">
						<div class="span3">
							<label for="j_rememberme"> 
								<spring:message code="rememberMe" />
							</label> 
							<input id="j_remember"
								name="_spring_security_remember_me" type="checkbox" />
						</div>
					</div>
					<div class="row">
						<div class="span2">
							<spring:message code="signIn" var="signInTranslate" />
							<input type="submit" value="${signInTranslate}">
						</div>
						<div class="span2">
							<a href="${pageContext.servletContext.contextPath}/signUp"><spring:message code="registerNow" /></a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>