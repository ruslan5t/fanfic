<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="page-header" id="banner">
	<div class="row">
		<div class="col-lg-10">
			<h1>
				<spring:message code="fanficCreating"/>
			</h1>
		</div>
	</div>
</div>

<div class="well">
	<form:form method="post" modelAttribute="newFanfic"
		class="bs-example form-horizontal">
		<fieldset>
			<jsp:include page="makeFanficForm.jsp" />
			<div class="form-group">
				<div class="col-lg-10 col-lg-offset-2">
					<spring:message code="createFanfic" var="createFanficTranslate" />
					<input type="submit" value="${createFanficTranslate}" class="btn btn-primary" />
				</div>
			</div>
		</fieldset>
	</form:form>
</div>