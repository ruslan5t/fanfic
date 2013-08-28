<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<hr />
<c:forEach items="${allFanfics}" var="fanfic">
	<a
		href="${pageContext.servletContext.contextPath}/fanfic/${fanfic.getId()}">
		${fanfic.getName()} </a>
	<br />
</c:forEach>
<div id="pagination"></div>