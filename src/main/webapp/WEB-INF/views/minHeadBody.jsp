<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="fanficLibrary" /></title>
<spring:theme code='style' var="style" />
<link href="<c:url value="/resources/css/${style}" />"
	rel="stylesheet" media="screen">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet" media="screen">
<script
	src="<c:url value="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.scrollUp.min.js" />"></script>
<script src="<c:url value="/resources/js/settingScrollUp.js" />"></script>
<link rel="shortcut icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/resources/images/favicon.ico" />