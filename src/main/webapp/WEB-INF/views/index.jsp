<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="minHeadBody.jsp"></jsp:include>
<script src="<c:url value="/resources/js/jquery.raty.min.js" />"></script>
<script src="<c:url value="/resources/js/settingRating.js" />"></script>
</head>
<body>
	<sec:authorize ifAllGranted="ROLE_USER">
		<div id="isLogged" value="true"></div>
	</sec:authorize>
	<sec:authorize ifAllGranted="ROLE_ANONYMOUS">
		<div id="isLogged" value="false"></div>
	</sec:authorize>
	<div id="contextPath" value="${pageContext.servletContext.contextPath}"></div>
	<div class="pageContainer">
		<jsp:include page="menu.jsp" />
		<div class="span9">
			<div class="pageTitle">
				<spring:message code="mainPageTitle" />
			</div>
			<hr />
			<c:forEach items="${bestFanfics}" var="fanfic">
				<div class="postTitle">
					<a
						href="${pageContext.servletContext.contextPath}/fanfic/${fanfic.getId()}">
						${fanfic.getName()} </a>
				</div>
				<div class="author">
					<a
						href="${pageContext.servletContext.contextPath}/user/${fanfic.getAuthor().getId()}">
						${fanfic.getAuthor().getUsername()} </a>
				</div>
				<div class="description">${fanfic.getDescription()}</div>
				<div class="tags">
					<spring:message code="tags" />
					:
					<c:forEach items="${fanfic.getTags()}" var="tag">
						<div class="tag">
							<a
								href="${pageContext.servletContext.contextPath}/catalog/tag/${tag.getId()}">
								${ tag.getName() } </a>
						</div>
					</c:forEach>
				</div>
				<div class="rating" fanficId="${fanfic.getId()}" 
					rating="${fanfic.getRating()}">
				</div>
				<hr />
			</c:forEach>
		</div>
		<jsp:include page="sidebar.jsp" />
		
		<footer>
			<div class="row">
				<div class="span12">
					&copy; Copyright 2013.
				</div>
			</div>
		</footer>
	</div>
</body>
</html>
