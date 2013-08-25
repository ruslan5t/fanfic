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
		<jsp:include page="menu.jsp"></jsp:include>
		<c:forEach items="${foundedFanfics}" var="foundedFanfic">
			<div class="row offset1">
				<a
					href="${pageContext.servletContext.contextPath}/fanfic/${foundedFanfic.getId()}">
					${foundedFanfic.getName()} </a>
			</div>
		</c:forEach>
	</div>
</body>
</html>