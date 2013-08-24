<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	media="screen">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet" media="screen">
<link href="<c:url value="/resources/css/simplePagination.css" />"
	rel="stylesheet" media="screen">
<script
	src="<c:url value="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.simplePagination.js" />"></script>
<script src="<c:url value="/resources/js/catalog.js" />"></script>
</head>
<body>
	<div class="pageContainer">
		<div id="contextPath"
			value="${pageContext.servletContext.contextPath}"></div>
		<div id="countItems" value="${countItems}"></div>
		<div id="pageNumber" value="${pageNumber}"></div>
		<div id="countOnPage" value="${countOnPage}"></div>
		<div id="addressPastCatalog" value="${addressPastCatalog}"></div>
		<jsp:include page="menu.jsp"></jsp:include>
		<div class="row offset1">
			<div class="pageTitle">
				<spring:message code="catalog" />
			</div>
		</div>
		<div class="row offset1">
			<hr />
		</div>
		<div class="row offset1">
			<div class="span12">
				<c:forEach items="${allFanfics}" var="fanfic">
					<div class="row">
						<div class="span12">
							<a
								href="${pageContext.servletContext.contextPath}/fanfic/${fanfic.getId()}">
								${fanfic.getName()} </a>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="row offset1">
			<div class="span11">
				<div id="pagination"></div>
			</div>
		</div>
	</div>
</body>
</html>