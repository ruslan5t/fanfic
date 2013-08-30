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
							<a tabindex="-1" href="<spring:url value='?theme=united' />">
								United
							</a>
						</li>
						<li>
							<a tabindex="-1" href="<spring:url value='?theme=cyborg' />">
								Cyborg
							</a>
						</li>
						<li>
							<a tabindex="-1" href="<spring:url value='?theme=cerulean' />">
								Cerulean
							</a>
						</li>
						<li>
							<a tabindex="-1" href="<spring:url value='?theme=amelia' />">
								Amelia
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
							<a tabindex="-1" href="<spring:url value='?lang=en' />">
								<img class="flag" src="<c:url value="/resources/images/english.gif" />" />
							</a>
						</li>
						<li>
							<a tabindex="-1" href="<spring:url value='?lang=ru' />">
								<img class="flag" src="<c:url value="/resources/images/russian.gif" />" />
							</a>
						</li>
					</ul>
				</li>
			</ul>
			<form action="${pageContext.servletContext.contextPath}/find/sendSearchRequest" method="get" 
					class="navbar-form navbar-left">
				<input type="text" class="form-control col-lg-8" name="searchRequest" />
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