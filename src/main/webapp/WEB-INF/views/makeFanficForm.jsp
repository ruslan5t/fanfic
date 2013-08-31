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
	<c:if test="${not empty emptyTitle}">
		<c:set var="hasTitleError" value="has-error" />
	</c:if>
	<div class="${hasTitleError}">
		<c:if test="${not empty emptyTitle}">
		</c:if>
		<form:input path="name" class="form-control" />
	</div>
</div>
<div class="form-group">
	<form:label path="description" class="col-lg-2 control-label">
		<spring:message code="description" />:</form:label>
	<c:if test="${not empty emptyDescription}">
		<c:set var="hasDescriptionError" value="has-error" />
	</c:if>
	<div class="${ hasDescriptionError }">
		<form:textarea path="description"
			class="form-control descriptionCreate" />
	</div>
</div>
<div class="form-group">
	<form:label path="tags" class="col-lg-2 control-label">
		<spring:message code="tags" />:
	</form:label>
	<form:input path="tags" id="tags" class="form-control" />
</div>
<div class="form-group">
	<form:label path="categories" class="col-lg-2 control-label"
		for="categories">
		<spring:message code="categories" />:</form:label>
	<c:if test="${not empty emptyCategories}">
		<c:set var="hasCategoriesError" value="has-error" />
	</c:if>
	<div class="${ hasCategoriesError }">
		<form:select path="categories" class="form-control">
			<c:forEach items="${allCategories}" var="category">
				<form:option value="${category.getName()}">
					<spring:message code="${category.getName()}" />
				</form:option>
			</c:forEach>
		</form:select>
	</div>
</div>