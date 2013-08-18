<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<li><a href="${pageContext.servletContext.contextPath}/">Main page</a></li>
<li><a href="${pageContext.servletContext.contextPath}/catalog">Catalog</a></li>
<c:if test="${isLogged}">
	<li><a href="${pageContext.servletContext.contextPath}/user/${currentUsername}">${currentUsername}</a></li>
	<li><a href="${pageContext.servletContext.contextPath}/signOut">Sign out</a></li>
</c:if>
<c:if test="${!isLogged}">
	<li><a href="${pageContext.servletContext.contextPath}/signIn">Sign in</a></li>
</c:if>
<c:if test="${isAdmin}">
	<li><a href="${pageContext.servletContext.contextPath}/allUsers">All users</a></li>
</c:if>