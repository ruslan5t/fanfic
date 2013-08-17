<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<li><a href="/fanfic/">Main page</a></li>
<li><a href="/fanfic/catalog">Catalog</a></li>
<c:if test="${isLogged}">
	<li><a href="/fanfic/user/${currentUsername}">${currentUsername}</a></li>
	<li><a href="/fanfic/signOut">Sign out</a></li>
</c:if>
<c:if test="${!isLogged}">
	<li><a href="/fanfic/signIn">Sign in</a></li>
</c:if>
<c:if test="${isAdmin}">
	<li><a href="/fanfic/allUsers">All users</a></li>
</c:if>