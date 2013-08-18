<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/style.css" />" 
	rel="stylesheet" media="screen">
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
	<div class="navbar">
		<div class="navbar-inner">
			<ul class="nav">
				<jsp:include page="menu.jsp"></jsp:include>
			</ul>
		</div>
	</div>
	<table>
		<tr>
			<td>
				<h2>
					<a href="${pageContext.servletContext.contextPath}/user/${fanfic.getAuthor().getUsername()}">
						${fanfic.getAuthor().getUsername()}
					</a>
				</h2>
			</td>
		</tr>
		<tr>
			<td><h2>${fanfic.getName()}</h2></td>
		</tr>
		<tr>
			<td>
				Categories:
				<c:forEach items="${fanfic.getCategories()}" var="category">
					${category}
				</c:forEach>
			</td>
		</tr>
		<c:if test="${fanfic.getAuthor().getUsername().equals(currentUsername)}">
			<tr>
				<td>
					<a href="${pageContext.servletContext.contextPath}/addChapter/${fanfic.getId()}">Add chapter</a>
				</td>
			</tr>
		</c:if>
		<c:forEach items="${fanfic.getChapters()}" var="chapter">
			<tr>
				<td>
					<a href="${pageContext.servletContext.contextPath}/chapter/${fanfic.getId()}/${chapter.getName()}">
					${chapter.getName()}
					</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td>
				<hr />
			</td>
		</tr>
		<tr>
			<td>
				<div id="rating"></div>
			</td>
		</tr>
		<c:forEach items="${fanfic.getComments()}" var="comment">
			<tr>
				<td>
					${comment.getContent()}
				</td>
			</tr>
		</c:forEach>
		<c:if test="${isLogged}">
			<tr>
				<td>
					Add comment:
				</td>
			</tr>
			<tr>
				<td>
					<form action="${pageContext.servletContext.contextPath}/addComment/${fanfic.getId()}" method="post">
						<textarea name="newComment"></textarea>
						<input type="submit" value="Add comment" />
					</form>
				</td>
			</tr>
		</c:if>
	</table>
</body>
</html>