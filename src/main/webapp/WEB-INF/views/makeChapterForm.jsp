<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row offset4">
	<form:label path="name">
		<spring:message code="name" />:</form:label>
	<form:input path="name" />
</div>
<div class="row offset4">
	<form:label path="content">
		<spring:message code="content" />:</form:label>
	<form:textarea path="content" />
</div>