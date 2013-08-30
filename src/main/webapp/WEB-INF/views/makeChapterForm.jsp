<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="form-group">
	<form:label path="name" class="col-lg-2 control-label">
		<spring:message code="title" />:</form:label>
	<form:input path="name" class="form-control" />
	<c:if test="${not empty emptyTitle}">
		<spring:message code="emptyTitle" />
		<br />
	</c:if>
</div>
<div class="form-group">
	<form:label path="content" class="col-lg-2 control-label">
		<spring:message code="content" />:
	</form:label>
	<form:textarea path="content" class="chapterCreate form-control"/>
	<br />
	<c:if test="${not empty emptyContent}">
		<spring:message code="emptyContent" />
	</c:if>
</div>