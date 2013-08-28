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
			<div class="span4 offset2">
				<div class="well">
					<form method="post"
						action="${pageContext.servletContext.contextPath}/j_spring_security_check">
						<spring:message code="username" var="usernameTranslate" />
						<input id="j_username" name="j_username" type="text"
							placeholder="${usernameTranslate}" /> <br />
						<spring:message code="password" var="passwordTranslate" />
						<input id="j_password" name="j_password" type="password"
							placeholder="${passwordTranslate}" /> <br />
						<c:if test="${not empty wrongNameOrPasswordError}">
							<spring:message code="incorrectUsernameOrPassword" />
							<br />
						</c:if>
						<label class="checkbox"> <spring:message code="rememberMe" />
							<input id="j_remember" name="_spring_security_remember_me"
							type="checkbox" />
						</label>
						<spring:message code="signIn" var="signInTranslate" />
						<input type="submit" value="${signInTranslate}" class="btn" />
						<br />
					</form>
					<a href="${pageContext.servletContext.contextPath}/signUp">
						<spring:message	code="register" />
					</a>
					|
					<a href="${pageContext.servletContext.contextPath}/forgetPassword">
						<spring:message code="forgetPassword" />?
					</a>
				</div>
			</div>
		</div>
		<jsp:include page="sidebar.jsp" />
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>