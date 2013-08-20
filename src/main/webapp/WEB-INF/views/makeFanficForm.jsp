<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	<form:textarea path="tags" />
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