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
	<div id="contextPath" value="${pageContext.servletContext.contextPath}"></div>
	<jsp:include page="menu.jsp" />
	<div class="container">
		<div class="col-xs-12 col-sm-9">
			<div class="page-header" id="banner">
				<div class="row">
					<div class="col-lg-6">
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
		</div>
		<jsp:include page="sidebar.jsp" />
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>