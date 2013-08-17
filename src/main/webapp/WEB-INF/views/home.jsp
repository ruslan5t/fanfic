<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	media="screen">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet" media="screen">
<script src="/resources/js/jquery-1.10.2.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="navbar">
		<div class="navbar-inner">
			<ul class="nav">
				<jsp:include page="menu.jsp"></jsp:include>
			</ul>
		</div>
	</div>
	<table>
		<tr>
			<td>
				<div class="pageTitle">Main page</div>
			</td>
		</tr>
		<tr>
			<td>
				<hr />
			</td>
		</tr>
		<c:forEach items="${bestFanfics}" var="fanfic">
			<tr>
				<td>
					<h2>
						<a href="/fanfic/fanfic/${fanfic.getId()}">${fanfic.getName()}</a>
					</h2>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
