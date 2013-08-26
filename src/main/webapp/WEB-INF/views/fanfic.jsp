<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="minHeadBody.jsp"></jsp:include>
<script src="<c:url value="/resources/js/jquery.raty.min.js" />"></script>
<script src="<c:url value="/resources/js/fanfic.js" />"></script>
</head>
<body>
	<div class="pageContainer">
		<div id="fanficId" value="${fanfic.getId()}"></div>
		<sec:authorize ifAllGranted="ROLE_USER">
			<div id="isLogged" value="true"></div>
		</sec:authorize>
		<sec:authorize ifAllGranted="ROLE_ANONYMOUS">
			<div id="isLogged" value="false"></div>
		</sec:authorize>
		<div id="fanficRating" value="${fanfic.getRating()}"></div>
		<div id="contextPath"
			value="${pageContext.servletContext.contextPath}"></div>

		<jsp:include page="menu.jsp" />
		<div class="span9">
			<div class="pageTitle">${fanfic.getName()}</div>
			<hr />
			Author: <a
				href="${pageContext.servletContext.contextPath}/user/${fanfic.getAuthor().getId()}">
				${fanfic.getAuthor().getUsername()} </a> <br />
			<table>
				<tr>
					<td>Rating:</td>
					<td>
						<div id="rating"></div>
					</td>
				</tr>
			</table>
			Categories:
			<c:forEach items="${fanfic.getCategories()}" var="category">
				<a
					href="${pageContext.servletContext.contextPath}/catalog/category/${category.getId()}">
					<spring:message code="${category.getName()}" />
				</a>
			</c:forEach>
			<br /> Tags:
			<c:forEach items="${fanfic.getTags()}" var="tag">
				<div class="tag">${tag.getName()}</div>
			</c:forEach>
			<br />
			<c:if test="${fanfic.getAuthor().getId().equals(currentUserId)}">
				<form
					action="${pageContext.servletContext.contextPath}/editFanfic/${fanfic.getId()}"
					method="get">
					<button>
						<spring:message code="edit" />
					</button>
				</form>
			</c:if>
			<hr />
			<div class="content">
				<button id="convertToPdf">
					<spring:message code="convertToPdf" />
				</button>
				<div id="contentTitle">Содержание:</div>
				<c:forEach items="${fanfic.getChapters()}" var="chapter">
					<a
						href="${pageContext.servletContext.contextPath}/chapter/${fanfic.getId()}/${chapter.getId()}">
						${chapter.getName()} </a>
					<c:if test="${fanfic.getAuthor().getId().equals(currentUserId)}">
						<form method="post"
							action="${pageContext.servletContext.contextPath}/removeChapter/${fanfic.getId()}/${chapter.getId()}">
							<button>
								<spring:message code="remove" />
							</button>
						</form>
					</c:if>
				</c:forEach>
				<c:if test="${fanfic.getAuthor().getId().equals(currentUserId)}">
					<a
						href="${pageContext.servletContext.contextPath}/addChapter/${fanfic.getId()}">
						<spring:message code="addChapter" />
					</a>
					<br />
				</c:if>
			</div>
			<hr />
			<c:if test="${noComments}">
				No comments.
			</c:if>
			<c:if test="${!noComments}">
				<div class="comments">
					Comments:
					<c:forEach items="${fanfic.getComments()}" var="comment">
						<div class="comment">
							<a
								href="${pageContext.servletContext.contextPath}/user/${fanfic.getAuthor().getId()}">
								${fanfic.getAuthor().getUsername()} </a>: ${comment.getContent()}
						</div>
					</c:forEach>
				</div>
			</c:if>
			<br />
			<hr />
			<sec:authorize ifAllGranted="ROLE_USER">
				<form
					action="${pageContext.servletContext.contextPath}/addComment/${fanfic.getId()}/${currentUserId}"
					method="post">
					<spring:message code="addComment" var="addCommentTranslate" />
					<div class="commentTextarea">
						<textarea name="newComment" placeholder="${addCommentTranslate}"></textarea>
					</div>
					<input type="submit" value="${addCommentTranslate}" />
				</form>
			</sec:authorize>
		</div>
		<jsp:include page="sidebar.jsp" />
	</div>
</body>
</html>