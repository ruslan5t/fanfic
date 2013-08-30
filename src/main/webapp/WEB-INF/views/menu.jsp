<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<div class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a href="${pageContext.servletContext.contextPath}/"
				class="navbar-brand"> <spring:message code="mainPage" />
			</a>
		</div>
		<div class="navbar-collapse collapse" id="navbar-main">
			<ul class="nav navbar-nav">
				<li>
					<a href="${pageContext.servletContext.contextPath}/about">
						<spring:message code="about" />
					</a>
				</li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#" id="download">
						<spring:message code="themes" />
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu" aria-labelledby="download">
						<li>
							<a tabindex="-1" href="<spring:url value='?theme=black' />">
								<spring:message code="dark" />
							</a>
						</li>
						<li>
							<a tabindex="-1" href="<spring:url value='?theme=white' />">
								<spring:message code="light" />
							</a>
						</li>
					</ul>
				</li>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<li>
						<a 	href="${pageContext.servletContext.contextPath}/allUsers">
							<spring:message	code="allUsers" />
						</a>
					</li>
				</sec:authorize>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#" id="download">
						<spring:message code="language" />
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu" aria-labelledby="download">
						<li>
							<a tabindex="-1" href="<spring:url value="?lang=en" />">
								<img class="flag" src="<c:url value="/resources/images/english.gif" />" />
							</a>
						</li>
						<li>
							<a tabindex="-1" href="<spring:url value="?lang=ru" />">
								<img class="flag" src="<c:url value="/resources/images/russian.gif" />" />
							</a>
						</li>
					</ul>
				</li>
			</ul>
			<form action="${pageContext.servletContext.contextPath}/find" method="post" class="navbar-form navbar-left">
				<input type="text" class="form-control" name="searchRequest" />
				<button type="submit" class="btn btn-default">
					<spring:message code="find" />
				</button>
			</form>

			<ul class="nav navbar-nav navbar-right">
				<sec:authorize access="hasRole('ROLE_USER')">
					<li><a
						href="${pageContext.servletContext.contextPath}/user/${currentUserId}">
							${currentUsername} </a></li>
					<li><a href="<c:url value="/j_spring_security_logout" />">
							<spring:message code="signOut" />
					</a></li>
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
					<li>
						<a href="${pageContext.servletContext.contextPath}/signIn">
							<spring:message code="signIn" />
						</a>
					</li>
				</sec:authorize>
			</ul>

		</div>
	</div>
</div>

<!-- 
	
	
<div class="navbar">
	<div class="navbar-inner">
		<ul class="nav">
			<li><a href="${pageContext.servletContext.contextPath}/"><spring:message
						code="mainPage" /></a></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown"> <spring:message code="themes" /> <b
					class="caret"></b>
			</a>
				<ul class="dropdown-menu">
					<li><a href="<spring:url value='?theme=black' />"><spring:message
								code="dark" /></a></li>
					<li><a href="<spring:url value='?theme=white' />"><spring:message
								code="light" /></a></li>
				</ul></li>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li><a
					href="${pageContext.servletContext.contextPath}/allUsers"> <spring:message
							code="allUsers" />
				</a></li>
			</sec:authorize>
			<li><a href="${pageContext.servletContext.contextPath}/about">
					<spring:message code="about" />
			</a></li>
		</ul>

		<form class="navbar-form pull-right"
			action="${pageContext.servletContext.contextPath}/find" method="post">
			<ul class="nav account">
				<sec:authorize access="hasRole('ROLE_USER')">
					<li><a
						href="${pageContext.servletContext.contextPath}/user/${currentUserId}">${currentUsername}</a></li>
					<li><a href="<c:url value="/j_spring_security_logout" />">
							<spring:message code="signOut" />
					</a></li>
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
					<li><a href="${pageContext.servletContext.contextPath}/signIn">
							<spring:message code="signIn" />
					</a></li>
				</sec:authorize>
			</ul>

			<ul class="nav flags">
				<li><a href="<spring:url value="?lang=en" />"> <img
						class="flag" src="<c:url value="/resources/images/english.gif" />" />
				</a></li>
				<li><a href="<spring:url value="?lang=ru" />"> <img
						class="flag" src="<c:url value="/resources/images/russian.gif" />" />
				</a></li>
			</ul>
			<input type="text" class="form-control" name="searchRequest" />
			<button type="submit" class="btn btn-default">
				<spring:message code="find" />
			</button>
		</form>
	</div>
</div>

 -->