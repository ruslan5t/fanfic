<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="navbar">
	<div class="navbar-inner">
		<ul class="nav">
			<li><a href="${pageContext.servletContext.contextPath}/">Main
					page</a></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown"> Catalog<b class="caret"></b>
			</a>
				<ul class="dropdown-menu">
					<li><a
						href="${pageContext.servletContext.contextPath}/catalog">all</a></li>
					<li class="divider"></li>
					<li><a
						href="${pageContext.servletContext.contextPath}/catalog/comedy">comedy</a></li>
					<li><a
						href="${pageContext.servletContext.contextPath}/catalog/tragedy">tragedy</a></li>
					<li><a
						href="${pageContext.servletContext.contextPath}/catalog/drama">drama</a></li>
					<li><a
						href="${pageContext.servletContext.contextPath}/catalog/fantasy">fantasy</a></li>
				</ul></li>
			<c:if test="${isLogged}">
				<li><a
					href="${pageContext.servletContext.contextPath}/user/${currentUserId}">${currentUsername}</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/signOut">Sign
						out</a></li>
			</c:if>
			<c:if test="${!isLogged}">
				<li><a href="${pageContext.servletContext.contextPath}/signIn">Sign
						in</a></li>
			</c:if>
			<c:if test="${isAdmin}">
				<li><a
					href="${pageContext.servletContext.contextPath}/allUsers">All
						users</a></li>
			</c:if>
		</ul>
		<form class="navbar-form pull-right"
			action="${pageContext.servletContext.contextPath}/find">
			<input type="text" class="form-control" placeholder="Search"
				name="searchRequest">
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
</div>