<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="minHeadBody.jsp"></jsp:include>
<script src="<c:url value="/resources/js/jquery.flot.js" />"></script>
<script
	src="<c:url value="/resources/js/jquery.flot.categories.min.js" />"></script>
<script src="<c:url value="/resources/js/about.js" />"></script>
</head>
<body>
	<div class="pageContainer">
		<div id="contextPath"
			value="${pageContext.servletContext.contextPath}"></div>
		<jsp:include page="menu.jsp" />
		<div class="span9">
			<div class="pageTitle">
				<spring:message code="about" />
			</div>
			<spring:message code="goal"/>
			<br />
			<spring:message code="statisticsRegisteredUsersOverThePast10o'clock" />:
			<br />
			<div id="chartContainer"></div>
		</div>
		<jsp:include page="sidebar.jsp" />
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>