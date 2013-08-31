<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="<c:url value="/resources/js/editFanfic.js" />"></script>

<div class="page-header" id="banner">
	<div class="row">
		<div class="col-lg-10">
			<h1><spring:message code="editingFanfic" /></h1>
		</div>
	</div>
</div>

<div class="well">
	<form:form class="bs-example form-horizontal"
		action="${pageContext.servletContext.contextPath}/editFanfic/${editingFanficId}"
		method="post" modelAttribute="newFanfic">
		<fieldset>
			<jsp:include page="makeFanficForm.jsp" />
			<div class="form-group">
				<div class="col-lg-10 col-lg-offset-2">
					<spring:message code="editFanfic" var="editFanficTranslate" />
					<button type="submit" class="btn btn-primary">${editFanficTranslate}</button>
				</div>
			</div>
		</fieldset>
	</form:form>
</div>