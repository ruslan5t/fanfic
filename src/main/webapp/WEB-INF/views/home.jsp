<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	media="screen">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet" media="screen">
<script src="<c:url value="/resources/js/jquery-1.10.2.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/tagcloud.jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/home.js" />"></script>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="row offset1">
		<div class="span2">
			<div class="pageTitle">Main page</div>
			<div class="row">
				<div class="span2">
					<hr />
				</div>
			</div>
			<c:forEach items="${bestFanfics}" var="fanfic">
				<div class="row">
					<div class="span2">
						<h2>
							<a
								href="${pageContext.servletContext.contextPath}/fanfic/${fanfic.getId()}">
								${fanfic.getName()} </a>
						</h2>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="span1 offset8">
			<div id="tagcloud">
				<ul>
					<li><a
						href="${pageContext.servletContext.contextPath}/catalog/comedy">
							comedy</a></li>
					<li><a
						href="${pageContext.servletContext.contextPath}/catalog/tragedy">
							tragedy</a></li>
					<li><a
						href="${pageContext.servletContext.contextPath}/catalog/drama">
							drama</a></li>
					<li><a
						href="${pageContext.servletContext.contextPath}/catalog/fantasy">
							fantasy</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
