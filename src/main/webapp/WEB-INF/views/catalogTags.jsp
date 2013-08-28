<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="minHeadBody.jsp"></jsp:include>
<link href="<c:url value="/resources/css/simplePagination.css" />"
	rel="stylesheet" media="screen">
<script src="<c:url value="/resources/js/jquery.simplePagination.js" />"></script>
<script src="<c:url value="/resources/js/catalog.js" />"></script>
</head>
<body>
	<div class="pageContainer">
		<jsp:include page="catalogJSVariables.jsp"></jsp:include>
		<jsp:include page="menu.jsp" />
		<div class="span9">
			<div class="pageTitle">
				<spring:message code="catalog" />
				/ ${tagName}
			</div>
			<jsp:include page="showCatalogFanfics.jsp"></jsp:include>
		</div>
		<jsp:include page="sidebar.jsp" />
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>