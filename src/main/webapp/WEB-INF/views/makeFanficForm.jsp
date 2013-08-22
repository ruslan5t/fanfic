<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script src="<c:url value="/resources/js/makeFanficForm.js" />"></script>
<div id="contextPath" value="${pageContext.servletContext.contextPath}"></div>
<div class="row offset7">
	<form:label path="name">Name:</form:label>
	<form:input path="name" />
</div>
<div class="row offset7">
	<form:label path="description">Description:</form:label>
	<form:textarea path="description" />
</div>
<div class="row offset7">
	<form:label path="tags">Tags:</form:label>
	<form:input path="tags" id="tags" />
</div>
<div class="row offset7">
	<form:label path="categories">Categories:</form:label>
	<form:select path="categories" class="catigories">
		<form:option value="comedy">comedy</form:option>
		<form:option value="tragedy">tragedy</form:option>
		<form:option value="drama">drama</form:option>
		<form:option value="fantasy">fantasy</form:option>
	</form:select>
</div>