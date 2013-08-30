<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="page-header" id="banner">
	<div class="row">
		<div class="col-lg-6">
			<h1>Vosstanovlenie parolya</h1>
		</div>
	</div>
</div>
<div class="well">
	<form class="bs-example form-horizontal" method="post">
		<fieldset>
			<legend>Legenda</legend>
			<div class="form-group">
				<spring:message code="username" var="usernameTranslate" />
				<label for="username" class="col-lg-2 control-label">${usernameTranslate}</label>
				<div class="col-lg-10">
					<input type="text" name="username"
						placeholder="${usernameTranslate}" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-10 col-lg-offset-2">
					<spring:message code="continue" var="continueTranslate" />
					<button type="submit" class="btn btn-primary">${continueTranslate}</button>
				</div>
			</div>
		</fieldset>
	</form>
</div>
