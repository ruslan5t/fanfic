<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<script src="<c:url value="/resources/js/jquery.flot.js" />"></script>
<script
	src="<c:url value="/resources/js/jquery.flot.categories.min.js" />"></script>
<script src="<c:url value="/resources/js/about.js" />"></script>

<div id="contextPath" value="${pageContext.servletContext.contextPath}"></div>
<div class="page-header" id="banner">
	<div class="row">
		<div class="col-lg-10">
			<h1>
				<spring:message code="about" />
			</h1>
		</div>
	</div>
</div>
<spring:message code="goal"/>
<br /><br />
<spring:message code="statisticsRegisteredUsersOverThePast10o'clock" />:
<br /><br />
<div id="chartContainer"></div>
