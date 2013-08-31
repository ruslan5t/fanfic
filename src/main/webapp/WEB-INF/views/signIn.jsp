<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="page-header" id="banner">
	<div class="row">
		<div class="col-lg-10">
			<h1>
				<spring:message code="login" />
			</h1>
		</div>
	</div>
</div>

<div class="well optionForm">
	<form class="bs-example form-horizontal" method="post"
		action="${pageContext.servletContext.contextPath}/j_spring_security_check">
		<fieldset>
			<div class="form-group">
				<spring:message code="username" var="usernameTranslate" />
				<div class="col-lg-10">
					<input id="j_username" name="j_username" type="text"
						placeholder="${usernameTranslate}" maxlength="30"
						class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<spring:message code="password" var="passwordTranslate" />
				<div class="col-lg-10">
					<input id="j_password" name="j_password" type="password"
						placeholder="${passwordTranslate}" maxlength="30"
						class="form-control" />

					<div class="checkbox">
						<spring:message code="rememberMe" />
						<label> <input id="j_remember"
							name="_spring_security_remember_me" type="checkbox" />
						</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="okButton">
					<spring:message code="signIn" var="signInTranslate" />
					<button type="submit" class="btn btn-primary">${signInTranslate}</button>
				</div>
			</div>
			<a href="${pageContext.servletContext.contextPath}/signUp"> <spring:message
					code="register" />
			</a> | <a href="${pageContext.servletContext.contextPath}/forgetPassword">
				<spring:message code="forgetPassword" />?
			</a>
		</fieldset>
	</form>
	<c:if test="${not empty wrongNameOrPasswordError}">
		<br />
		<br />
		<div class="alert alert-dismissable alert-danger">
			<spring:message code="incorrectUsernameOrPassword" />
		</div>
	</c:if>
</div>
