<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<div class="page-header" id="banner">
	<div class="row">
		<div class="col-lg-10">
			<h1>
				<spring:message code="registration" />
			</h1>
		</div>
	</div>
</div>

<div class="well optionForm">
	<form:form method="POST" modelAttribute="user"
		class="bs-example form-horizontal">
		<fieldset>
			<div class="form-group">
				<spring:message code="email" var="emailTranslate" />
				<c:if test="${not empty notCorrectEmail}">
					<c:set var="hasEmailError" value="has-error"/>
				</c:if>
				<div class="col-lg-10 ${hasEmailError}">
					<c:if test="${not empty notCorrectEmail}">
						<label class="control-label" for="email">
							<spring:message code="notCorrectEmail" />
						</label>
					</c:if>
					<form:input type="email" path="email"
						placeholder="${emailTranslate}" maxlength="75"
						class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<spring:message code="username" var="usernameTranslate" />
				<c:if test="${not empty notCorrectUsername}">
					<c:set var="hasUsernameError" value="has-error"/>
				</c:if>
				<c:if test="${not empty usernameAlreadyRegistered}">
					<c:set var="hasUsernameError" value="has-error"/>
				</c:if>
				<div class="col-lg-10 ${hasUsernameError}">
					<c:if test="${not empty notCorrectUsername}">
						<label class="control-label" for="username">
							<spring:message code="notCorrectUsername" />
						</label>
					</c:if>
					<c:if test="${not empty usernameAlreadyRegistered}">
						<label class="control-label" for="username">
							<spring:message code="usernameAlreadyRegistered" />
						</label>						
					</c:if>
					<form:input path="username" placeholder="${usernameTranslate}"
						maxlength="30" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<spring:message code="password" var="passwordTranslate" />
				<c:if test="${not empty notCorrectPassword}">
					<c:set var="hasPasswordError" value="has-error"/>
				</c:if>
				<div class="col-lg-10 ${hasPasswordError}">
					<c:if test="${not empty notCorrectPassword}">
						<label class="control-label" for="password">
							<spring:message code="notCorrectPassword" />
						</label>
					</c:if>
					<form:password path="password" placeholder="${passwordTranslate}"
						maxlength="30" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<div class="okButton">
					<spring:message code="register" var="registerTranslate" />
					<button type="submit" class="btn btn-primary">${registerTranslate}</button>
				</div>
			</div>
		</fieldset>
	</form:form>
</div>
