<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script src="<c:url value="/resources/js/makeFanficForm.js" />"></script>
<div id="contextPath" value="${pageContext.servletContext.contextPath}"></div>

<div class="form-group">
	<form:label path="name" class="col-lg-2 control-label">
		<spring:message code="title" />:
	</form:label>
	<form:input path="name" class="form-control" />
	<br />
	<c:if test="${not empty emptyTitle}">
		<spring:message code="emptyTitle" />
		<br />
	</c:if>
</div>
<div class="form-group">
	<form:label path="description" class="col-lg-2 control-label">
		<spring:message code="description" />:</form:label>
	<form:textarea path="description"
		class="form-control descriptionCreate" />

	<c:if test="${not empty emptyDescription}">
		<span class="help-block"> <spring:message
				code="emptyDescription" />
		</span>
	</c:if>
</div>
<div class="form-group">
	<form:label path="tags" class="col-lg-2 control-label">
		<spring:message code="tags" />:
	</form:label>
	<form:input path="tags" id="tags" class="form-control" />
</div>
<div class="form-group">
	<form:label path="categories" class="col-lg-2 control-label">
		<spring:message code="categories" />:</form:label>
	<form:select path="categories" class="form-control">
		<c:forEach items="${allCategories}" var="category">
			<form:option value="${category.getName()}">
				<spring:message code="${category.getName()}" />
			</form:option>
		</c:forEach>
	</form:select>
	<c:if test="${not empty emptyCategories}">
		<spring:message code="notSelectedCategory" />
		<br />
	</c:if>
</div>