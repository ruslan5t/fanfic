<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="navbar">
	<div class="navbar-inner">
		<ul class="nav">
			<li><a href="${pageContext.servletContext.contextPath}/"><spring:message
						code="mainPage" /></a></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown"><spring:message code="catalog" /><b
					class="caret"></b> </a>
				<ul class="dropdown-menu">
					<li><a
						href="${pageContext.servletContext.contextPath}/catalog">all</a></li>
					<li class="divider"></li>
					<c:forEach items="${allCategories}" var="category">
						<li><a
							href="${pageContext.servletContext.contextPath}/catalog/category/${category.getId()}">
								<spring:message code="${category.getName()}" />
						</a></li>
					</c:forEach>
				</ul></li>
			<c:if test="${isLogged}">
				<li><a
					href="${pageContext.servletContext.contextPath}/user/${currentUserId}">${currentUsername}</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/signOut">
						<spring:message code="signOut" />
				</a></li>
			</c:if>
			<c:if test="${!isLogged}">
				<li><a href="${pageContext.servletContext.contextPath}/signIn">
						<spring:message code="signIn" />
				</a></li>
			</c:if>
			<c:if test="${isAdmin}">
				<li><a
					href="${pageContext.servletContext.contextPath}/allUsers"> <spring:message
							code="allUsers" />
				</a></li>
			</c:if>
			<li><a href="${pageContext.servletContext.contextPath}/about">
					<spring:message code="about" />
			</a></li>
		</ul>
		<form class="navbar-form pull-right"
			action="${pageContext.servletContext.contextPath}/find" method="post">
			<ul class="nav">
				<li><a href="<spring:url value="?lang=en" />"> <img
						class="flag" src="<c:url value="/resources/images/english.gif" />" />
				</a></li>
				<li><a href="<spring:url value="?lang=ru" />"> <img
						class="flag" src="<c:url value="/resources/images/russian.gif" />" />
				</a></li>
			</ul>
			<input type="text" class="form-control" placeholder="Search"
				name="searchRequest">
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
</div>