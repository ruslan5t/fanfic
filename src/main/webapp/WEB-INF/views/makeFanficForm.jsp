<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script src="<c:url value="/resources/js/makeFanficForm.js" />"></script>
<div id="contextPath" value="${pageContext.servletContext.contextPath}"></div>
<div class="row offset4">
	<form:label path="name"><spring:message code="name" />:</form:label>
	<form:input path="name" />
</div>
<div class="row offset4">
	<form:label path="description"><spring:message code="description" />:</form:label>
	<form:textarea path="description" />
</div>
<div class="row offset4">
	<form:label path="tags"><spring:message code="tags" />:</form:label>
	<form:input path="tags" id="tags" />
</div>
<div class="row offset4">
	<form:label path="categories"><spring:message code="categories" />:</form:label>
	<form:select path="categories" class="catigories">
	<c:forEach items="${allCategories}" var="category">
	<form:option value="${category.getName()}"><spring:message code="${category.getName()}" /></form:option>
	</c:forEach>
	</form:select>
</div>
<c:if test="${not empty emptyCategoriesError}">
	<div class="row offset4">
		<div class="span2">
			<spring:message code="notSelectedCategory" />
		</div>
	</div>
</c:if>