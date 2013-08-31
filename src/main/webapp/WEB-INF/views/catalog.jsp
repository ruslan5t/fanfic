<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<link href="<c:url value="/resources/css/simplePagination.css" />"
	rel="stylesheet" media="screen">
<script src="<c:url value="/resources/js/jquery.simplePagination.js" />"></script>
<script src="<c:url value="/resources/js/catalog.js" />"></script>

<jsp:include page="catalogJSVariables.jsp" />
<div class="page-header" id="banner">
	<div class="row">
		<div class="col-lg-10">
			<h1>
				<spring:message code="catalog" />
				/
				<spring:message code="${categoryName}" />
			</h1>
		</div>
	</div>
</div>
<jsp:include page="showCatalogFanfics.jsp" />

