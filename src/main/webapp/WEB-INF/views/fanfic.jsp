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
		<jsp:include page="menu.jsp"></jsp:include>
		<div class="row offset1">
			<h2>${fanfic.getName()}</h2>
			<button id="convertToPdf">
				<spring:message code="convertToPdf" />
			</button>
		</div>
		<c:if test="${fanfic.getAuthor().getId().equals(currentUserId)}">
			<div class="row offset1">
				<a
					href="${pageContext.servletContext.contextPath}/editFanfic/${fanfic.getId()}">
					<spring:message code="edit" />
				</a>
			</div>
			<div class="row offset1">
				<a
					href="${pageContext.servletContext.contextPath}/addChapter/${fanfic.getId()}">
					<spring:message code="addChapter" />
				</a>
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
						href="${pageContext.servletContext.contextPath}/catalog/category/${category.getId()}">
						<spring:message code="${category.getName()}" />
					</a>
				</c:forEach>
			</div>
		</div>
		<div class="row offset1">
			<div class="span1">Tags:</div>
			<div class="span2">
				<c:forEach items="${fanfic.getTags()}" var="tag">
					<div class="tag">${tag.getName()}</div>
				</c:forEach>
			</div>
		</div>
		<c:forEach items="${fanfic.getChapters()}" var="chapter">
			<div class="row offset1">
				<div class="span1">
					<a
						href="${pageContext.servletContext.contextPath}/chapter/${fanfic.getId()}/${chapter.getId()}">
						${chapter.getName()} </a>
				</div>
				<c:if test="${fanfic.getAuthor().getId().equals(currentUserId)}">
					<div class="span1">
						<form method="post"
							action="${pageContext.servletContext.contextPath}/removeChapter/${fanfic.getId()}/${chapter.getId()}">
							<button>
								<spring:message code="remove" />
							</button>
						</form>
					</div>
				</c:if>
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
		<sec:authorize ifAllGranted="ROLE_USER">
			<div class="row offset1">
				<spring:message code="addComment" />
				:
			</div>
			<div class="row offset1">
				<form
					action="${pageContext.servletContext.contextPath}/addComment/${fanfic.getId()}"
					method="post">
					<textarea name="newComment"></textarea>
					<spring:message code="addComment" var="addCommentTranslate" />
					<input type="submit" value="${addCommentTranslate}" />
				</form>
			</div>
		</sec:authorize>
	</div>
</body>
</html>