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
	<jsp:include page="menu.jsp" />
	<div class="container">
		<div class="col-xs-12 col-sm-9">
			<div class="page-header" id="banner">
				<div class="row">
					<div class="col-lg-6">
						<h1>
							<spring:message code="registration" />
						</h1>
					</div>
				</div>
			</div>
			
			<div class="well">
           		<form:form method="POST" modelAttribute="user" class="bs-example form-horizontal">
                	<fieldset>
                  		<legend>Registration</legend>
                  		<div class="form-group">
                  			<spring:message code="email" var="emailTranslate" />
                    		<label for="email" class="col-lg-2 control-label">${emailTranslate}</label>
                    		<div class="col-lg-10">
                      			<form:input type="email" path="email" placeholder="${emailTranslate}" maxlength="75"  class="form-control"/>
                    		</div>
                    		<c:if test="${not empty notCorrectEmail}">
								<spring:message code="notCorrectEmail" />
								<br />
							</c:if>
                  		</div>
                  		<div class="form-group">
                  			<spring:message code="username" var="usernameTranslate" />
                    		<label for="username" class="col-lg-2 control-label">${usernameTranslate}</label>
                    		<div class="col-lg-10">
                      			<form:input path="username" placeholder="${usernameTranslate}" maxlength="30"  class="form-control"/>
                    		</div>
                    		<c:if test="${not empty notCorrectUsername}">
								<spring:message code="notCorrectUsername" />
								<br />
							</c:if>
							<c:if test="${not empty usernameAlreadyRegistered}">
								<spring:message code="usernameAlreadyRegistered" />
								<br />
							</c:if>
                  		</div>
                  		<div class="form-group">
                  			<spring:message code="password" var="passwordTranslate" />
                    		<label for="password" class="col-lg-2 control-label">${passwordTranslate}</label>
                    		<div class="col-lg-10">
                      			<form:password path="password" placeholder="${passwordTranslate}" maxlength="30"  class="form-control"/>
                    		</div>
                    		<c:if test="${not empty notCorrectPassword}">
								<spring:message code="notCorrectPassword" />
								<br />
							</c:if>
                  		</div>
                  		<div class="form-group">
                    		<div class="col-lg-10 col-lg-offset-2">
                      			<spring:message code="register" var="registerTranslate" />
                      			<button type="submit" class="btn btn-primary">${registerTranslate}</button> 
                    		</div>
                  		</div>
                	</fieldset>
              	</form:form>
			</div>
		</div>
		<jsp:include page="sidebar.jsp" />
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>