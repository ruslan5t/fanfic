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
		<jsp:include page="menu.jsp" />
		<div class="span9">
			<div class="span4 offset2">
				<div class="well">
					<form:form method="POST" modelAttribute="user">
						<spring:message code="email" var="emailTranslate" />
						<form:input type="email" path="email" 
							placeholder="${emailTranslate}" maxlength="75" />

						<spring:message code="username" var="usernameTranslate" />
						<form:input path="username" placeholder="${usernameTranslate }" 
							maxlength="30" />

						<spring:message code="password" var="passwordTranslate" />
						<form:password path="password" placeholder="${passwordTranslate}" 
							maxlength="30"/>

						<c:if test="${not empty error}">
							<form:label path="">
								<spring:message code="userWithThisNameIsAlreadyRegistered" />.
							</form:label>
						</c:if>
						<spring:message code="register" var="registerTranslate" />
						<input type="submit" value="${registerTranslate}" class="btn" />
					</form:form>
				</div>
			</div>
		</div>
		<jsp:include page="sidebar.jsp" />
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>