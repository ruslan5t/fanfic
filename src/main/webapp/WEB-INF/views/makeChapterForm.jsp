<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="row offset7">
	<form:label path="name">Name:</form:label>
	<form:input path="name" />
</div>
<div class="row offset7">
	<form:label path="content">Content:</form:label>
	<form:textarea path="content" />
</div>