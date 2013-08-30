<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="page-header" id="banner">
	<div class="row">
		<div class="col-lg-6">
			<h1>
				<spring:message code="search" /> : "${searchRequest}"
			</h1>
		</div>
	</div>
</div>

<c:forEach items="${foundedFanfics}" var="foundedFanfic">
	<a
		href="${pageContext.servletContext.contextPath}/fanfic/${foundedFanfic.getId()}">
		${foundedFanfic.getName()} </a>
</c:forEach>