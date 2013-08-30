<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="page-header" id="banner">
	<div class="row">
		<div class="col-lg-6">
			<h1>Vosstanovlenie parolya</h1>
		</div>
	</div>
</div>
<div class="well optionForm">
	<form class="bs-example form-horizontal" method="post">
		<fieldset>
			<div class="form-group">
				<spring:message code="username" var="usernameTranslate" />
				<div class="col-lg-10">
					<input type="text" name="username"
						placeholder="${usernameTranslate}" class="form-control" />
				</div>
				<c:if test="${not empty notExistUser}">
					<spring:message code="notExistUser" />
				</c:if>
			</div>
			<div class="form-group">
				<div class="okButton">
					<spring:message code="continue" var="continueTranslate" />
					<button type="submit" class="btn btn-primary">${continueTranslate}</button>
				</div>
			</div>
		</fieldset>
	</form>
</div>
