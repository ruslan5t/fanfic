<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="minHeadBody.jsp"></jsp:include>
</head>
<body>
	<div class="pageContainer">
		<jsp:include page="menu.jsp"></jsp:include>
		<div class="span9">
			<div class="span4 offset2">
				<div class="well">
					<form method="post">
						<spring:message code="username" var="usernameTranslate" />
						<input type="text" name="username" 
							placeholder="${usernameTranslate}" /> 
						<spring:message code="continue" var="continueTranslate" />
						<input type="submit" class="btn" value="${continueTranslate}" />
					</form>
				</div>
			</div>
		</div>
		<jsp:include page="sidebar.jsp" />
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>