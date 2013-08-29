<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="minHeadBody.jsp"></jsp:include>
</head>
<body>
	<div class="pageContainer">
		<jsp:include page="menu.jsp" />
		<div class="span9">
			<div class="pageTitle">
				<spring:message code="search"/>: "${searchRequest}"
			</div>
			<hr />
			<c:forEach items="${foundedFanfics}" var="foundedFanfic">
				<a
					href="${pageContext.servletContext.contextPath}/fanfic/${foundedFanfic.getId()}">
					${foundedFanfic.getName()} </a>
			</c:forEach>
		</div>
		<jsp:include page="sidebar.jsp" />
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>