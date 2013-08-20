<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	media="screen">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet" media="screen">
<script src="<c:url value="/resources/js/jquery-1.10.2.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.raty.min.js" />"></script>
<script src="<c:url value="/resources/js/fanfic.js" />"></script>
</head>
<body>
	<div id="fanficId" value="${fanfic.getId()}"></div>
	<div id="isLogged" value="${isLogged}"></div>
	<div id="fanficRating" value="${fanfic.getRating()}"></div>
	<div id="contextPath" value="${pageContext.servletContext.contextPath}"></div>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="row offset1">
		<h2>${fanfic.getName()}</h2>
		<button id="convertToPdf">convert to pdf</button>
		<a id="hrefToConvertedFile"></a>
	</div>
	<c:if
		test="${fanfic.getAuthor().getId().equals(currentUserId)}">
		<div class="row offset1">
			<a 
				href="${pageContext.servletContext.contextPath}/editFanfic/${fanfic.getId()}">
				Edit
			</a>
		</div>
		<div class="row offset1">
			<a
				href="${pageContext.servletContext.contextPath}/addChapter/${fanfic.getId()}">
				Add chapter</a>
		</div>
	</c:if>
	<div class="row offset1">
		<div class="span1">Author:</div>
		<div class="span2">
			<a
				href="${pageContext.servletContext.contextPath}/user/${fanfic.getAuthor().getId()}">
				${fanfic.getAuthor().getUsername()} </a>
		</div>
	</div>
	<div class="row offset1">
		<div class="span1">Categories:</div>
		<div class="span2">
			<c:forEach items="${fanfic.getCategories()}" var="category">
				<a
					href="${pageContext.servletContext.contextPath}/catalog/${category}">
					${category} </a>
			</c:forEach>
		</div>
	</div>
	<div class="row offset1">
		<div class="span1">Tags:</div>
		<div class="span2">
			<c:forEach items="${fanfic.getTags()}" var="tag">
			${tag}
			</c:forEach>
		</div>
	</div>
	<c:forEach items="${fanfic.getChapters()}" var="chapter">
		<div class="row offset1">
			<a
				href="${pageContext.servletContext.contextPath}/chapter/${fanfic.getId()}/${chapter.getId()}">
				${chapter.getName()} </a>
		</div>
	</c:forEach>
	<div class="row offset1">
		<hr />
	</div>
	<div class="row offset1">
		<div id="rating"></div>
	</div>
	<c:forEach items="${fanfic.getComments()}" var="comment">
		<div class="row offset1">${comment.getContent()}</div>
	</c:forEach>
	<c:if test="${isLogged}">
		<div class="row offset1">Add comment:</div>
		<div class="row offset1">
			<form
				action="${pageContext.servletContext.contextPath}/addComment/${fanfic.getId()}"
				method="post">
				<textarea name="newComment"></textarea>
				<input type="submit" value="Add comment" />
			</form>
		</div>
	</c:if>
</body>
</html>